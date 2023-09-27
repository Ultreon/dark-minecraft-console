package com.ultreon.mods.darkconsole

import com.ultreon.mods.darkconsole.server.gui.AppPrefs
import com.ultreon.mods.darkconsole.server.gui.intellijthemes.IJThemesPanel
import com.ultreon.mods.darkconsole.experiments.ThemeManagerExperiment
import dev.architectury.event.events.common.LifecycleEvent
import org.slf4j.Logger
import org.slf4j.LoggerFactory

/**
 * Dark Console Mod initializer and reference class.
 * @author Qboi
 * @since 0.1.0
 */
@OptIn(ThemeManagerExperiment::class)
object DarkConsoleMod {
    val themesPanel: IJThemesPanel = IJThemesPanel()
    val logger: Logger = LoggerFactory.getLogger("TemplateMod")

    /**
     * Initializer
     */
    fun init() {
        AppPrefs.init("com.ultreon.mods.darkconsole")
        LifecycleEvent.SETUP.register(::setup)
    }

    private fun setup() {
        // Do common setup here.
    }
}
