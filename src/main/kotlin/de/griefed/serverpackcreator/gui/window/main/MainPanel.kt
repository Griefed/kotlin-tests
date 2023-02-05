package de.griefed.serverpackcreator.gui.window.main

import de.griefed.larsonscanner.LarsonScanner
import de.griefed.serverpackcreator.gui.window.configs.Configs
import de.griefed.serverpackcreator.gui.window.logs.Logs
import de.griefed.serverpackcreator.gui.window.main.control.ControlPanel
import de.griefed.serverpackcreator.gui.window.settings.SettingsEditor
import net.miginfocom.swing.MigLayout
import javax.swing.JPanel
import javax.swing.JScrollPane
import javax.swing.JTabbedPane

class MainPanel {
    val panel = JPanel()
    val tabs = JTabbedPane()
    val scroll = JScrollPane(panel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED)
    val larsonScanner = LarsonScanner()
    val controlPanel = ControlPanel()

    init {
        tabs.addTab("Configs", Configs().panel)
        tabs.addTab("Logs", Logs().panel)
        tabs.addTab("Settings", SettingsEditor().panel)
        panel.layout = MigLayout(
            "",
            "0[grow]0",
            "0[top]0[bottom]0[bottom]0"
        )
        panel.add(tabs,"grow,push")
        panel.add(larsonScanner,"height 40!,growx, south")
        panel.add(controlPanel.panel,"height 160!,growx, south")
        scroll.verticalScrollBar.unitIncrement = 5
    }
}