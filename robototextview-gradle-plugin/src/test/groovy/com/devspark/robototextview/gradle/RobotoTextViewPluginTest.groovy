package com.devspark.robototextview.gradle

import com.android.build.gradle.AppPlugin
import com.android.build.gradle.LibraryPlugin
import org.gradle.api.Project
import org.gradle.testfixtures.ProjectBuilder
import org.junit.Assert
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

    @Test
    void testApplyPluginOrder() {
        Project project = ProjectBuilder.builder().build()
        project.buildscript.repositories {
            jcenter()
        }
        project.buildscript.dependencies {
            classpath 'com.android.tools.build:gradle:2.2.0'
        }

        project.plugins.apply(RobotoTextViewPlugin)
        project.plugins.apply(AppPlugin)
    }

    @Test
    void testExtension() {
        Project project = ProjectBuilder.builder().build()
        project.buildscript.repositories {
            jcenter()
        }
        project.buildscript.dependencies {
            classpath 'com.android.tools.build:gradle:2.2.0'
        }

        project.plugins.apply(AppPlugin)
        project.plugins.apply(RobotoTextViewPlugin)

        project.robototextview {
            include 'include1', 'include2'
            exclude 'exclude1', 'exclude2'
            log true
        }

        Assert.assertTrue(project.robototextview.include == ['include1', 'include2'])
        Assert.assertTrue(project.robototextview.exclude == ['exclude1', 'exclude2'])
        Assert.assertTrue(project.robototextview.log)
    }
}
