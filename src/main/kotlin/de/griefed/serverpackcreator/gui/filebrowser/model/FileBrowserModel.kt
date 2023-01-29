package de.griefed.serverpackcreator.gui.filebrowser.model

import java.io.File
import java.util.*
import javax.swing.Icon
import javax.swing.tree.DefaultMutableTreeNode
import javax.swing.tree.DefaultTreeModel

class FileBrowserModel {
    private val rootManager: RootManager = RootManager()
    val model: DefaultTreeModel = createTreeModel()

    fun reload() {
        model.setRoot(updateRoot())
    }

    private fun createTreeModel(): DefaultTreeModel {
        return DefaultTreeModel(updateRoot())
    }

    private fun updateRoot(): DefaultMutableTreeNode {
        val root = rootManager.root
        addChildNodes(root)
        addGrandchildNodes(root)
        return root
    }

    fun addGrandchildNodes(root: DefaultMutableTreeNode) {
        val enumeration: Enumeration<*> = root.children()
        while (enumeration.hasMoreElements()) {
            val node = enumeration.nextElement() as DefaultMutableTreeNode
            addChildNodes(node)
        }
    }

    private fun addChildNodes(root: DefaultMutableTreeNode) {
        if (rootManager.isWindows) {
            val fileNode = root.userObject as FileNode
            val file = fileNode.file
            if (file.isDirectory) {
                val files = file.listFiles()
                files?.forEach { child ->
                    root.add(
                        DefaultMutableTreeNode(
                            FileNode(child)
                        )
                    )
                }
            }
        } else {
            val enumeration: Enumeration<*> = root.children()
            while (enumeration.hasMoreElements()) {
                val node = enumeration.nextElement() as DefaultMutableTreeNode
                val fileNode = node.userObject as FileNode
                val file = fileNode.file
                if (file.isDirectory) {
                    try {
                        file.listFiles()?.forEach { child ->
                            node.add(
                                DefaultMutableTreeNode(
                                    FileNode(child)
                                )
                            )
                        }
                    } catch (npe: NullPointerException) {
                        npe.printStackTrace()
                    }
                }
            }
        }
    }

    fun getFileIcon(file: File?): Icon {
        return rootManager.fileSystemView.getSystemIcon(file)
    }

    fun getFileText(file: File?): String {
        return rootManager.fileSystemView.getSystemDisplayName(file)
    }
}