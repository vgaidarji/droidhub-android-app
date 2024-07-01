package com.vgaidarji.droidhub.api.di

import com.vgaidarji.droidhub.api.ApiTokenInterceptor
import com.vgaidarji.droidhub.api.GitHubUsersApi
import com.vgaidarji.droidhub.api.GitHubUsersApiClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory
import timber.log.Timber
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {
  private val gitHubApiBaseUrl = "https://api.github.com/"

  @ExperimentalSerializationApi
  @Singleton
  @Provides
  fun provideConverterFactory(): Converter.Factory {
    return Json {
      isLenient = true
      ignoreUnknownKeys = true
    }.asConverterFactory("application/json".toMediaType())
  }

  @Singleton
  @Provides
  fun provideOkHttpClient(): OkHttpClient {
    return OkHttpClient.Builder()
      .connectTimeout(10L, TimeUnit.SECONDS)
      .writeTimeout(10L, TimeUnit.SECONDS)
      .readTimeout(30L, TimeUnit.SECONDS)
      .addInterceptor(ApiTokenInterceptor())
      .addInterceptor(getHttpLoggingInterceptor())
      .build()
  }

  @Singleton
  @Provides
  fun provideRetrofit(okHttpClient: OkHttpClient, converterFactory: Converter.Factory): Retrofit {
    return Retrofit.Builder()
      .client(okHttpClient)
      .baseUrl(gitHubApiBaseUrl)
      .addConverterFactory(converterFactory)
      .build()
  }

  @Singleton
  @Provides
  fun provideUserApi(retrofit: Retrofit): GitHubUsersApi {
    return GitHubUsersApiClient(retrofit)
  }

  private fun getHttpLoggingInterceptor(): HttpLoggingInterceptor {
    val loggingInterceptor = HttpLoggingInterceptor { message ->
      Timber.tag("OkHttp").d(message)
    }.apply {
      level = HttpLoggingInterceptor.Level.BODY
    }
    return loggingInterceptor
  }
}
