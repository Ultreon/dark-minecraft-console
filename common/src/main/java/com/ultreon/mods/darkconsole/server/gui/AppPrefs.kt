package com.ultreon.mods.darkconsole.server.gui

import java.util.prefs.Preferences

/**
 * @author Karl Tauber
 */
@Suppress("MemberVisibilityCanBePrivate")
object AppPrefs {
    private const val APP_ID: String = "com.ultreon.mods.darkconsole"
    const val KEY_LAF = "$APP_ID.laf"
    const val KEY_LAF_THEME = "$APP_ID.lafTheme"
    const val RESOURCE_PREFIX = "res:"
    const val FILE_PREFIX = "file:"
    const val THEME_UI_KEY = "$APP_ID.theme"
    lateinit var state: Preferences
        private set

    fun init(rootPath: String?) {
        state = Preferences.userRoot().node(rootPath)
    }
}