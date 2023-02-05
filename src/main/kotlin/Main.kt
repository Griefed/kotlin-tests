import com.formdev.flatlaf.FlatLaf
import com.formdev.flatlaf.fonts.inter.FlatInterFont
import com.formdev.flatlaf.fonts.jetbrains_mono.FlatJetBrainsMonoFont
import com.formdev.flatlaf.fonts.roboto.FlatRobotoFont
import com.formdev.flatlaf.fonts.roboto_mono.FlatRobotoMonoFont
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