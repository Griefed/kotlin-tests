package de.griefed.serverpackcreator.gui.filebrowser.controller.action

import java.awt.Desktop
import java.awt.event.ActionEvent
import java.io.File
import java.io.IOException
import javax.swing.AbstractAction

class OpenAction : AbstractAction() {
    private var file: File? = null

    init {
        putValue(NAME, "Open")
    }

    /**
     * Invoked when an action occurs.
     *
     * @param e
     */
    override fun actionPerformed(e: ActionEvent) {
        if (Desktop.isDesktopSupported()) {
            val desktop = Desktop.getDesktop()
            if (desktop.isSupported(Desktop.Action.OPEN)) {
                try {
                    desktop.open(file)
                } catch (ex: IOException) {
                    ex.printStackTrace()
                }
            }
        }
    }

    fun setFile(file: File?) {
        this.file = file
    }
}