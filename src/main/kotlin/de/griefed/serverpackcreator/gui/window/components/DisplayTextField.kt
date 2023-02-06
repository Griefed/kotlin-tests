package de.griefed.serverpackcreator.gui.window.components

import javax.swing.JTextField

class DisplayTextField(text: String) : JTextField(text) {
    init {
        isEditable = false
    }
}