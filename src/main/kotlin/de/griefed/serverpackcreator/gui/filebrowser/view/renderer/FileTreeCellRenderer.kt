package de.griefed.serverpackcreator.gui.filebrowser.view.renderer

import de.griefed.serverpackcreator.gui.filebrowser.model.FileBrowserModel
import de.griefed.serverpackcreator.gui.filebrowser.model.FileNode
import java.awt.Component
import java.io.File
import javax.swing.JLabel
import javax.swing.JTree
import javax.swing.tree.DefaultMutableTreeNode
import javax.swing.tree.TreeCellRenderer

class FileTreeCellRenderer(model: FileBrowserModel) : TreeCellRenderer {
    private val model: FileBrowserModel
    private val label: JLabel

    init {
        this.model = model
        label = JLabel(" ")
        label.isOpaque = true
    }

    override fun getTreeCellRendererComponent(
        tree: JTree,
        value: Any,
        selected: Boolean,
        expanded: Boolean,
        leaf: Boolean,
        row: Int,
        hasFocus: Boolean
    ): Component {
        val node: DefaultMutableTreeNode = value as DefaultMutableTreeNode
        val fileNode: FileNode = node.userObject as FileNode
        val file: File = fileNode.file
        label.icon = model.getFileIcon(file)
        label.text = model.getFileText(file)
        return label
    }
}