plugins {
    // this is necessary to avoid the plugins to be loaded multiple times
    // in each subproject's classloader
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.androidLibrary) apply false
    alias(libs.plugins.composeHotReload) apply false
    alias(libs.plugins.composeMultiplatform) apply false
    alias(libs.plugins.composeCompiler) apply false
    alias(libs.plugins.kotlinMultiplatform) apply false
    alias(libs.plugins.koin.compiler) apply false

    // SonarQube
    id("org.sonarqube") version "7.2.2.6593"
}

sonar {
  properties {
    property("sonar.projectKey", "Voxen-client")
    property("sonar.projectName", "Voxen-client")
  }
}