package com.devspark.robototextview.gradle

import org.gradle.api.Plugin
import org.gradle.api.Project

class RobotoTextViewPlugin implements Plugin<Project> {

    @Override
    void apply(Project project) {
        if(project.pluginManager.findPlugin('com.android.application') == null) {
            project.logger.error('Error: plugin \'com.android.application\' required for \'com.devspark.robototextview.gradle-plugin\'')
            return
        }

        project.extensions.create("robototextview", RobotoTextViewPluginExtension)

        project.android.applicationVariants.all { variant ->
            variant.mergeAssets.doLast {
                def fonts = project.file("$variant.mergeAssets.outputDir/fonts")
                if (!fonts.exists()) {
                    project.logger.warn("Warning: " + fonts.absolutePath + " isn't exists")
                    return
                }

                def log = project.robototextview.log

                def included = project.robototextview.include
                if (included != null) {
                    fonts.eachFile { file ->
                        included.each { delete(project, file, !file.name.startsWith((it)), log) }
                    }
                }

                def excluded = project.robototextview.exclude
                if (excluded != null) {
                    fonts.eachFile { file ->
                        excluded.each { delete(project, file, file.name.startsWith((it)), log) }
                    }
                }
            }
        }
    }

    private static void delete(Project project, File file, boolean delete, boolean log) {
        if (!delete) {
            return
        }

        project.delete(file)

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

