package de.griefed.serverpackcreator.gui.window.main

import de.griefed.serverpackcreator.gui.window.menu.MainMenu
import javax.swing.JFrame
import javax.swing.JScrollPane
import javax.swing.WindowConstants

class MainFrame {
    private val mainFrame: JFrame = JFrame("ServerPackCreator")

    init {
        mainFrame.jMenuBar = MainMenu().menuBar
        mainFrame.contentPane.add(JScrollPane(MainPanel().panel))
        mainFrame.pack()
        mainFrame.defaultCloseOperation = WindowConstants.EXIT_ON_CLOSE
        mainFrame.isLocationByPlatform = true
        mainFrame.setSize(800,500)
        mainFrame.isVisible = true

    }
}