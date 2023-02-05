package de.griefed.serverpackcreator.gui.window.components

import java.awt.Font
import java.awt.font.TextAttribute
import java.util.*
import javax.swing.JLabel

class ElementLabel(text: String) : JLabel(text) {
    init {
        font = font.deriveFont(
            Collections.singletonMap(
                TextAttribute.WEIGHT,TextAttribute.WEIGHT_BOLD
            )
        )
    }
}