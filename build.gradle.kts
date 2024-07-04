// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    // `id` but not `alias` due to https://github.com/gradle/gradle/issues/20084#issuecomment-1060822638
    id(libs.plugins.androidApplication.get().pluginId) apply false
    id(libs.plugins.jetbrainsKotlinAndroid.get().pluginId) apply false
    alias(libs.plugins.composeCompiler) apply false
    alias(libs.plugins.daggerHilt) apply false
}
