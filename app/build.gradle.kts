 import BuildType.Default.compileSdkVersion
//import BuildType.Production.compileSdkVersion

plugins {
    id(Plugin.application)
    id(Plugin.androidKotlin)
    id(Plugin.kotlinParcelize)
    id(Plugin.kotlinKapt)
    id(Plugin.hilt)
    id(Plugin.navArgs)
}

android {
    compileSdkVersion(BuildType.Default.compileSdkVersion)
    buildToolsVersion(BuildType.Default.buildToolsVersion)

    defaultConfig {
        applicationId = Build.applicationId
        versionCode = BuildType.Default.versionCode
        versionName = BuildType.Default.versionName

        minSdkVersion(BuildType.Default.minSdkVersion)
        targetSdkVersion(BuildType.Default.targetSdkVersion)

        testInstrumentationRunner = Config.testInstrumentationRunner
        buildConfigField(Build.stringType, AppProperties.APPLICATION_KEY_NAME, AppProperties.APPLICATION_KEY)
        buildConfigField(Build.stringType, AppProperties.APPLICATION_KEY_VALUE_NAME, AppProperties.APPLICATION_KEY_VALUE)
        buildConfigField(Build.stringType, AppProperties.ACCEPT_KEY, AppProperties.ACCEPT_KEY_VALUE)
        buildConfigField(Build.stringType, AppProperties.ACCEPT_VALUE, AppProperties.ACCEPT_VALUE_VALUE)
    }

    flavorDimensions(BuildType.flavorDimen)

    productFlavors {
        create(Flavors.develop) {
            dimension = BuildType.flavorDimen
            applicationIdSuffix = BuildType.Develop.suffixId
            versionNameSuffix = BuildType.Develop.suffixName

            targetSdkVersion(BuildType.Develop.targetSdkVersion)
            resValue(Build.stringResType, BuildType.Develop.appNameKey, BuildType.Develop.appName)
            buildConfigField(Build.stringType, BuildType.Develop.baseUrlName, BuildType.Develop.baseUrl)
        }
//
//        create(Flavors.staging) {
//            dimension = BuildType.flavorDimen
//            applicationIdSuffix = BuildType.Staging.suffixId
//            versionNameSuffix = BuildType.Staging.suffixName
//
//            targetSdkVersion(BuildType.Staging.targetSdkVersion)
//            resValue(Build.stringResType, BuildType.Staging.appNameKey, BuildType.Staging.appName)
//            buildConfigField(Build.stringType, BuildType.Staging.baseUrlName, BuildType.Staging.baseUrl)
//        }
//
//        create(Flavors.production) {
//            dimension = BuildType.flavorDimen
//
//            resValue(Build.stringResType, BuildType.Production.appNameKey, BuildType.Production.appName)
//            buildConfigField(Build.stringType, BuildType.Production.baseUrlName, BuildType.Production.baseUrl)
//        }
    }

    buildFeatures {
        viewBinding =  true
        dataBinding = true
    }

    buildTypes {
        getByName(BuildType.release) {
            isMinifyEnabled = false

            proguardFiles(
                getDefaultProguardFile(ProGuard.optimizeRule),
                ProGuard.optimizeFile
            )
        }

        getByName(BuildType.debug) {
            isMinifyEnabled = false
        }
    }

    compileOptions {
        sourceCompatibility(JavaVersion.VERSION_1_8)
        targetCompatibility(JavaVersion.VERSION_1_8)
    }

    kotlinOptions {
        jvmTarget = Build.jvmTarget
    }

    applicationVariants.all {
        outputs.all {
            val project = mergedFlavor.resValues[Build.resAppName]
            val buildType = buildType.name
            val version = versionName

            val outputName = "$project-$buildType-$version${Build.apkExtension}"

            file(File(outputName))
        }
    }
}

dependencies {

    implementation(Dependencies.coreKtx)
    implementation(Dependencies.Kotlin.kotlin)

    Dependencies.Kotlin.Coroutines.coroutinesDependencies.forEach { dependency ->
        implementation(dependency)
    }

    Dependencies.UI.uiDependencies.forEach { dependency ->
        implementation(dependency)
    }

    Dependencies.Jetpack.jetpackComponentDependencies.forEach { dependency ->
        implementation(dependency)
    }

    Dependencies.Network.networkDependencies.forEach { dependency ->
        implementation(dependency)
    }

    Dependencies.Facebook.facebookDependencies.forEach { dependency ->
        implementation(dependency)
    }

    Dependencies.Injection.injectionDependencies.forEach { dependency ->
        implementation(dependency)
    }

    Dependencies.Firebase.firebaseBOM.forEach { dependency ->
        implementation(platform(Dependencies.Firebase.firebaseBOM))
    }

    Dependencies.Firebase.firebaseAuth.forEach { dependency ->
        implementation(Dependencies.Firebase.firebaseAuth)
    }

    Dependencies.UI.flexbox.forEach { dependency ->
        implementation(Dependencies.UI.flexbox)
    }

    implementation(Dependencies.Logging.timber)
    implementation(Dependencies.Support.easyPermission)
    implementation("androidx.databinding:databinding-runtime:4.2.2")

    Dependencies.Media.mediaDependencies.forEach { dependency ->
        implementation(dependency)
    }

    Dependencies.kaptImp.forEach { kaptImp ->
        kapt(kaptImp)
    }

    implementation("androidx.databinding:databinding-runtime:4.2.2")




    testImplementation(Dependencies.Testing.jUnit)
    androidTestImplementation(Dependencies.Testing.jUnitTest)
    androidTestImplementation(Dependencies.Testing.espresso)



}