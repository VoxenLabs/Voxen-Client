plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.koin.compiler)
}

kotlin {
    sourceSets {
        androidMain.dependencies {
        }

        commonMain.dependencies {
            implementation(project.dependencies.platform(libs.koin.bom))
            implementation(libs.koin.core)
            implementation(libs.koin.annotations)
        }

        commonTest.dependencies {
            implementation(libs.kotlin.test)
            implementation(libs.koin.test)
        }

        jvmMain.dependencies {
        }
    }
}
