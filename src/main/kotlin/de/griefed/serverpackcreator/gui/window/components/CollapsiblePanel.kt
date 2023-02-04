package de.griefed.serverpackcreator.gui.window.components

import java.awt.*
import java.awt.event.MouseEvent
import java.awt.event.MouseListener
import java.awt.font.FontRenderContext
import java.awt.font.LineMetrics
import javax.swing.JLabel
import javax.swing.JPanel

internal class CollapsablePanel(val text: String, var contentPanel: JPanel) : JPanel(GridBagLayout()) {
    private var selected: Boolean
    private var headerPanel: HeaderPanel

    init {
        val gbc = GridBagConstraints()
        gbc.insets = Insets(1, 3, 0, 3)
        gbc.weightx = 1.0
        gbc.fill = GridBagConstraints.HORIZONTAL
        gbc.gridwidth = GridBagConstraints.REMAINDER
        selected = false
        headerPanel = HeaderPanel()
        background = Color(200, 200, 220)
        add(headerPanel, gbc)
        add(contentPanel, gbc)
        contentPanel.isVisible = false
        val padding = JLabel()
        gbc.weighty = 1.0
        add(padding, gbc)
    }

    fun toggleSelection() {
        selected = !selected
        contentPanel.isVisible = !contentPanel.isShowing
        validate()
        headerPanel.repaint()
    }

    inner class HeaderPanel : JPanel(), MouseListener {

        /*var open: BufferedImage? = null
        var closed: BufferedImage? = null*/
        val OFFSET = 30
        //val PAD = 5

        init {
            addMouseListener(this)
            preferredSize = Dimension(200, 20)
            font = Font("sans-serif", Font.PLAIN, 12)

            /*
            val w: Int = width
            val h: Int = height

            try {
                open = ImageIO.read(new File("images/arrow_down_mini.png"));
                closed = ImageIO.read(new File("images/arrow_right_mini.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            */
        }

        override fun paintComponent(g: Graphics) {
            super.paintComponent(g)
            val g2: Graphics2D = g as Graphics2D
            g2.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON
            )
            val h: Int = height

            /* Uncomment once you have your own images
            if (selected)
                g2.drawImage(open, PAD, 0, h, h, this);
            else
                g2.drawImage(closed, PAD, 0, h, h, this);
            */
            g2.font = font
            val frc: FontRenderContext = g2.fontRenderContext
            val lm: LineMetrics = font.getLineMetrics(text, frc)
            val height: Float = lm.ascent + lm.descent
            val x = OFFSET.toFloat()
            val y: Float = (h + height) / 2 - lm.descent
            g2.drawString(text, x, y)
        }

        override fun mouseClicked(e: MouseEvent?) {
            toggleSelection()
        }

        override fun mouseEntered(e: MouseEvent?) {}
        override fun mouseExited(e: MouseEvent?) {}
        override fun mousePressed(e: MouseEvent?) {}
        override fun mouseReleased(e: MouseEvent?) {}
    }
}