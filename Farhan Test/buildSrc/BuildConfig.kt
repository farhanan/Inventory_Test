object Build {
    const val jvmTarget = "1.8"
    const val applicationId = "android.paninti.panintistore"

    const val resAppName = "app_name"
    const val apkExtension = ".apk"

    const val stringType = "String"
    const val intType = "Int"

    const val stringResType = "string"
    const val integerResType = "integer"
}

object BuildType {
    const val flavorDimen = "default_flavor"
    const val debug = "debug"
    const val release = "release"

    object Default {
        const val compileSdkVersion = 29
        const val buildToolsVersion = "29.0.3"
        const val versionName = "1.0"

        const val minSdkVersion = 21
        const val targetSdkVersion = 29
        const val versionCode = 1
    }

    object Develop {
        const val targetSdkVersion = 29

        const val suffixId = ".dev"
        const val suffixName = "-dev"

        const val baseUrlName = "BASE_URL"
        const val baseUrl = "\"https:/dev.api.paninti.com/\""

        const val resBaseUrlName = "res_base_url"
        const val resBaseUrl = "dev.api.paninti.com"

        const val appNameKey = "app_name"
        const val appName = "Paarenting Hub Dev"
    }

    object Staging {
        const val targetSdkVersion = 29

        const val suffixId = ".staging"
        const val suffixName = "-staging"

        const val baseUrlName = "BASE_URL"
        const val baseUrl = "\"https:/api.staging.paninti.com/\""

        const val appNameKey = "app_name"
        const val appName = "Parenting Hub Staging"
    }

    object Production {
        const val compileSdkVersion = 29
        const val buildToolsVersion = "29.0.3"
        const val versionName = "1.0"

        const val minSdkVersion = 21
        const val targetSdkVersion = 29
        const val versionCode = 1

        const val baseUrlName = "BASE_URL"
        const val baseUrl = "\"https:/paninti.com/api/\""

        const val appNameKey = "app_name"
        const val appName = "Parenting Hub"
    }
}

object ProGuard {
    const val optimizeRule = "proguard-android-optimize.txt"
    const val optimizeFile = "proguard-rules.pro"
}

object Flavors {
    const val develop = "dev"
    const val staging = "staging"
    const val production = "production"
}

object AppProperties {
    const val ACCEPT_KEY = "ACCEPT_KEY"
    const val ACCEPT_KEY_VALUE = "\"Accept\""
    const val ACCEPT_VALUE = "ACCEPT_VALUE"
    const val ACCEPT_VALUE_VALUE = "\"application/json\""
    const val APPLICATION_KEY_NAME = "APPLICATION_KEY_NAME"
    const val APPLICATION_KEY= "\"Application-Key\""
    const val APPLICATION_KEY_VALUE_NAME = "APPLICATION_KEY_VALUE_NAME"
    const val APPLICATION_KEY_VALUE = "\"Q5nGL97wRBFlgQ2WOG3XDnHhV33jFIYWdHKArumKS78YaSQA3U\""
}