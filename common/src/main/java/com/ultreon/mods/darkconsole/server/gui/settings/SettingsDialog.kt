@file:Suppress("unused")

package com.ultreon.mods.darkconsole.server.gui.settings

import com.ultreon.mods.darkconsole.server.gui.StandardDialog
import com.ultreon.mods.darkconsole.experiments.ThemeManagerExperiment
import java.awt.BorderLayout
import java.awt.Dialog
import java.awt.Dimension
import java.awt.Frame
import javax.swing.JPanel

/**
 * Settings dialog, yeah, literally.
 */
@ThemeManagerExperiment
class SettingsDialog : StandardDialog {
    private lateinit var settingsPanel: SettingsPanel

    /**
     * Construct the dialog with a frame as parent.
     */
    @ThemeManagerExperiment
    constructor(owner: Frame? = null, title: String?, modal: Boolean) : super(owner, title, modal) {
        contentPane = createContent()
    }

    /**
     * Construct the dialog with another dialog as parent.
     */
    @ThemeManagerExperiment
    constructor(owner: Dialog?, title: String?, modal: Boolean) : super(owner, title, modal) {
        contentPane = createContent()
    }

    private fun createContent(): JPanel {
        minimumSize = Dimension(400, 400)

        val content = JPanel(BorderLayout())
        settingsPanel = SettingsPanel()
        content.add(settingsPanel, BorderLayout.CENTER)
        content.add(createButtonPanel(), BorderLayout.SOUTH)

        return content
    }
}