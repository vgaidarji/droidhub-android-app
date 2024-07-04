class AppConfig {
    companion object {
        const val VERSION_NAME = "1.0.0"
        const val VERSION_CODE = 1
        const val PACKAGE_NAME = "com.vgaidarji.droidhub"
        const val COMPILE_SDK_VERSION = 34
        const val TARGET_SDK_VERSION = 34
        const val MIN_SDK_VERSION = 23

        const val JVM_TARGET =  "1.8"
    }

    class Modules {
        companion object {
            const val APP = ":app"
            const val BASE = ":base"
            const val MODEL = ":model"

            const val CORE_REPOSITORY = ":core:repository"
            const val CORE_API = ":core:api"

            const val FEATURE_PROFILE = ":feature:profile"
        }
    }
}
