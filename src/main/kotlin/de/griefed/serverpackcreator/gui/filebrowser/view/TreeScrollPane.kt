package de.griefed.serverpackcreator.gui.filebrowser.view

import de.griefed.serverpackcreator.gui.filebrowser.controller.FileSelectionListener
import de.griefed.serverpackcreator.gui.filebrowser.controller.TreeExpandListener
import de.griefed.serverpackcreator.gui.filebrowser.controller.TreeMouseListener
import de.griefed.serverpackcreator.gui.filebrowser.model.FileBrowserModel
import de.griefed.serverpackcreator.gui.filebrowser.view.renderer.FileTreeCellRenderer
import de.griefed.serverpackcreator.gui.window.configs.ConfigsTab
import java.awt.Dimension
import javax.swing.JScrollPane
import javax.swing.JTree
import javax.swing.text.Position
import javax.swing.tree.TreePath

class TreeScrollPane(
    frame: FileBrowserFrame,
    private val browserModel: FileBrowserModel,
    private val configsTab: ConfigsTab
) {
    private val slashRegex: Regex = "/".toRegex()
    var tree: JTree = JTree(this.browserModel.treeModel)
    var scrollPane: JScrollPane

    init {
        tree.addTreeSelectionListener(
            FileSelectionListener(frame, this.browserModel)
        )
        tree.addTreeWillExpandListener(
            TreeExpandListener(this.browserModel)
        )
        tree.expandRow(1)
        tree.isRootVisible = true
        tree.cellRenderer = FileTreeCellRenderer(this.browserModel)
        tree.showsRootHandles = true
        tree.addMouseListener(TreeMouseListener(tree, configsTab))
        scrollPane = JScrollPane(tree)
        val preferredSize: Dimension = scrollPane.preferredSize
        val widePreferred = Dimension(
            300, preferredSize.getHeight().toInt()
        )
        scrollPane.preferredSize = widePreferred
        expandPaths()
    }

    private fun expandPaths() {
        if (configsTab.activeTab != null
            && configsTab.activeTab!!.modpackDirectory.file.isDirectory
        ) {
            val prefixes: Array<String> =
                configsTab.activeTab!!.modpackDirectory.file.absolutePath.replace("\\", "/").split(slashRegex)
                    .dropLastWhile { it.isEmpty() }
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