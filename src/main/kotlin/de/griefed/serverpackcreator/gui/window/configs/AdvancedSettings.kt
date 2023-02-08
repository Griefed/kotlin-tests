package de.griefed.serverpackcreator.gui.window.configs

import de.griefed.serverpackcreator.gui.window.components.ElementLabel
import net.miginfocom.swing.MigLayout
import javax.swing.JLabel
import javax.swing.JPanel

class AdvancedSettings(configs: Configs, editor: ConfigEditor) : JPanel(
    MigLayout(
        "left,wrap",
        "[left,::64]5[left]5[left,grow]5[left,::64]5[left,::64]", "30"
    )
) {

    private val exclusionsInfo = JLabel(configs.infoIcon)
    private val argumentsInfo = JLabel(configs.infoIcon)
    private val scriptInfo = JLabel(configs.infoIcon)

    init {
        // Mod Exclusions
        add(exclusionsInfo, "cell 0 0 1 3")
        add(ElementLabel("Mod-Exclusions"), "cell 1 0 1 3")
        add(editor.exclusions, "cell 2 0 1 3,grow,w 10:500:,h 150!")
        add(editor.exclusionsRevert, "cell 3 0 2 1, h 30!, aligny center, alignx center,growx")
        add(editor.exclusionsBrowser, "cell 3 1 2 1, h 30!, aligny center, alignx center,growx")
        add(editor.exclusionsReset, "cell 3 2 2 1, h 30!, aligny top, alignx center,growx")

        // Java Arguments
        add(argumentsInfo, "cell 0 3 1 3")
        add(ElementLabel("Run Arguments"), "cell 1 3 1 3")
        add(editor.startArgs, "cell 2 3 1 3,grow,w 10:500:,h 100!")
        add(editor.aikarsFlags, "cell 3 3 2 3,growy")

        // Script Key-Value Pairs
        add(scriptInfo, "cell 0 6 1 3")
        add(ElementLabel("Script Key-Value Pairs"), "cell 1 6 1 3")
        add(editor.scriptKVPairs.scrollPanel, "cell 2 6 1 3,grow,w 10:500:,h 200!")
        add(editor.scriptKVPairsRevert, "cell 3 6 2 1, h 30!, aligny center, alignx center,growx")
        add(editor.scriptKVPairsBrowser, "cell 3 7 2 1, h 30!, aligny center, alignx center,growx")
        add(editor.scriptKVPairsReset, "cell 3 8 2 1, h 30!, aligny top, alignx center,growx")
        isVisible = false
    }

}