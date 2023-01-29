package de.griefed.serverpackcreator.gui.window.main

import de.griefed.serverpackcreator.gui.window.components.TabPanel
import de.griefed.serverpackcreator.gui.window.configs.Configs
import de.griefed.serverpackcreator.gui.window.logs.Logs
import de.griefed.serverpackcreator.gui.window.settings.Settings
import java.awt.Dimension

class MainPanel : TabPanel() {

    init {
        tabs.addTab("Configs", Configs().panel)
        tabs.addTab("Logs", Logs().panel)
        tabs.addTab("Settings", Settings().panel)
    }
}