package de.griefed.serverpackcreator.gui.window.components

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