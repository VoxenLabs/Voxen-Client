plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.koin.compiler)
}

kotlin {
    jvm()

    sourceSets {
        commonMain.dependencies {
            implementation(project.dependencies.platform(libs.koin.bom))
            implementation(libs.koin.core)
            implementation(libs.koin.annotations)
            implementation(libs.signalrkore)
        }

        commonTest.dependencies {
            implementation(libs.kotlin.test)
            implementation(libs.koin.test)
        }

        jvmMain.dependencies {
            implementation(libs.webrtc.java)
        }
    }
}
