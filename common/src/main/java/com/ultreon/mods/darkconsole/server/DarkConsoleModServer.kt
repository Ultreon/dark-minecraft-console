package com.ultreon.mods.darkconsole.server

import com.ultreon.mods.darkconsole.experiments.ThemeManagerExperiment
import com.ultreon.mods.darkconsole.server.gui.AppPrefs
import java.awt.Font

/**
 * Dark Console Mod - Server side initialization.
 * @author XyperCode
 * @since 0.1.0
 */
object DarkConsoleModServer {
    lateinit var font: Font

    /**
     * Initializer
     */
    @OptIn(ThemeManagerExperiment::class)
    fun init() {
        AppPrefs.init("com.ultreon.mods.darkconsole")
    }
}
