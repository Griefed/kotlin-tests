package de.griefed.serverpackcreator.gui.window.main

import de.griefed.larsonscanner.LarsonScanner
import de.griefed.serverpackcreator.gui.window.configs.Configs
import de.griefed.serverpackcreator.gui.window.logs.Logs
import de.griefed.serverpackcreator.gui.window.settings.SettingsEditor
import net.miginfocom.swing.MigLayout
import javax.swing.JPanel
import javax.swing.JTabbedPane

class MainPanel {
    val panel = JPanel()
    val tabs = JTabbedPane()

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
    }
}