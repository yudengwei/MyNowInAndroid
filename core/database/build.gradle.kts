plugins {
    alias(libs.plugins.abiao.android.library)
}

android {
    namespace = "com.abiao.samples.app.myandroid.core.database"
}

dependencies {
    api(projects.core.model)
}