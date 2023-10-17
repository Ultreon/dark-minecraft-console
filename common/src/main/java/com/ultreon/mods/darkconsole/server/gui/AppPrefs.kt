package com.ultreon.mods.darkconsole.server.gui

import com.ultreon.mods.darkconsole.experiments.ThemeManagerExperiment
import java.util.prefs.Preferences

/**
 * @author Karl Tauber (drastically modified by XyperCode)
 */
@ThemeManagerExperiment
@Suppress("MemberVisibilityCanBePrivate")
object AppPrefs {
    private const val APP_ID: String = "com.ultreon.mods.darkconsole"
    @ThemeManagerExperiment const val KEY_LAF = "$APP_ID.laf"
    @ThemeManagerExperiment const val KEY_LAF_THEME = "$APP_ID.lafTheme"
    @ThemeManagerExperiment const val RESOURCE_PREFIX = "res:"
    @ThemeManagerExperiment const val FILE_PREFIX = "file:"
    @ThemeManagerExperiment const val THEME_UI_KEY = "$APP_ID.theme"

    @ThemeManagerExperiment
    lateinit var state: Preferences
        private set

    /**
     * App preferences initialization.
     */
    @ThemeManagerExperiment
    fun init(rootPath: String?) {
        state = Preferences.userRoot().node(rootPath)
    }
}