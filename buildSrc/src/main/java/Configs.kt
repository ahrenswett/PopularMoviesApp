object Configs {
    val applicationId = "com.ninety8point6.moviequest"
    val compileSdkVersion = 31
    val minSdkVersion = 24
    val targetSdkVersion = 31
    val testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    private val versionMajor = 1
    private val versionMinor = 0
    private val versionPatch = 0

    private fun calculateVersionCode(): Int = versionMajor * 1000000 + versionMinor * 10000 + versionPatch * 100

    private fun calculateVersionName(): String = "${versionMajor}.${versionMinor}.${versionPatch}"

    val versionCode = calculateVersionCode()
    val versionName = calculateVersionName()
}