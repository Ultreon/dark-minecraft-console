package com.ultreon.mods.darkconsole

import com.formdev.flatlaf.extras.FlatAnimatedLafChange
import com.formdev.flatlaf.themes.FlatMacDarkLaf
import com.ultreon.mods.darkconsole.mixin.common.MinecraftServerGuiMixin
import com.ultreon.mods.darkconsole.server.gui.settings.SettingsDialog
import com.ultreon.mods.darkconsole.experiments.ThemeManagerExperiment
import net.minecraft.server.dedicated.DedicatedServer
import java.awt.event.ActionEvent
import javax.swing.AbstractAction
import javax.swing.JFrame
import javax.swing.JMenu
import javax.swing.JMenuBar

/**
 * Literally GUI Hooks.
 */
object Hooks {
    @ThemeManagerExperiment
    fun populateMenuBar(dedicatedServer: DedicatedServer, frame: JFrame, menuBar: JMenuBar) {
        val fileMenu = JMenu("File")
        fileMenu.add(object : AbstractAction("Settings") {
            override fun actionPerformed(e: ActionEvent) {
                SettingsDialog(frame, "Settings", true).isVisible = true
            }
        })
        fileMenu.addSeparator()
        fileMenu.add(object : AbstractAction("Stop Server") {
            override fun actionPerformed(e: ActionEvent) {
                dedicatedServer.execute { dedicatedServer.stopServer() }
            }
        })
        menuBar.add(fileMenu)
    }

    /**
     * Sets up theme in [MinecraftServerGuiMixin]
     */
    fun setupTheme() {
        JFrame.setDefaultLookAndFeelDecorated(true)
        FlatAnimatedLafChange.stop()
        FlatMacDarkLaf.setup()
    }
}