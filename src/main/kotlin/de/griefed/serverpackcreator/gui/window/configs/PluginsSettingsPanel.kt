package de.griefed.serverpackcreator.gui.window.configs

import net.miginfocom.swing.MigLayout
import javax.swing.BorderFactory
import javax.swing.JLabel
import javax.swing.JPanel
import javax.swing.border.CompoundBorder
import javax.swing.border.EmptyBorder
import javax.swing.border.EtchedBorder

class PluginsSettingsPanel : JPanel(MigLayout(
    "left,wrap",
    "0[left,grow,push]0", "30"
)) {

    init {
        for (plugin in 0..5) {
            add(createPanel("Plugin $plugin"), "cell 0 $plugin,grow")
        }
        isVisible = false
    }

    private fun createLabel(text: String): JLabel {
        val label = JLabel(text)
        label.border = CompoundBorder(EtchedBorder(), EmptyBorder(5, 5, 5, 5))
        return label
    }

    private fun createPanel(title: String): JPanel {
        val panel = JPanel()
        panel.layout = MigLayout(
            "",
            "0[grow,push]0[grow,push]0[grow,push]0[grow,push]0"
        )
        panel.border = BorderFactory.createTitledBorder(title)
        panel.add(createLabel("AAAA"))
        panel.add(createLabel("AAAA"))
        panel.add(createLabel("AAAA"))
        panel.add(createLabel("AAAA"))
        return panel
    }
}