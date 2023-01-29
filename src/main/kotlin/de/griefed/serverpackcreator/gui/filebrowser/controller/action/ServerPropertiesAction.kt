package de.griefed.serverpackcreator.gui.filebrowser.controller.action

import java.awt.event.ActionEvent
import javax.swing.AbstractAction

class ServerPropertiesAction : AbstractAction() {
    init {
        putValue(NAME, "Set as server.properties")
    }

    /**
     * Invoked when an action occurs.
     *
     * @param e
     */
    override fun actionPerformed(e: ActionEvent) {}
}