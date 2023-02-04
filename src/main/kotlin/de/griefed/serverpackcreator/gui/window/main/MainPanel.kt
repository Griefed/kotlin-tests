package de.griefed.serverpackcreator.gui.window.main

import de.griefed.larsonscanner.LarsonScanner
import de.griefed.serverpackcreator.gui.window.configs.Configs
import de.griefed.serverpackcreator.gui.window.logs.Logs
import de.griefed.serverpackcreator.gui.window.settings.SettingsEditor
import net.miginfocom.swing.MigLayout
import javax.swing.JPanel
import javax.swing.JScrollPane
import javax.swing.JTabbedPane

class MainPanel {
    val panel = JPanel()
    val tabs = JTabbedPane()
    val scroll = JScrollPane(panel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED)

    init {
        tabs.addTab("Configs", Configs().panel)
        tabs.addTab("Logs", Logs().panel)
        tabs.addTab("Settings", SettingsEditor().panel)
        panel.layout = MigLayout(
            "",
            "[grow]",
            "[center]0[bottom]"
        )
        panel.add(tabs,"grow,push")
        panel.add(LarsonScanner(),"south,height 40!")
        scroll.verticalScrollBar.unitIncrement = 5
    }
}