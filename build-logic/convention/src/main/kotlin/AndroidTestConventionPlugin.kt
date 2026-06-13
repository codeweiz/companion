/*
 * Copyright 2022 microboat. All rights reserved.
 */
import com.android.build.api.dsl.TestExtension
import com.microboat.companion.configureGradleManagedDevices
import com.microboat.companion.configureKotlinAndroid
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.configure

class AndroidTestConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            apply(plugin = "com.android.test")

            extensions.configure<TestExtension> {
                configureKotlinAndroid(this)
                defaultConfig.targetSdk = 36
                configureGradleManagedDevices(this)
            }
        }
    }
}
