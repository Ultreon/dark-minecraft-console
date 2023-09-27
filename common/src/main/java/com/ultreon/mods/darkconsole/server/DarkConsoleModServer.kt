package com.ultreon.mods.darkconsole.server

import com.ultreon.mods.darkconsole.DarkConsoleMod
import dev.architectury.event.events.common.LifecycleEvent
import java.awt.Font
import java.awt.GraphicsEnvironment

/**
 * Dark Console Mod - Server side initialization.
 * @author Qboi
 * @since 0.1.0
 */
object DarkConsoleModServer {
    lateinit var font: Font

    /**
     * Initializer
     */
    fun init() {
        LifecycleEvent.SETUP.register(::setup)
    }

    private fun setup() {
        // No setup (yet)
    }
}
