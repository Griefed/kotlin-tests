package de.griefed.serverpackcreator.gui.filebrowser

import com.formdev.flatlaf.FlatLaf
import com.formdev.flatlaf.fonts.jetbrains_mono.FlatJetBrainsMonoFont
import com.formdev.flatlaf.intellijthemes.FlatDarkPurpleIJTheme
import de.griefed.serverpackcreator.gui.filebrowser.model.FileBrowserModel
import de.griefed.serverpackcreator.gui.filebrowser.view.FileBrowserFrame
import javax.swing.JTextField

class FileBrowser(
    private val field: JTextField
) : Runnable {
    private val model: FileBrowserModel

    init {
        FlatJetBrainsMonoFont.install()
        FlatLaf.setPreferredFontFamily(FlatJetBrainsMonoFont.FAMILY)
        try {
            FlatDarkPurpleIJTheme.setup()
        } catch (weTried: Exception) {
            weTried.printStackTrace()
        }
        model = FileBrowserModel()
    }

    fun reload() {
        model.reload()
    }

    override fun run() {
        FileBrowserFrame(model, field)
    }
}