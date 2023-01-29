package de.griefed.serverpackcreator.gui.filebrowser.view.renderer

import java.text.SimpleDateFormat
import javax.swing.table.DefaultTableCellRenderer

class DateRenderer : DefaultTableCellRenderer() {
    private val formatter: SimpleDateFormat

    init {
        val pattern = "dd MMM yyyy"
        formatter = SimpleDateFormat(pattern)
    }

    override fun setValue(value: Any) {
        text = formatter.format(value)
    }
}