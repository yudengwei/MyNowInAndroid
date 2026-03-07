import org.apache.http.client.methods.RequestBuilder.options

plugins {
    alias(libs.plugins.abiao.jvm.library)
    alias(libs.plugins.protobuf)
}

protobuf {
    protoc {
        // 设置protoc编译器
        artifact = libs.protobuf.protoc.get().toString()
    }
    generateProtoTasks {
        all().configureEach {
            // 生成java和kotlin代码
            builtins {
                named("java") {
                    option("lite")
                }
                register("kotlin") {
                    // 生成lite runtime 版本，体积更小，更适合 Android。
                    option("lite")
                }
            }
        }
    }
}

dependencies {
    api(libs.protobuf.kotlin.lite)
}

