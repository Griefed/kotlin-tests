package de.griefed.serverpackcreator.gui.window

import com.formdev.flatlaf.FlatLaf
import com.formdev.flatlaf.fonts.jetbrains_mono.FlatJetBrainsMonoFont
import com.formdev.flatlaf.intellijthemes.FlatDarkPurpleIJTheme
import de.griefed.serverpackcreator.gui.window.main.MainFrame

class MainWindow : Runnable {
    init {
        FlatJetBrainsMonoFont.install()
        FlatLaf.setPreferredFontFamily(FlatJetBrainsMonoFont.FAMILY)
        try {
            FlatDarkPurpleIJTheme.setup()
        } catch (weTried: Exception) {
            weTried.printStackTrace()
        }
    }
    override fun run() {
        MainFrame()
    }
}