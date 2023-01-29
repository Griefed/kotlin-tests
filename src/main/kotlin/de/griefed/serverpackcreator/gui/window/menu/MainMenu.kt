package de.griefed.serverpackcreator.gui.window.menu

import javax.swing.JMenu
import javax.swing.JMenuBar
import javax.swing.JMenuItem

class MainMenu {
    val menuBar: JMenuBar = JMenuBar()

    init {
        val menuOne = JMenu("One")
        val menuTwo = JMenu("Two")
        val menuThree = JMenu("Three")
        val menuFour = JMenu("Four")

        val m1i1 = JMenuItem("Item 1")
        val m1i2 = JMenuItem("Item 2")
        val m1i3 = JMenuItem("Item 3")
        menuOne.add(m1i1)
        menuOne.add(m1i2)
        menuOne.add(m1i3)

        val m2i1 = JMenuItem("Item 1")
        val m2i2 = JMenuItem("Item 2")
        val m2i3 = JMenuItem("Item 3")
        menuTwo.add(m2i1)
        menuTwo.add(m2i2)
        menuTwo.add(m2i3)

        val m3i1 = JMenuItem("Item 1")
        val m3i2 = JMenuItem("Item 2")
        val m3i3 = JMenuItem("Item 3")
        menuThree.add(m3i1)
        menuThree.add(m3i2)
        menuThree.add(m3i3)

        val m4i1 = JMenuItem("Item 1")
        val m4i2 = JMenuItem("Item 2")
        val m4i3 = JMenuItem("Item 3")
        menuFour.add(m4i1)
        menuFour.add(m4i2)
        menuFour.add(m4i3)

        menuBar.add(menuOne)
        menuBar.add(menuTwo)
        menuBar.add(menuThree)
        menuBar.add(menuFour)
    }
}