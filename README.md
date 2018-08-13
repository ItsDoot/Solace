# Solace [![Release](https://jitpack.io/v/xDotDash/Solace.svg)](https://jitpack.io/#xDotDash/Solace) [![](https://jitpack.io/v/xDotDash/Solace/month.svg)](https://jitpack.io/#xDotDash/Solace)

A Kotlin extension library for the Sponge ecosystem.

## FAQ

**Q: What's the difference between this library, and similar ones already available?**

In Solace *everything* is `inline`'d, making it easier for Ore reviewers to decompile and read projects which use Solace.

Also, even though Solace shades the Kotlin standard library and runtime into its jar,
    it does so without causing issues with other plugins who do the same, because it relocates Kotlin to `solace.kotlin`.
    
Then, the only additional thing that projects that use Solace have to do,
    is to relocate Kotlin references itself to `solace.kotiln`.

## Gradle Setup

To use Solace, your `build.gradle` should look *similar* to this:

```groovy
plugins {
    id "org.jetbrains.kotlin.jvm" version "<KOTLIN VERSION>"
    id "org.jetbrains.kotlin.kapt" version "<KOTLIN VERSION>"
    
    id "com.github.johnrengelman.shadow" version "2.0.4"
}

configurations {
    compile.extendsFrom(kapt)
    compile.extendsFrom(shadow)
}

repositories {
    mavenCentral()
    maven { url "https://repo.spongepowered.org/maven/" }
    maven { url 'https://jitpack.io' }
}

dependencies {
    compile "org.jetbrains.kotlin:kotlin-stdlib-jdk8:<KOTLIN VERSION>"
    
    kapt 'org.spongepowered:spongeapi:7.1.0-SNAPSHOT'
    
    compile 'com.github.xDotDash:solace:<LATEST SOLACE VERSION>'
}

shadowJar {
    configurations = [project.configurations.shadow]

    relocate 'kotlin', 'solace.kotlin'

    classifier = null
}

build.dependsOn(shadowJar)

compileKotlin {
    kotlinOptions {
        jvmTarget = "1.8"
    }
}
```