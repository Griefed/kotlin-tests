package de.griefed.serverpackcreator.gui.window.configs

import net.miginfocom.swing.MigLayout
import javax.swing.JLabel
import javax.swing.JPanel
import javax.swing.border.CompoundBorder
import javax.swing.border.EmptyBorder
import javax.swing.border.EtchedBorder

class PackConfig {
    val panel = JPanel()

    init {
        panel.layout = MigLayout()
        panel.add(createLabel("West Panel"),    "dock west");
        panel.add(createLabel("North 1 Panel"), "dock north");
        panel.add(createLabel("North 2 Panel"), "dock north");
        panel.add(createLabel("South Panel"),   "dock south");
        panel.add(createLabel("East Panel"),    "dock east");
        panel.add(createLabel("Center Panel"),  "grow, push");
    }

    private fun createLabel(text: String): JLabel? {
        val label = JLabel(text)
        label.horizontalAlignment = JLabel.CENTER
        label.border = CompoundBorder(EtchedBorder(), EmptyBorder(5, 10, 5, 10))
        return label
    }
}