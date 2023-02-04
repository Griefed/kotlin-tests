package de.griefed.serverpackcreator.gui.window.components

import java.awt.*
import java.awt.event.MouseAdapter
import java.awt.event.MouseEvent
import java.awt.event.MouseListener
import java.awt.image.BufferedImage
import javax.swing.*

class ExpandablePanel {
}


class ExpandingPanels : MouseAdapter() {
    private lateinit var aps: Array<ActionPanel?>
    private lateinit var panels: Array<JPanel>

    init {
        assembleActionPanels()
        assemblePanels()
    }

    override fun mousePressed(e: MouseEvent) {
        val ap = e.source as ActionPanel
        if (ap.target!!.contains(e.point)) {
            ap.toggleSelection()
            togglePanelVisibility(ap)
        }
    }

    private fun togglePanelVisibility(ap: ActionPanel) {
        val index = getPanelIndex(ap)
        if (panels[index].isShowing) panels[index].isVisible = false else panels[index].isVisible = true
        ap.parent.validate()
    }

    private fun getPanelIndex(ap: ActionPanel): Int {
        for (j in aps.indices) if (ap === aps[j]) return j
        return -1
    }

    private fun assembleActionPanels() {
        val ids = arrayOf("level 1", "level 2", "level 3", "level 4")
        aps = arrayOfNulls(ids.size)
        for (j in aps.indices) aps[j] = ActionPanel(ids[j], this)
    }

    private fun assemblePanels() {
        val gbc = GridBagConstraints()
        gbc.insets = Insets(2, 1, 2, 1)
        gbc.weightx = 1.0
        gbc.weighty = 1.0
        val p1 = JPanel(GridBagLayout())
        gbc.gridwidth = GridBagConstraints.RELATIVE
        p1.add(JButton("button 1"), gbc)
        gbc.gridwidth = GridBagConstraints.REMAINDER
        p1.add(JButton("button 2"), gbc)
        gbc.gridwidth = GridBagConstraints.RELATIVE
        p1.add(JButton("button 3"), gbc)
        gbc.gridwidth = GridBagConstraints.REMAINDER
        p1.add(JButton("button 4"), gbc)
        val p2 = JPanel(GridBagLayout())
        gbc.gridwidth = 1
        gbc.anchor = GridBagConstraints.EAST
        p2.add(JLabel("enter"), gbc)
        gbc.anchor = GridBagConstraints.WEST
        p2.add(JTextField(8), gbc)
        gbc.anchor = GridBagConstraints.CENTER
        p2.add(JButton("button 1"), gbc)
        gbc.gridwidth = GridBagConstraints.REMAINDER
        p2.add(JButton("button 2"), gbc)
        val p3 = JPanel(BorderLayout())
        val textArea = JTextArea(8, 12)
        textArea.lineWrap = true
        p3.add(JScrollPane(textArea))
        val p4 = JPanel(GridBagLayout())
        addComponents(JLabel("label 1"), JTextField(12), p4, gbc)
        addComponents(JLabel("label 2"), JTextField(16), p4, gbc)
        gbc.gridwidth = 2
        gbc.gridy = 2
        p4.add(JSlider(), gbc)
        gbc.gridy++
        val p5 = JPanel(GridBagLayout())
        p5.add(JButton("button 1"), gbc)
        p5.add(JButton("button 2"), gbc)
        p5.add(JButton("button 3"), gbc)
        p5.add(JButton("button 4"), gbc)
        gbc.weighty = 1.0
        gbc.fill = GridBagConstraints.BOTH
        p4.add(p5, gbc)
        panels = arrayOf(p1, p2, p3, p4)
    }

    private fun addComponents(
        c1: Component, c2: Component, c: Container,
        gbc: GridBagConstraints
    ) {
        gbc.anchor = GridBagConstraints.EAST
        gbc.gridwidth = GridBagConstraints.RELATIVE
        c.add(c1, gbc)
        gbc.anchor = GridBagConstraints.WEST
        gbc.gridwidth = GridBagConstraints.REMAINDER
        c.add(c2, gbc)
        gbc.anchor = GridBagConstraints.CENTER
    }

    private val component: JPanel
        private get() {
            val panel = JPanel(GridBagLayout())
            val gbc = GridBagConstraints()
            gbc.insets = Insets(1, 3, 0, 3)
            gbc.weightx = 1.0
            gbc.fill = GridBagConstraints.HORIZONTAL
            gbc.gridwidth = GridBagConstraints.REMAINDER
            for (j in aps.indices) {
                panel.add(aps[j], gbc)
                panel.add(panels[j], gbc)
                panels[j].isVisible = false
            }
            val padding = JLabel()
            gbc.weighty = 1.0
            panel.add(padding, gbc)
            return panel
        }
}

class ActionPanel(var text: String, ml: MouseListener?) : JPanel() {

    private var selected: Boolean
    var open: BufferedImage? = null
    var closed: BufferedImage? = null
    var target: Rectangle? = null
    val OFFSET = 30
    val PAD = 5

    init {
        addMouseListener(ml)
        font = Font("sans-serif", Font.PLAIN, 12)
        selected = false
        background = Color(200, 200, 220)
        preferredSize = Dimension(200, 20)
        border = BorderFactory.createRaisedBevelBorder()
        preferredSize = Dimension(200, 20)
        createImages()
        isRequestFocusEnabled = true
    }

    fun toggleSelection() {
        selected = !selected
        repaint()
    }

    override fun paintComponent(g: Graphics) {
        super.paintComponent(g)
        val g2 = g as Graphics2D
        g2.setRenderingHint(
            RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON
        )
        val w = width
        val h = height
        if (selected) g2.drawImage(open, PAD, 0, this) else g2.drawImage(closed, PAD, 0, this)
        g2.font = font
        val frc = g2.fontRenderContext
        val lm = font.getLineMetrics(text, frc)
        val height = lm.ascent + lm.descent
        val x = OFFSET.toFloat()
        val y = (h + height) / 2 - lm.descent
        g2.drawString(text, x, y)
    }

    private fun createImages() {
        val w = 20
        val h = preferredSize.height
        target = Rectangle(2, 0, 20, 18)
        open = BufferedImage(w, h, BufferedImage.TYPE_INT_RGB)
        var g2 = open!!.createGraphics()
        g2.setRenderingHint(
            RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON
        )
        g2.paint = background
        g2.fillRect(0, 0, w, h)
        var x = intArrayOf(2, w / 2, 18)
        var y = intArrayOf(4, 15, 4)
        var p = Polygon(x, y, 3)
        g2.paint = Color.green.brighter()
        g2.fill(p)
        g2.paint = Color.blue.brighter()
        g2.draw(p)
        g2.dispose()
        closed = BufferedImage(w, h, BufferedImage.TYPE_INT_RGB)
        g2 = closed!!.createGraphics()
        g2.setRenderingHint(
            RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON
        )
        g2.paint = background
        g2.fillRect(0, 0, w, h)
        x = intArrayOf(3, 13, 3)
        y = intArrayOf(4, h / 2, 16)
        p = Polygon(x, y, 3)
        g2.paint = Color.red
        g2.fill(p)
        g2.paint = Color.blue.brighter()
        g2.draw(p)
        g2.dispose()
    }
}
