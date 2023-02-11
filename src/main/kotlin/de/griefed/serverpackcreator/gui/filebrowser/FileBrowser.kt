package de.griefed.serverpackcreator.gui.filebrowser

import de.griefed.serverpackcreator.gui.filebrowser.model.FileBrowserModel
import de.griefed.serverpackcreator.gui.filebrowser.view.FileBrowserFrame
import de.griefed.serverpackcreator.gui.window.configs.ConfigsTab

class FileBrowser(configsTab: ConfigsTab) {
    private val browserModel: FileBrowserModel = FileBrowserModel()
    private val frame: FileBrowserFrame = FileBrowserFrame(browserModel, configsTab)

    fun reload() {
        browserModel.reload()
    }

    fun show() {
        frame.show()
    }

    fun hide() {
        frame.hide()
    }
}