package de.griefed.serverpackcreator.gui.filebrowser.runnable

import de.griefed.serverpackcreator.gui.filebrowser.model.FileBrowserModel
import de.griefed.serverpackcreator.gui.filebrowser.model.FileNode
import javax.swing.tree.DefaultMutableTreeNode

class AddNodes(model: FileBrowserModel, node: DefaultMutableTreeNode) : Runnable {
    private val node: DefaultMutableTreeNode
    private val model: FileBrowserModel

    init {
        this.model = model
        this.node = node
    }

    override fun run() {
        val fileNode: FileNode = node.userObject as FileNode
        if (fileNode.isGenerateGrandchildren) {
            model.addGrandchildNodes(node)
            fileNode.isGenerateGrandchildren = false
        }
    }
}