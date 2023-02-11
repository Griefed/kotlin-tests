package de.griefed.serverpackcreator.gui.filebrowser.controller

import de.griefed.serverpackcreator.gui.filebrowser.model.FileNode
import de.griefed.serverpackcreator.gui.filebrowser.view.SelectionPopMenu
import de.griefed.serverpackcreator.gui.window.configs.ConfigsTab
import java.awt.event.MouseEvent
import java.io.File
import javax.swing.JTable

class TableMouseListener(
    private val jTable: JTable, configsTab: ConfigsTab
) : SelectionPopMenu(configsTab) {

    override fun mousePressed(mouseEvent: MouseEvent) {
        if (mouseEvent.button == MouseEvent.BUTTON3) {
            val r: Int = jTable.rowAtPoint(mouseEvent.point)
            if (r >= 0 && r < jTable.rowCount) {
                jTable.setRowSelectionInterval(r, r)
            } else {
                jTable.clearSelection()
            }
            val rowindex: Int = jTable.selectedRow
            if (rowindex >= 0) {
                val fileNode: FileNode = jTable.model.getValueAt(rowindex, 5) as FileNode
                val file: File = fileNode.file
                show(jTable, mouseEvent.x, mouseEvent.y, file)
            }
        }
    }
}