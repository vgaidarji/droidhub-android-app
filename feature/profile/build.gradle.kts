plugins {
    id(libs.plugins.androidLibrary.get().pluginId)
    id(libs.plugins.jetbrainsKotlinAndroid.get().pluginId)
    alias(libs.plugins.composeCompiler)
    id(libs.plugins.daggerHilt.get().pluginId)
    id(libs.plugins.kotlinKapt.get().pluginId)
}

android {
    namespace = "com.vgaidarji.droidhub.profile"
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
    buildFeatures {
        compose = true
    }
}

dependencies {
    implementation(project(AppConfig.Modules.BASE))

    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.fragment.ktx)
    implementation(libs.androidx.ui.android)

    implementation(libs.dagger)
    implementation(libs.androidx.material3.android)
    implementation(libs.androidx.lifecycle.runtime.compose.android)
    implementation(libs.androidx.ui.tooling.preview.android)
    debugImplementation(libs.androidx.ui.tooling)
    implementation(libs.coil)

    implementation(libs.timber)

    kapt(libs.dagger.compiler)
    implementation(libs.dagger.hilt)
    kapt(libs.dagger.hilt.compiler)
}
