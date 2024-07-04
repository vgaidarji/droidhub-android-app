package com.vgaidarji.droidhub.api

import okhttp3.Interceptor
import okhttp3.Response

class ApiTokenInterceptor : Interceptor {
    companion object {
        private const val AUTHORIZATION_HEADER = "Authorization"
    }

    override fun intercept(chain: Interceptor.Chain): Response {
        val token = BuildConfig.GITHUB_API_TOKEN
        val builder = chain.request().newBuilder()
        if (token.isNotEmpty()) {
            builder.addHeader(AUTHORIZATION_HEADER, "token $token")
        }
        return chain.proceed(builder.build())
    }
}
