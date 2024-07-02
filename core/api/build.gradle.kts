import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties

plugins {
    id(libs.plugins.androidLibrary.get().pluginId)
    id(libs.plugins.jetbrainsKotlinAndroid.get().pluginId)
    alias(libs.plugins.kotlinSerialization)
    id(libs.plugins.daggerHilt.get().pluginId)
    id(libs.plugins.kotlinKapt.get().pluginId)
    alias(libs.plugins.apollo)
}

android {
    namespace = "com.vgaidarji.droidhub.api"
    compileSdk = AppConfig.COMPILE_SDK_VERSION

    defaultConfig {
        minSdk = AppConfig.MIN_SDK_VERSION

        val githubApiToken: String = gradleLocalProperties(rootDir, providers).getProperty("GITHUB_API_TOKEN") ?: "\"\""
        buildConfigField("String", "GITHUB_API_TOKEN", githubApiToken)
    }

    buildFeatures {
        buildConfig = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = AppConfig.JVM_TARGET
    }
}

apollo {
    service("service") {
        packageName.set("com.vgaidarji.droidhub.api")
    }
}

dependencies {
    api(project(AppConfig.Modules.MODEL))

    implementation(libs.dagger.hilt)
    kapt(libs.dagger.hilt.compiler)

    implementation(libs.kotlinx.serialization)
    implementation(libs.retrofit)
    implementation(libs.retrofit.converter)
    implementation(libs.okhttp)
    implementation(libs.okhttp.loggingInterceptor)
    implementation(libs.timber)
    implementation(libs.coroutines.core)
    implementation(libs.apollo.runtime)
    implementation(libs.apollo.coroutines)
}
