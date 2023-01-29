package de.griefed.serverpackcreator.gui.filebrowser.controller.action

import java.awt.event.ActionEvent
import java.io.File
import javax.swing.AbstractAction
import javax.swing.JTextField

class ModpackDirectoryAction(private val jTextField: JTextField) : AbstractAction() {
    private var directory: File? = null

    init {
        putValue(NAME, "Set as modpack directory")
    }

    override fun actionPerformed(e: ActionEvent) {
        jTextField.text = directory!!.absolutePath
    }

    fun setDirectory(file: File?) {
        directory = file
    }
}