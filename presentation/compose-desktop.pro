-ignorewarnings
-keep class io.ktor.serialization.kotlinx.json.*

# for some reason ProGuard removes Dispatchers.Main on Desktop.
# if more stuff gets removed, check here for more rules that could help:
# https://youtrack.jetbrains.com/issue/CMP-4288
-keep class * implements kotlinx.coroutines.internal.MainDispatcherFactory