import de.griefed.serverpackcreator.gui.filebrowser.FileBrowser
import de.griefed.serverpackcreator.gui.window.MainWindow
import javax.swing.JTextField
import javax.swing.SwingUtilities

fun main() {
    val textField1 = JTextField(
        "C:\\Minecraft\\Game\\Instances\\Survive Create Prosper 4"
    )
    SwingUtilities.invokeLater(FileBrowser(textField1))
    SwingUtilities.invokeLater(MainWindow())
}