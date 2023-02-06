package de.griefed.serverpackcreator.gui.window.main.control

import net.miginfocom.swing.MigLayout
import javax.swing.JButton
import javax.swing.JLabel
import javax.swing.JPanel
import javax.swing.border.CompoundBorder
import javax.swing.border.EmptyBorder
import javax.swing.border.EtchedBorder

class ControlPanel {
    val panel = JPanel()
    val statusPanel = StatusPanel()
    private val generate = JButton("GENERATE")
    private val serverPacks = JButton("SERVER PACKS")

    init {
        panel.layout = MigLayout(
            "",
            "0[200!]0[grow]0",
            "0[75!,bottom]10[75!,top]0"
        )
        panel.add(generate,"cell 0 0 1 1,grow,height 50!,width 150!,align center")
        panel.add(serverPacks,"cell 0 1 1 1,grow,height 50!,width 150!,align center")
        panel.add(statusPanel.panel,"cell 1 0 1 2,grow,push, h 160!")
        generate.addActionListener{ status() }
    }

    private fun status() {
        statusPanel.updateStatus("Fasel")
    }
}