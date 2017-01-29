package com.devspark.robototextview.gradle

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.internal.impldep.com.google.common.annotations.VisibleForTesting

class RobotoTextViewPlugin implements Plugin<Project> {

    @VisibleForTesting
    static final def WARNING_TOGETHER = 'Warning: Using "robototextview.include" and "robototextview.exclude" together isn\'t supported. ' +
            '"robototextview.include" will be used for this build'

    @Override
    void apply(Project project) {
        project.extensions.create("robototextview", RobotoTextViewPluginExtension)

        project.afterEvaluate {
            def applicationPluginApplied = project.pluginManager.findPlugin('com.android.application') != null;
            def libraryPluginApplied = project.pluginManager.findPlugin('com.android.library') != null;

            def variants
            if (applicationPluginApplied) {
                variants = project.android.applicationVariants
            } else if (libraryPluginApplied) {
                variants = project.android.libraryVariants
            } else {
                project.logger.error('Error: plugins "com.android.application" or "com.android.library" ' +
                        'required for "com.devspark.robototextview.gradle-plugin"')
                return
            }

            variants.all { variant ->
                variant.mergeAssets.doLast {
                    def fonts = project.file("$variant.mergeAssets.outputDir/fonts")
                    if (!fonts.exists()) {
                        project.logger.warn("Warning: $fonts.absolutePath isn't exists")
                        return
                    }

                    def log = project.robototextview.log

                    def included = project.robototextview.include
                    def excluded = project.robototextview.exclude
                    if (included != null && excluded != null) {
                        project.logger.warn(WARNING_TOGETHER)
                    }

                    if (included != null) {
                        fonts.eachFile { processIncluded(project, (it), included, log) }
                    } else if (excluded != null) {
                        fonts.eachFile { processExcluded(project, (it), excluded, log) }
                    }
                }
            }
        }
    }

    private static void processIncluded(project, file, included, log) {
        def keep = false
        included.each {
            if (isTargetFont(file, (it))) {
                keep = true
            }
        }

        if (!keep) {
            project.delete(file)
            reportResult(project, file, log)
        }
    }

    private static void processExcluded(project, file, excluded, log) {
        def delete = false
        excluded.each {
            if (isTargetFont(file, (it))) {
                delete = true
            }
        }

        if (delete) {
            project.delete(file)
            reportResult(project, file, log)
        }
    }

    private static def isTargetFont(file, fontName) {
        fontName = fontName == 'Roboto' ? 'Roboto-' : fontName
        return file.name.startsWith(fontName);
    }

    private static void reportResult(project, file, log) {
        if (file.exists()) {
            project.logger.error("Error: Failed to delete font $file.name")
        } else if (log) {
            project.logger.quiet("Note: Font $file.name was deleted")
        } else {
            project.logger.debug("Note: Font $file.name was deleted")
        }
    }

    static class RobotoTextViewPluginExtension {

        String[] exclude;

        String[] include;

        boolean log;
    }
}

