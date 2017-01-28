package com.devspark.robototextview.gradle

import com.android.build.gradle.AppPlugin
import com.android.build.gradle.LibraryPlugin
import org.gradle.api.Project
import org.gradle.testfixtures.ProjectBuilder
import org.junit.Test

class RobotoTextViewPluginTest {

    @Test
    void testApply() {
        Project project = ProjectBuilder.builder().build()
        project.buildscript.repositories {
            jcenter()
        }
        project.buildscript.dependencies {
            classpath 'com.android.tools.build:gradle:2.2.0'
        }

        project.plugins.apply(AppPlugin)
        project.plugins.apply(RobotoTextViewPlugin)
    }

    @Test
    void testApplyWithLibraryPlugin() {
        Project project = ProjectBuilder.builder().build()
        project.buildscript.repositories {
            jcenter()
        }
        project.buildscript.dependencies {
            classpath 'com.android.tools.build:gradle:2.2.0'
        }

        project.plugins.apply(LibraryPlugin)
        project.plugins.apply(RobotoTextViewPlugin)
    }

    @Test
    void testApplyWithoutAndroidPlugin() {
        Project project = ProjectBuilder.builder().build()
        project.plugins.apply(RobotoTextViewPlugin)
    }
}
