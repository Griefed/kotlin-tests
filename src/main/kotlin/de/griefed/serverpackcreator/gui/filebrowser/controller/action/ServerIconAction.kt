package de.griefed.serverpackcreator.gui.filebrowser.controller.action

import java.awt.event.ActionEvent
import java.io.File
import javax.swing.AbstractAction

class ServerIconAction : AbstractAction() {
    private var icon: File? = null

    init {
        putValue(NAME, "Set as server-icon")
    }

    /**
     * Invoked when an action occurs.
     *
     * @param e
     */
    @Suppress("unused")
    override fun actionPerformed(e: ActionEvent) {
    }

    fun setIcon(file: File?) {
        icon = file
    }
}