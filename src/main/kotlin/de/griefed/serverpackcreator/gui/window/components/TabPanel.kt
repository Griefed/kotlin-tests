package de.griefed.serverpackcreator.gui.window.components

import de.griefed.serverpackcreator.gui.window.configs.Configs
import de.griefed.serverpackcreator.gui.window.logs.Logs
import de.griefed.serverpackcreator.gui.window.settings.Settings
import java.awt.BorderLayout
import javax.swing.JPanel
import javax.swing.JTabbedPane

abstract class TabPanel {
    val panel = JPanel()
    val tabs = JTabbedPane()

    init {
        panel.layout = BorderLayout()
        panel.add(tabs)
    }
}