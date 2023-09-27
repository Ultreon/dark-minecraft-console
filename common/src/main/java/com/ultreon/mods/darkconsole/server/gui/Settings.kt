package com.ultreon.mods.darkconsole.server.gui

import com.ultreon.mods.darkconsole.experiments.ThemeManagerExperiment

/**
 * Settings for the dark console.
 */
@ThemeManagerExperiment
object Settings {
    @ThemeManagerExperiment
    lateinit var theme: String
}