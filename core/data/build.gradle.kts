plugins {
    alias(libs.plugins.abiao.android.library)
    alias(libs.plugins.abiao.hilt)
}

android {
    namespace = "com.abiao.samples.app.myandroid.core.data"
}

dependencies {
    api(projects.core.database)
    api(projects.core.common)
    api(projects.core.datastore)
}