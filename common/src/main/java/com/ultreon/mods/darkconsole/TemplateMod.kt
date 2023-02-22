package com.ultreon.mods.darkconsole

import com.ultreon.mods.darkconsole.server.gui.AppPrefs
import com.ultreon.mods.darkconsole.server.gui.intellijthemes.IJThemesPanel
import dev.architectury.event.events.common.LifecycleEvent
import org.slf4j.Logger
import org.slf4j.LoggerFactory

object TemplateMod {
    val themesPanel: IJThemesPanel = IJThemesPanel()
    val logger: Logger = LoggerFactory.getLogger("TemplateMod")

    fun init() {
        AppPrefs.init("com.ultreon.mods.darkconsole")
        LifecycleEvent.SETUP.register(TemplateMod::setup)
    }

    private fun setup() {
        // Do common setup here.
    }
}
