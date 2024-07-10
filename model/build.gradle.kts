plugins {
    id(libs.plugins.kotlinJvm.get().pluginId)
    alias(libs.plugins.kotlinSerialization)
}

dependencies {
    implementation(libs.kotlinx.serialization)
}
