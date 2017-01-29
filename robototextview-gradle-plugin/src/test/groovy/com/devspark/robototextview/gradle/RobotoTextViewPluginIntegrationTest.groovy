package com.devspark.robototextview.gradle

import org.gradle.testkit.runner.BuildResult
import org.gradle.testkit.runner.GradleRunner
import org.gradle.testkit.runner.TaskOutcome
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TemporaryFolder

/**
 * Available font names:
 *     "Roboto-Black.ttf"
 *     "Roboto-BlackItalic.ttf"
 *     "Roboto-Bold.ttf"
 *     "Roboto-BoldItalic.ttf"
 *     "Roboto-Italic.ttf"
 *     "Roboto-Light.ttf"
 *     "Roboto-LightItalic.ttf"
 *     "Roboto-Medium.ttf"
 *     "Roboto-MediumItalic.ttf"
 *     "Roboto-Regular.ttf"
 *     "Roboto-Thin.ttf"
 *     "Roboto-ThinItalic.ttf"
 *     "RobotoCondensed-Bold.ttf"
 *     "RobotoCondensed-BoldItalic.ttf"
 *     "RobotoCondensed-Italic.ttf"
 *     "RobotoCondensed-Light.ttf"
 *     "RobotoCondensed-LightItalic.ttf"
 *     "RobotoCondensed-Regular.ttf"
 *     "RobotoMono-Bold.ttf"
 *     "RobotoMono-BoldItalic.ttf"
 *     "RobotoMono-Italic.ttf"
 *     "RobotoMono-Light.ttf"
 *     "RobotoMono-LightItalic.ttf"
 *     "RobotoMono-Medium.ttf"
 *     "RobotoMono-MediumItalic.ttf"
 *     "RobotoMono-Regular.ttf"
 *     "RobotoMono-Thin.ttf"
 *     "RobotoMono-ThinItalic.ttf"
 *     "RobotoSlab-Bold.ttf"
 *     "RobotoSlab-Light.ttf"
 *     "RobotoSlab-Regular.ttf"
 *     "RobotoSlab-Thin.ttf"
 */
class RobotoTextViewPluginIntegrationTest {

    @Rule
    public final TemporaryFolder testProjectDir = new TemporaryFolder();

    private File buildFile;

    @Before
    public void setup() throws IOException {
        buildFile = testProjectDir.newFile('build.gradle');
        buildFile << """
            buildscript {
                repositories {
                    jcenter()
                }
                dependencies {
                    classpath 'com.android.tools.build:gradle:2.2.0'
                }
            }

            plugins {
                id 'com.devspark.robototextview.gradle-plugin'
            }

            apply plugin: 'com.android.application'

            android {
                compileSdkVersion 25
                buildToolsVersion '25.0.2'

                defaultConfig {
                    applicationId 'com.devspark.robototextview.gradle.test'

                    minSdkVersion 9
                    targetSdkVersion 25
                    versionCode 1
                    versionName 'testApp'
                }
            }

            repositories {
                jcenter()
            }

            dependencies {
                compile 'com.github.johnkil.android-robototextview:robototextview:2.5.1'
            }
        """

        def sdkPath = System.getProperty('android.sdk.dir')
        File localProperties = testProjectDir.newFile('local.properties')
        localProperties << """
            sdk.dir=$sdkPath
        """

        testProjectDir.newFolder('src', 'main')
        File androidManifest = testProjectDir.newFile('src/main/AndroidManifest.xml')
        androidManifest << """
            <manifest package="com.devspark.robototextview.gradle.test">
                <application />
            </manifest>
        """
    }

    @Test
    void testExcludeOne() {
        buildFile << """
            robototextview {
                exclude 'RobotoMono-Regular'
                log true
            }
        """

        def result = GradleRunner.create()
                .withProjectDir(testProjectDir.root)
                .withArguments('assemble')
                .withPluginClasspath()
                .build()

        assertFontRemoved(result, "RobotoMono-Regular.ttf")

        assertFontNotRemoved(result, "Roboto-Black.ttf")
        assertFontNotRemoved(result, "Roboto-BlackItalic.ttf")
        assertFontNotRemoved(result, "Roboto-Bold.ttf")
        assertFontNotRemoved(result, "Roboto-BoldItalic.ttf")
        assertFontNotRemoved(result, "Roboto-Italic.ttf")
        assertFontNotRemoved(result, "Roboto-Light.ttf")
        assertFontNotRemoved(result, "Roboto-LightItalic.ttf")
        assertFontNotRemoved(result, "Roboto-Medium.ttf")
        assertFontNotRemoved(result, "Roboto-MediumItalic.ttf")
        assertFontNotRemoved(result, "Roboto-Regular.ttf")
        assertFontNotRemoved(result, "Roboto-Thin.ttf")
        assertFontNotRemoved(result, "Roboto-ThinItalic.ttf")
        assertFontNotRemoved(result, "RobotoCondensed-Bold.ttf")
        assertFontNotRemoved(result, "RobotoCondensed-BoldItalic.ttf")
        assertFontNotRemoved(result, "RobotoCondensed-Italic.ttf")
        assertFontNotRemoved(result, "RobotoCondensed-Light.ttf")
        assertFontNotRemoved(result, "RobotoCondensed-LightItalic.ttf")
        assertFontNotRemoved(result, "RobotoCondensed-Regular.ttf")
        assertFontNotRemoved(result, "RobotoMono-Bold.ttf")
        assertFontNotRemoved(result, "RobotoMono-BoldItalic.ttf")
        assertFontNotRemoved(result, "RobotoMono-Italic.ttf")
        assertFontNotRemoved(result, "RobotoMono-Light.ttf")
        assertFontNotRemoved(result, "RobotoMono-LightItalic.ttf")
        assertFontNotRemoved(result, "RobotoMono-Medium.ttf")
        assertFontNotRemoved(result, "RobotoMono-MediumItalic.ttf")
        assertFontNotRemoved(result, "RobotoMono-Thin.ttf")
        assertFontNotRemoved(result, "RobotoMono-ThinItalic.ttf")
        assertFontNotRemoved(result, "RobotoSlab-Bold.ttf")
        assertFontNotRemoved(result, "RobotoSlab-Light.ttf")
        assertFontNotRemoved(result, "RobotoSlab-Regular.ttf")
        assertFontNotRemoved(result, "RobotoSlab-Thin.ttf")

        Assert.assertEquals(result.task(":assemble").outcome, TaskOutcome.SUCCESS)
    }

    @Test
    void testExcludeFamilies() {
        buildFile << """
            robototextview {
                exclude 'RobotoMono', 'RobotoSlab'
                log true
            }
        """

        def result = GradleRunner.create()
                .withProjectDir(testProjectDir.root)
                .withArguments('assemble')
                .withPluginClasspath()
                .build()

        assertFontRemoved(result, "RobotoMono-Bold.ttf")
        assertFontRemoved(result, "RobotoMono-BoldItalic.ttf")
        assertFontRemoved(result, "RobotoMono-Italic.ttf")
        assertFontRemoved(result, "RobotoMono-Light.ttf")
        assertFontRemoved(result, "RobotoMono-LightItalic.ttf")
        assertFontRemoved(result, "RobotoMono-Medium.ttf")
        assertFontRemoved(result, "RobotoMono-MediumItalic.ttf")
        assertFontRemoved(result, "RobotoMono-Regular.ttf")
        assertFontRemoved(result, "RobotoMono-Thin.ttf")
        assertFontRemoved(result, "RobotoMono-ThinItalic.ttf")
        assertFontRemoved(result, "RobotoSlab-Bold.ttf")
        assertFontRemoved(result, "RobotoSlab-Light.ttf")
        assertFontRemoved(result, "RobotoSlab-Regular.ttf")
        assertFontRemoved(result, "RobotoSlab-Thin.ttf")

        assertFontNotRemoved(result, "Roboto-Black.ttf")
        assertFontNotRemoved(result, "Roboto-BlackItalic.ttf")
        assertFontNotRemoved(result, "Roboto-Bold.ttf")
        assertFontNotRemoved(result, "Roboto-BoldItalic.ttf")
        assertFontNotRemoved(result, "Roboto-Italic.ttf")
        assertFontNotRemoved(result, "Roboto-Light.ttf")
        assertFontNotRemoved(result, "Roboto-LightItalic.ttf")
        assertFontNotRemoved(result, "Roboto-Medium.ttf")
        assertFontNotRemoved(result, "Roboto-MediumItalic.ttf")
        assertFontNotRemoved(result, "Roboto-Regular.ttf")
        assertFontNotRemoved(result, "Roboto-Thin.ttf")
        assertFontNotRemoved(result, "Roboto-ThinItalic.ttf")
        assertFontNotRemoved(result, "RobotoCondensed-Bold.ttf")
        assertFontNotRemoved(result, "RobotoCondensed-BoldItalic.ttf")
        assertFontNotRemoved(result, "RobotoCondensed-Italic.ttf")
        assertFontNotRemoved(result, "RobotoCondensed-Light.ttf")
        assertFontNotRemoved(result, "RobotoCondensed-LightItalic.ttf")
        assertFontNotRemoved(result, "RobotoCondensed-Regular.ttf")

        Assert.assertEquals(result.task(":assemble").outcome, TaskOutcome.SUCCESS)
    }

    @Test
    void testIncludeOne() {
        buildFile << """
            robototextview {
                include 'Roboto-Regular'
                log true
            }
        """

        def result = GradleRunner.create()
                .withProjectDir(testProjectDir.root)
                .withArguments('assemble')
                .withPluginClasspath()
                .build()

        assertFontRemoved(result, "Roboto-Black.ttf")
        assertFontRemoved(result, "Roboto-BlackItalic.ttf")
        assertFontRemoved(result, "Roboto-Bold.ttf")
        assertFontRemoved(result, "Roboto-BoldItalic.ttf")
        assertFontRemoved(result, "Roboto-Italic.ttf")
        assertFontRemoved(result, "Roboto-Light.ttf")
        assertFontRemoved(result, "Roboto-LightItalic.ttf")
        assertFontRemoved(result, "Roboto-Medium.ttf")
        assertFontRemoved(result, "Roboto-MediumItalic.ttf")
        assertFontRemoved(result, "Roboto-Thin.ttf")
        assertFontRemoved(result, "Roboto-ThinItalic.ttf")
        assertFontRemoved(result, "RobotoCondensed-Bold.ttf")
        assertFontRemoved(result, "RobotoCondensed-BoldItalic.ttf")
        assertFontRemoved(result, "RobotoCondensed-Italic.ttf")
        assertFontRemoved(result, "RobotoCondensed-Light.ttf")
        assertFontRemoved(result, "RobotoCondensed-LightItalic.ttf")
        assertFontRemoved(result, "RobotoCondensed-Regular.ttf")
        assertFontRemoved(result, "RobotoMono-Bold.ttf")
        assertFontRemoved(result, "RobotoMono-BoldItalic.ttf")
        assertFontRemoved(result, "RobotoMono-Italic.ttf")
        assertFontRemoved(result, "RobotoMono-Light.ttf")
        assertFontRemoved(result, "RobotoMono-LightItalic.ttf")
        assertFontRemoved(result, "RobotoMono-Medium.ttf")
        assertFontRemoved(result, "RobotoMono-MediumItalic.ttf")
        assertFontRemoved(result, "RobotoMono-Regular.ttf")
        assertFontRemoved(result, "RobotoMono-Thin.ttf")
        assertFontRemoved(result, "RobotoMono-ThinItalic.ttf")
        assertFontRemoved(result, "RobotoSlab-Bold.ttf")
        assertFontRemoved(result, "RobotoSlab-Light.ttf")
        assertFontRemoved(result, "RobotoSlab-Regular.ttf")
        assertFontRemoved(result, "RobotoSlab-Thin.ttf")

        assertFontNotRemoved(result, "Roboto-Regular.ttf")

        Assert.assertEquals(result.task(":assemble").outcome, TaskOutcome.SUCCESS)
    }

    @Test
    void testIncludeFamilies() {
        buildFile << """
            robototextview {
                include 'Roboto', 'RobotoMono'
                log true
            }
        """

        def result = GradleRunner.create()
                .withProjectDir(testProjectDir.root)
                .withArguments('assemble')
                .withPluginClasspath()
                .build()

        assertFontRemoved(result, "RobotoCondensed-Bold.ttf")
        assertFontRemoved(result, "RobotoCondensed-BoldItalic.ttf")
        assertFontRemoved(result, "RobotoCondensed-Italic.ttf")
        assertFontRemoved(result, "RobotoCondensed-Light.ttf")
        assertFontRemoved(result, "RobotoCondensed-LightItalic.ttf")
        assertFontRemoved(result, "RobotoCondensed-Regular.ttf")
        assertFontRemoved(result, "RobotoSlab-Bold.ttf")
        assertFontRemoved(result, "RobotoSlab-Light.ttf")
        assertFontRemoved(result, "RobotoSlab-Regular.ttf")
        assertFontRemoved(result, "RobotoSlab-Thin.ttf")

        assertFontNotRemoved(result, "Roboto-Black.ttf")
        assertFontNotRemoved(result, "Roboto-BlackItalic.ttf")
        assertFontNotRemoved(result, "Roboto-Bold.ttf")
        assertFontNotRemoved(result, "Roboto-BoldItalic.ttf")
        assertFontNotRemoved(result, "Roboto-Italic.ttf")
        assertFontNotRemoved(result, "Roboto-Light.ttf")
        assertFontNotRemoved(result, "Roboto-LightItalic.ttf")
        assertFontNotRemoved(result, "Roboto-Medium.ttf")
        assertFontNotRemoved(result, "Roboto-MediumItalic.ttf")
        assertFontNotRemoved(result, "Roboto-Regular.ttf")
        assertFontNotRemoved(result, "Roboto-Thin.ttf")
        assertFontNotRemoved(result, "Roboto-ThinItalic.ttf")
        assertFontNotRemoved(result, "RobotoMono-Bold.ttf")
        assertFontNotRemoved(result, "RobotoMono-BoldItalic.ttf")
        assertFontNotRemoved(result, "RobotoMono-Italic.ttf")
        assertFontNotRemoved(result, "RobotoMono-Light.ttf")
        assertFontNotRemoved(result, "RobotoMono-LightItalic.ttf")
        assertFontNotRemoved(result, "RobotoMono-Medium.ttf")
        assertFontNotRemoved(result, "RobotoMono-MediumItalic.ttf")
        assertFontNotRemoved(result, "RobotoMono-Regular.ttf")
        assertFontNotRemoved(result, "RobotoMono-Thin.ttf")
        assertFontNotRemoved(result, "RobotoMono-ThinItalic.ttf")

        Assert.assertEquals(result.task(":assemble").outcome, TaskOutcome.SUCCESS)
    }

    @Test
    void testIncludeExclude() {
        buildFile << """
            robototextview {
                include 'Roboto'
                exclude 'RobotoMono'
                log true
            }
        """

        def result = GradleRunner.create()
                .withProjectDir(testProjectDir.root)
                .withArguments('assemble')
                .withPluginClasspath()
                .build()

        assertFontRemoved(result, "RobotoCondensed-Bold.ttf")
        assertFontRemoved(result, "RobotoCondensed-BoldItalic.ttf")
        assertFontRemoved(result, "RobotoCondensed-Italic.ttf")
        assertFontRemoved(result, "RobotoCondensed-Light.ttf")
        assertFontRemoved(result, "RobotoCondensed-LightItalic.ttf")
        assertFontRemoved(result, "RobotoCondensed-Regular.ttf")
        assertFontRemoved(result, "RobotoMono-Bold.ttf")
        assertFontRemoved(result, "RobotoMono-BoldItalic.ttf")
        assertFontRemoved(result, "RobotoMono-Italic.ttf")
        assertFontRemoved(result, "RobotoMono-Light.ttf")
        assertFontRemoved(result, "RobotoMono-LightItalic.ttf")
        assertFontRemoved(result, "RobotoMono-Medium.ttf")
        assertFontRemoved(result, "RobotoMono-MediumItalic.ttf")
        assertFontRemoved(result, "RobotoMono-Regular.ttf")
        assertFontRemoved(result, "RobotoMono-Thin.ttf")
        assertFontRemoved(result, "RobotoMono-ThinItalic.ttf")
        assertFontRemoved(result, "RobotoSlab-Bold.ttf")
        assertFontRemoved(result, "RobotoSlab-Light.ttf")
        assertFontRemoved(result, "RobotoSlab-Regular.ttf")
        assertFontRemoved(result, "RobotoSlab-Thin.ttf")


        assertFontNotRemoved(result, "Roboto-Black.ttf")
        assertFontNotRemoved(result, "Roboto-BlackItalic.ttf")
        assertFontNotRemoved(result, "Roboto-Bold.ttf")
        assertFontNotRemoved(result, "Roboto-BoldItalic.ttf")
        assertFontNotRemoved(result, "Roboto-Italic.ttf")
        assertFontNotRemoved(result, "Roboto-Light.ttf")
        assertFontNotRemoved(result, "Roboto-LightItalic.ttf")
        assertFontNotRemoved(result, "Roboto-Medium.ttf")
        assertFontNotRemoved(result, "Roboto-MediumItalic.ttf")
        assertFontNotRemoved(result, "Roboto-Regular.ttf")
        assertFontNotRemoved(result, "Roboto-Thin.ttf")
        assertFontNotRemoved(result, "Roboto-ThinItalic.ttf")

        Assert.assertTrue(result.output.contains(RobotoTextViewPlugin.WARNING_TOGETHER));

        Assert.assertEquals(result.task(":assemble").outcome, TaskOutcome.SUCCESS)
    }

    @Test
    void testIncludeItalicIssue() {
        buildFile << """
            robototextview {
                include 'Roboto-Bold'
                log true
            }
        """

        def result = GradleRunner.create()
                .withProjectDir(testProjectDir.root)
                .withArguments('assemble')
                .withPluginClasspath()
                .build()

        assertFontRemoved(result, "Roboto-Black.ttf")
        assertFontRemoved(result, "Roboto-BlackItalic.ttf")
        assertFontRemoved(result, "Roboto-BoldItalic.ttf")
        assertFontRemoved(result, "Roboto-Italic.ttf")
        assertFontRemoved(result, "Roboto-Light.ttf")
        assertFontRemoved(result, "Roboto-LightItalic.ttf")
        assertFontRemoved(result, "Roboto-Medium.ttf")
        assertFontRemoved(result, "Roboto-MediumItalic.ttf")
        assertFontRemoved(result, "Roboto-Regular.ttf")
        assertFontRemoved(result, "Roboto-Thin.ttf")
        assertFontRemoved(result, "Roboto-ThinItalic.ttf")
        assertFontRemoved(result, "RobotoCondensed-Bold.ttf")
        assertFontRemoved(result, "RobotoCondensed-BoldItalic.ttf")
        assertFontRemoved(result, "RobotoCondensed-Italic.ttf")
        assertFontRemoved(result, "RobotoCondensed-Light.ttf")
        assertFontRemoved(result, "RobotoCondensed-LightItalic.ttf")
        assertFontRemoved(result, "RobotoCondensed-Regular.ttf")
        assertFontRemoved(result, "RobotoMono-Bold.ttf")
        assertFontRemoved(result, "RobotoMono-BoldItalic.ttf")
        assertFontRemoved(result, "RobotoMono-Italic.ttf")
        assertFontRemoved(result, "RobotoMono-Light.ttf")
        assertFontRemoved(result, "RobotoMono-LightItalic.ttf")
        assertFontRemoved(result, "RobotoMono-Medium.ttf")
        assertFontRemoved(result, "RobotoMono-MediumItalic.ttf")
        assertFontRemoved(result, "RobotoMono-Regular.ttf")
        assertFontRemoved(result, "RobotoMono-Thin.ttf")
        assertFontRemoved(result, "RobotoMono-ThinItalic.ttf")
        assertFontRemoved(result, "RobotoSlab-Bold.ttf")
        assertFontRemoved(result, "RobotoSlab-Light.ttf")
        assertFontRemoved(result, "RobotoSlab-Regular.ttf")
        assertFontRemoved(result, "RobotoSlab-Thin.ttf")

        assertFontNotRemoved(result, "Roboto-Bold.ttf")

        Assert.assertEquals(result.task(":assemble").outcome, TaskOutcome.SUCCESS)
    }

    @Test
    void testExcludeItalicIssue() {
        buildFile << """
            robototextview {
                exclude 'Roboto-Bold'
                log true
            }
        """

        def result = GradleRunner.create()
                .withProjectDir(testProjectDir.root)
                .withArguments('assemble')
                .withPluginClasspath()
                .build()

        assertFontRemoved(result, "Roboto-Bold.ttf")

        assertFontNotRemoved(result, "Roboto-Black.ttf")
        assertFontNotRemoved(result, "Roboto-BlackItalic.ttf")
        assertFontNotRemoved(result, "Roboto-BoldItalic.ttf")
        assertFontNotRemoved(result, "Roboto-Italic.ttf")
        assertFontNotRemoved(result, "Roboto-Light.ttf")
        assertFontNotRemoved(result, "Roboto-LightItalic.ttf")
        assertFontNotRemoved(result, "Roboto-Medium.ttf")
        assertFontNotRemoved(result, "Roboto-MediumItalic.ttf")
        assertFontNotRemoved(result, "Roboto-Regular.ttf")
        assertFontNotRemoved(result, "Roboto-Thin.ttf")
        assertFontNotRemoved(result, "Roboto-ThinItalic.ttf")
        assertFontNotRemoved(result, "RobotoCondensed-Bold.ttf")
        assertFontNotRemoved(result, "RobotoCondensed-BoldItalic.ttf")
        assertFontNotRemoved(result, "RobotoCondensed-Italic.ttf")
        assertFontNotRemoved(result, "RobotoCondensed-Light.ttf")
        assertFontNotRemoved(result, "RobotoCondensed-LightItalic.ttf")
        assertFontNotRemoved(result, "RobotoCondensed-Regular.ttf")
        assertFontNotRemoved(result, "RobotoMono-Bold.ttf")
        assertFontNotRemoved(result, "RobotoMono-BoldItalic.ttf")
        assertFontNotRemoved(result, "RobotoMono-Italic.ttf")
        assertFontNotRemoved(result, "RobotoMono-Light.ttf")
        assertFontNotRemoved(result, "RobotoMono-LightItalic.ttf")
        assertFontNotRemoved(result, "RobotoMono-Medium.ttf")
        assertFontNotRemoved(result, "RobotoMono-MediumItalic.ttf")
        assertFontNotRemoved(result, "RobotoMono-Regular.ttf")
        assertFontNotRemoved(result, "RobotoMono-Thin.ttf")
        assertFontNotRemoved(result, "RobotoMono-ThinItalic.ttf")
        assertFontNotRemoved(result, "RobotoSlab-Bold.ttf")
        assertFontNotRemoved(result, "RobotoSlab-Light.ttf")
        assertFontNotRemoved(result, "RobotoSlab-Regular.ttf")
        assertFontNotRemoved(result, "RobotoSlab-Thin.ttf")

        Assert.assertEquals(result.task(":assemble").outcome, TaskOutcome.SUCCESS)
    }

    static void assertFontRemoved(BuildResult result, String fontName) {
        Assert.assertTrue("assertFontRemoved: $fontName with output:\n$result.output",
                result.output.contains("Note: Font $fontName was deleted"));
    }

    static void assertFontNotRemoved(BuildResult result, String fontName) {
        Assert.assertFalse("assertFontNotRemoved: $fontName with output:\n$result.output",
                result.output.contains("Note: Font $fontName was deleted"));
    }
}
