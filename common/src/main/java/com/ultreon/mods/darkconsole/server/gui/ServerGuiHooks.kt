package com.ultreon.mods.darkconsole.server.gui

import com.ultreon.mods.darkconsole.server.gui.settings.SettingsDialog
import net.minecraft.server.dedicated.DedicatedServer
import java.awt.event.ActionEvent
import javax.swing.AbstractAction
import javax.swing.JFrame
import javax.swing.JMenu
import javax.swing.JMenuBar

object ServerGuiHooks {
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
}
