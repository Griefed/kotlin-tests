package de.griefed.serverpackcreator.gui.window.configs

import de.griefed.serverpackcreator.gui.window.components.TabPanel

class Configs : TabPanel() {
    init {
        tabs.addTab("Config 1", ConfigEditor().panel)
    }
}