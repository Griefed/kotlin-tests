package de.griefed.serverpackcreator.gui.window.components

import javax.swing.JScrollPane
import javax.swing.JTextArea

class ScrollTextArea(
    val text: String,
    val textArea: JTextArea = JTextArea(text),
    verticalScrollbarVisibility: Int = VERTICAL_SCROLLBAR_AS_NEEDED,
    horizontalScrollbarVisibility: Int = HORIZONTAL_SCROLLBAR_NEVER
) : JScrollPane(verticalScrollbarVisibility, horizontalScrollbarVisibility) {
    init {
        textArea.lineWrap = true
        viewport.view = textArea
    }
}