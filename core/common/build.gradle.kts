plugins {
    alias(libs.plugins.abiao.jvm.library)
    alias(libs.plugins.abiao.hilt)
}

dependencies {
    implementation(libs.kotlinx.coroutines.core)
}