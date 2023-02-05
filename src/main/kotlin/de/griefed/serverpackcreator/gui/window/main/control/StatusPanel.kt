package de.griefed.serverpackcreator.gui.window.main.control

import net.miginfocom.swing.MigLayout
import javax.swing.JLabel
import javax.swing.JPanel

class StatusPanel {
    val panel = JPanel()
    private val statusLine0 = StatusLabel("...Adding Hidden Agendas   ",20)
    private val statusLine1 = StatusLabel("...Calculating Llama Expectoration Trajectory   ",50)
    private val statusLine2 = StatusLabel("...Depixelating Inner Mountain Surface Back Faces   ",100)
    private val statusLine3 = StatusLabel("...Graphing Whale Migration   ",150)
    private val statusLine4 = StatusLabel("...Removing Road Network Speed Bumps   ",200)
    private val statusLine5 = StatusLabel("...Reticulating Splines   ")

    init {
        panel.layout = MigLayout("fillx", "0[grow]0")
        statusLine0.horizontalAlignment = JLabel.LEFT
        statusLine1.horizontalAlignment = JLabel.LEFT
        statusLine2.horizontalAlignment = JLabel.LEFT
        statusLine3.horizontalAlignment = JLabel.LEFT
        statusLine4.horizontalAlignment = JLabel.LEFT
        statusLine5.horizontalAlignment = JLabel.LEFT
        panel.add(statusLine0,"cell 0 0,grow")
        panel.add(statusLine1,"cell 0 1,grow")
        panel.add(statusLine2,"cell 0 2,grow")
        panel.add(statusLine3,"cell 0 3,grow")
        panel.add(statusLine4,"cell 0 4,grow")
        panel.add(statusLine5,"cell 0 5,grow")
    }

    /**
     * Update the labels in the status panel.
     *
     * @param text The text to update the status with.
     * @author Griefed
     */
    fun updateStatus(text: String) {
        statusLine0.text = "${statusLine1.text}   "
        statusLine1.text = "${statusLine2.text}   "
        statusLine2.text = "${statusLine3.text}   "
        statusLine3.text = "${statusLine4.text}   "
        statusLine4.text = "${statusLine5.text}   "
        statusLine5.text = "$text   "
    }
}