plugins {
    id(libs.plugins.androidLibrary.get().pluginId)
    id(libs.plugins.jetbrainsKotlinAndroid.get().pluginId)
    id(libs.plugins.kotlinKapt.get().pluginId)
    alias(libs.plugins.kotlinSerialization)
    alias(libs.plugins.daggerHilt)
}

android {
    namespace = "com.vgaidarji.droidhub.repository"
    compileSdk = AppConfig.COMPILE_SDK_VERSION

    defaultConfig {
        minSdk = AppConfig.MIN_SDK_VERSION
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = AppConfig.JVM_TARGET
    }
}

dependencies {
    api(project(AppConfig.Modules.MODEL))
    api(project(AppConfig.Modules.CORE_API))

    implementation(libs.dagger.hilt)
    kapt(libs.dagger.hilt.compiler)
}
