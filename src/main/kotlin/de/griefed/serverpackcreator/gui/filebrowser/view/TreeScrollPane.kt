package de.griefed.serverpackcreator.gui.filebrowser.view

import de.griefed.serverpackcreator.gui.filebrowser.controller.FileSelectionListener
import de.griefed.serverpackcreator.gui.filebrowser.controller.TreeExpandListener
import de.griefed.serverpackcreator.gui.filebrowser.controller.TreeMouseListener
import de.griefed.serverpackcreator.gui.filebrowser.model.FileBrowserModel
import de.griefed.serverpackcreator.gui.filebrowser.view.renderer.FileTreeCellRenderer
import java.awt.Dimension
import java.io.File
import javax.swing.JScrollPane
import javax.swing.JTextField
import javax.swing.JTree
import javax.swing.text.Position
import javax.swing.tree.TreePath

class TreeScrollPane(
    frame: FileBrowserFrame,
    private val model: FileBrowserModel,
    private val field: JTextField
) {
    private val slashRegex: Regex = "/".toRegex()
    var tree: JTree = JTree(this.model.model)
    var scrollPane: JScrollPane

    init {
        tree.addTreeSelectionListener(
            FileSelectionListener(frame, this.model)
        )
        tree.addTreeWillExpandListener(
            TreeExpandListener(this.model)
        )
        tree.expandRow(1)
        tree.isRootVisible = true
        tree.cellRenderer = FileTreeCellRenderer(this.model)
        tree.showsRootHandles = true
        tree.addMouseListener(TreeMouseListener(tree, field))
        scrollPane = JScrollPane(tree)
        val preferredSize: Dimension = scrollPane.preferredSize
        val widePreferred = Dimension(
            300, preferredSize.getHeight().toInt()
        )
        scrollPane.preferredSize = widePreferred
        expandPaths()
    }

    private fun expandPaths() {
        if (field.text.isNotEmpty() && File(field.text).isDirectory) {
            val prefixes: Array<String> =
                field.text.replace("\\", "/").split(slashRegex).dropLastWhile { it.isEmpty() }
                    .toTypedArray()
            var path: TreePath? = null
            for (prefix in prefixes) {
                path = tree.getNextMatch(prefix, 0, Position.Bias.Backward)
                tree.expandPath(path)
            }
            if (path != null) {
                tree.selectionPath = path
            }
        }
    }
}