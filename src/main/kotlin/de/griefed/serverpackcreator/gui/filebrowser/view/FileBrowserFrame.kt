package de.griefed.serverpackcreator.gui.filebrowser.view

import de.griefed.serverpackcreator.gui.filebrowser.model.FileBrowserModel
import de.griefed.serverpackcreator.gui.filebrowser.model.FileNode
import java.awt.BorderLayout
import java.awt.event.WindowAdapter
import java.awt.event.WindowEvent
import javax.swing.JFrame
import javax.swing.JPanel
import javax.swing.JSplitPane
import javax.swing.JTextField
import javax.swing.tree.DefaultMutableTreeNode

class FileBrowserFrame(
    private val model: FileBrowserModel,
    field: JTextField
) {
    private var desktopButtonPanel: DesktopButtonPanel
    private var fileDetailPanel: FileDetailPanel
    private var frame: JFrame = JFrame()
    private var splitPane: JSplitPane
    private var tableScrollPane: TableScrollPane

    init {
        frame.title = "File Browser"
        frame.defaultCloseOperation = JFrame.DO_NOTHING_ON_CLOSE
        frame.addWindowListener(object : WindowAdapter() {
            override fun windowClosing(event: WindowEvent) {
                frame.isVisible = false
            }
        })
        val rightPanel = JPanel()
        rightPanel.layout = BorderLayout()
        tableScrollPane = TableScrollPane(this, model, field)
        tableScrollPane.panel.let {
            rightPanel.add(
                it,
                BorderLayout.CENTER
            )
        }
        val southPanel = JPanel()
        southPanel.layout = BorderLayout()
        fileDetailPanel = FileDetailPanel()
        fileDetailPanel.panel.let { southPanel.add(it, BorderLayout.NORTH) }
        desktopButtonPanel = DesktopButtonPanel(field)
        southPanel.add(
            desktopButtonPanel.panel,
            BorderLayout.SOUTH
        )
        rightPanel.add(southPanel, BorderLayout.SOUTH)
        val treeScrollPane = TreeScrollPane(this, model, field)
        splitPane = JSplitPane(
            JSplitPane.HORIZONTAL_SPLIT,
            treeScrollPane.scrollPane,
            rightPanel
        )
        splitPane.isOneTouchExpandable = true
        splitPane.dividerLocation = 300
        splitPane.dividerSize = 20
        frame.add(splitPane)
        frame.pack()
        frame.isLocationByPlatform = true
        frame.isVisible = true
    }

    fun updateFileDetail(fileNode: FileNode?) {
        fileDetailPanel.setFileNode(fileNode, model)
    }

    fun setDefaultTableModel(node: DefaultMutableTreeNode) {
        tableScrollPane.setDefaultTableModel(node)
    }

    fun clearDefaultTableModel() {
        tableScrollPane.clearDefaultTableModel()
    }

    fun setDesktopButtonFileNode(fileNode: FileNode?) {
        fileNode?.let { desktopButtonPanel.setFileNode(it) }
    }
}