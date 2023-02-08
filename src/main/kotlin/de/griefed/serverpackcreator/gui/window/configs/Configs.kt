package de.griefed.serverpackcreator.gui.window.configs

import de.griefed.serverpackcreator.gui.window.components.TabPanel
import javax.swing.event.ChangeListener


class Configs : TabPanel() {

    val activeTab: ConfigEditor
        get() {
            return tabs.selectedComponent as ConfigEditor
        }
    val allTabs: MutableList<ConfigEditor>
        get() {
            val paneTabs = mutableListOf<ConfigEditor>()
            for (tab in 0..tabs.tabCount) {
                paneTabs.add(tabs.getTabComponentAt(tab) as ConfigEditor)
            }
            return paneTabs
        }

    init {
        tabs.addChangeListener {
            if (tabs.tabCount != 0) {
                for (tab in 0 until tabs.tabCount) {
                    (tabs.getComponentAt(tab) as ConfigEditor).title.closeButton.isVisible = false
                }
                activeTab.title.closeButton.isVisible = true
            }
        }
        for (i in 0..5) {
            addTab(this)
        }
        tabs.selectedIndex = 0
        activeTab.title.closeButton.isVisible = true
    }

    fun addTab(configs: Configs): ConfigEditor {
        val editor = ConfigEditor(configs)
        tabs.add(editor)
        tabs.setTabComponentAt(tabs.tabCount - 1, editor.title)
        return editor
    }
}