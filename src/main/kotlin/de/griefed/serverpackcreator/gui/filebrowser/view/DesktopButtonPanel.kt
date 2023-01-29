package de.griefed.serverpackcreator.gui.filebrowser.view

import com.formdev.flatlaf.FlatDarculaLaf
import com.formdev.flatlaf.extras.FlatAnimatedLafChange
import com.formdev.flatlaf.extras.components.FlatButton
import de.griefed.serverpackcreator.gui.filebrowser.model.FileNode
import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import javax.swing.JPanel
import javax.swing.JTextField
import javax.swing.UIManager
import javax.swing.UnsupportedLookAndFeelException

class DesktopButtonPanel(textField: JTextField) {
    private var fileNode: FileNode? = null
    var panel: JPanel = JPanel()

    init {
        panel.add(textField)
        val themeButton = FlatButton()
        themeButton.text = "Switch Theme"
        themeButton.addActionListener(ThemeListener())
        panel.add(themeButton)
    }

    fun setFileNode(fileNode: FileNode) {
        this.fileNode = fileNode
    }

    class ThemeListener : ActionListener {
        override fun actionPerformed(e: ActionEvent) {
            try {
                FlatAnimatedLafChange.showSnapshot()
                UIManager.setLookAndFeel(FlatDarculaLaf())
                FlatDarculaLaf.updateUI()
                FlatAnimatedLafChange.hideSnapshotWithAnimation()
            } catch (ex: UnsupportedLookAndFeelException) {
                throw RuntimeException(ex)
            }
        }
    }
}