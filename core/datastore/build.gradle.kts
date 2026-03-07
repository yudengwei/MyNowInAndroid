plugins {
    alias(libs.plugins.abiao.android.library)
    alias(libs.plugins.abiao.hilt)
}

android {
    namespace = "com.abiao.samples.app.myandroid.core.datastore"
}

dependencies {
    api(libs.androidx.dataStore)
    api(projects.core.datastoreProto)
    api(projects.core.model)

    implementation(projects.core.common)
}