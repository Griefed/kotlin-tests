package de.griefed.serverpackcreator.gui.window.components.interactivetable

import com.formdev.flatlaf.icons.FlatClearIcon
import com.kitfox.svg.app.beans.SVGIcon
import de.griefed.serverpackcreator.gui.window.components.getScaledInstance
import java.awt.Color
import java.awt.Component
import java.awt.Image
import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import java.awt.event.MouseEvent
import java.awt.event.MouseListener
import java.util.*
import javax.swing.*
import javax.swing.border.Border
import javax.swing.border.LineBorder
import javax.swing.table.DefaultTableModel
import javax.swing.table.TableCellEditor
import javax.swing.table.TableCellRenderer
import javax.swing.table.TableColumnModel

class ButtonColumn(
    private val table: JTable,
    column: Int,
    private val type: ColumnType = ColumnType.CLEAR
) : AbstractCellEditor(), TableCellRenderer, TableCellEditor, ActionListener, MouseListener {
    private val originalBorder: Border
    private val renderButton: JButton
    private val editButton: JButton
    private var focusBorder: Border? = null
    private var editorValue: Any? = null
    private var isButtonColumnEditor = false
    private val size = 20
    private val clearIcon = ImageIcon(Base64.getDecoder().decode("iVBORw0KGgoAAAANSUhEUgAAADAAAAAwCAYAAABXAvmHAAAAAXNSR0IArs4c6QAAAlJJREFUaEPtmOExBTEUhc+rABWgAnSgA1SAClABKkAFqAAV0AEqQAdUwHwzyUwmk83LS26YHZtfj9m9e797zz3J7kwjX7OR568J4K87OHVg6kBjBSYJNRaw+fZ/34E1SaeSDppLmQ7wKelG0slQ/JYObEp6lLTcKfkw7JWk49RzagFImuSB+I1FJ1YsAS4lHbmAXw7kvQPJdxAzWeyaDuxKugsCo0+AeixzAKTzFuj+QRJAvZY5AJX3CSMdXAh9xgtQJHZeSLYv6TZxrSkALnARPGRP0v1A8n7AscDDORDXzoZT15oBxJY5aGuSztze4PPOQfjk/bXAcr1fZgDPgWV+uN8p6YRJI4scRJw8Eoo3RBOAuKJbkl4KtE0lhyBKkucRzQDbbsPy+TKUAJWuFAT3hpVOVd5EQjgJ0sFpWK+VO28MEcLnkm/uQGyZDHLtbpuCmJd8MwAWuePKxcCi/VqAWPOELbHYphlAQgzrqoPgNxCLrlTyOXcK4zcBEKh1iFNuQ9x5FmsyxD5IrY3mrDJnsaYd8MGQz4b7gzlASrmNrMTnSyCaJeQBcKAnSUvuH4scJXJuE0PE+4wZAHkvcpgDlo6VWKWHYJ9h5sLOmgIAEVvreuY4DXDprs11vBTFsjQHwFqZAS8lgDhW91rmAClrHdUrpa90+FLfukvnutelAzwQKflB7SWfMC6vr8nvTzVfJYastSeI+YctnyxHbRwkPBpYglB5bDb5VY4HtXTAMtHqWBNAdemMbpw6YFTI6jBTB6pLZ3Tj1AGjQlaHGX0HfgDCRIwx9EfGSwAAAABJRU5ErkJggg=="))
        .getScaledInstance(size,size,Image.SCALE_SMOOTH)
    private val deleteIcon = ImageIcon(Base64.getDecoder().decode("iVBORw0KGgoAAAANSUhEUgAAADAAAAAwCAYAAABXAvmHAAAAAXNSR0IArs4c6QAAAWRJREFUaEPtmeFNAzEMhb9OQDdgBNigZRNGgAmgG3SEbtKyAWwAG7QTgCzlpKhNkzi9UB08S/fjLk7s5+c4yWXGxGU2cf8RgGszKAb+CgOvwIsTzAqwfhdJTQrVOLYE7PHIDrCnJAb0rNQA+C5Z6Nye9fFfABjyNE6lLK0XMJKykZ0nNQwM/sSp5OnnweO24XHEPbjH86DrtiEAUZTvgZvw/gHsjxiYA3fh2wF4TzB0VQaspi+CUw+JGm/rxDa0v51ZNwQgN+9K0REDQClIJwEeswqJATFQWDlL+akUUgophbSV0EKWnQUqo9pOJxJEm7koKJPfSqwBOxebPCXOvNZmOiZ2HjadYykViq7ngYa/KALgumJy09tAidvGmFWowd/fTaFP4HYMLyvGsB9jQ0HIqnsYaLmFqfA1qfIcVazRANhABuKxIxNfwMZz9eRhoDWaXfsJQNfwVgwuBiqC1FVl8gz8AGJ5nTEbbA3dAAAAAElFTkSuQmCC"))
        .getScaledInstance(18,18,Image.SCALE_SMOOTH)
    private val addBefore = ImageIcon(Base64.getDecoder().decode("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ZC05OTMxLWQ0NjcwMGQ0ZGM5OCIKICAgeG1wTU06SW5zdGFuY2VJRD0ieG1wLmlpZDoyNjcxYWM5Ny0yNmQwLTRhMjctODQ2YS1lNzA2Y2MyYTQ1N2QiCiAgIHhtcE1NOk9yaWdpbmFsRG9jdW1lbnRJRD0ieG1wLmRpZDo1YzIzOWFkMS1kMzA2LTRiOGYtYWIwYy1iZTI4MmQ5ZTA4ZTYiCiAgIGRjOkZvcm1hdD0iaW1hZ2UvcG5nIgogICBHSU1QOkFQST0iMi4wIgogICBHSU1QOlBsYXRmb3JtPSJXaW5kb3dzIgogICBHSU1QOlRpbWVTdGFtcD0iMTY3NTUyOTA1NTcyMDEyOSIKICAgR0lNUDpWZXJzaW9uPSIyLjEwLjMyIgogICB0aWZmOk9yaWVudGF0aW9uPSIxIgogICB4bXA6Q3JlYXRvclRvb2w9IkdJTVAgMi4xMCIKICAgeG1wOk1ldGFkYXRhRGF0ZT0iMjAyMzowMjowNFQxNzo0NDoxMyswMTowMCIKICAgeG1wOk1vZGlmeURhdGU9IjIwMjM6MDI6MDRUMTc6NDQ6MTMrMDE6MDAiPgogICA8eG1wTU06SGlzdG9yeT4KICAgIDxyZGY6U2VxPgogICAgIDxyZGY6bGkKICAgICAgc3RFdnQ6YWN0aW9uPSJzYXZlZCIKICAgICAgc3RFdnQ6Y2hhbmdlZD0iLyIKICAgICAgc3RFdnQ6aW5zdGFuY2VJRD0ieG1wLmlpZDo3MThkNTJmYy02NDg1LTRjN2EtOGRhOC0zZDA2NWFlMDg3NWEiCiAgICAgIHN0RXZ0OnNvZnR3YXJlQWdlbnQ9IkdpbXAgMi4xMCAoV2luZG93cykiCiAgICAgIHN0RXZ0OndoZW49IjIwMjMtMDItMDRUMTc6NDQ6MTUiLz4KICAgIDwvcmRmOlNlcT4KICAgPC94bXBNTTpIaXN0b3J5PgogIDwvcmRmOkRlc2NyaXB0aW9uPgogPC9yZGY6UkRGPgo8L3g6eG1wbWV0YT4KICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgIAo8P3hwYWNrZXQgZW5kPSJ3Ij8+Hpz1lgAAAAZiS0dEAB4AHgAeyiQhhQAAAAlwSFlzAAALEwAACxMBAJqcGAAAAAd0SU1FB+cCBBAsD4efkOIAAAD0SURBVGje7dfRDYMgGATgq3GvMoqj2Emsm9iNuoG+QEIsIBDwh+YuMVEf9D7gAQDZTAAWdJoJwK6vpefy3SFc5btBhMo3jziX/3rum0Scy78BzNbzrN81iXCVhwOAFhG+8j5AU4hQ+RCgCcRV+SuAKCKmfAxABBFbPhZwKyKlfArgFkRq+VRAVURO+RyAEzEUnolVg2ou09V6/owFPmpGXFUubyMAYEuY7SrJWUI/GdB5BqmRkwR0PwMEEEAAAQQQQECpPKy9TWyUvsyWdkv856s0YBcYNC4hkzFjShWApznSZSwh8fA8QAABBBBAAAEE/AvgAJx0qmF6YLeeAAAAAElFTkSuQmCC"))
        .getScaledInstance(size,size,Image.SCALE_SMOOTH)
    private val addAfter = ImageIcon(Base64.getDecoder().decode("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My1iM2RjLTYxYWU1NGQzZWUzMyIKICAgeG1wTU06SW5zdGFuY2VJRD0ieG1wLmlpZDphYWNlMDUwOC1iZjZjLTRlNzItYTg1MS1mYTYyZTQ2YTZmNjAiCiAgIHhtcE1NOk9yaWdpbmFsRG9jdW1lbnRJRD0ieG1wLmRpZDo5NzBmY2M3Zi01NzcyLTRiMWEtOTEwNC05NmE0OTNmYzUwYjEiCiAgIGRjOkZvcm1hdD0iaW1hZ2UvcG5nIgogICBHSU1QOkFQST0iMi4wIgogICBHSU1QOlBsYXRmb3JtPSJXaW5kb3dzIgogICBHSU1QOlRpbWVTdGFtcD0iMTY3NTUyOTE5MDY4MzY1OSIKICAgR0lNUDpWZXJzaW9uPSIyLjEwLjMyIgogICB0aWZmOk9yaWVudGF0aW9uPSIxIgogICB4bXA6Q3JlYXRvclRvb2w9IkdJTVAgMi4xMCIKICAgeG1wOk1ldGFkYXRhRGF0ZT0iMjAyMzowMjowNFQxNzo0NjoyNSswMTowMCIKICAgeG1wOk1vZGlmeURhdGU9IjIwMjM6MDI6MDRUMTc6NDY6MjUrMDE6MDAiPgogICA8eG1wTU06SGlzdG9yeT4KICAgIDxyZGY6U2VxPgogICAgIDxyZGY6bGkKICAgICAgc3RFdnQ6YWN0aW9uPSJzYXZlZCIKICAgICAgc3RFdnQ6Y2hhbmdlZD0iLyIKICAgICAgc3RFdnQ6aW5zdGFuY2VJRD0ieG1wLmlpZDoxMjE2NmM4MC1hMTgwLTQxZWYtYjM1Zi1jNjRkNGRiZWU3NGEiCiAgICAgIHN0RXZ0OnNvZnR3YXJlQWdlbnQ9IkdpbXAgMi4xMCAoV2luZG93cykiCiAgICAgIHN0RXZ0OndoZW49IjIwMjMtMDItMDRUMTc6NDY6MzAiLz4KICAgIDwvcmRmOlNlcT4KICAgPC94bXBNTTpIaXN0b3J5PgogIDwvcmRmOkRlc2NyaXB0aW9uPgogPC9yZGY6UkRGPgo8L3g6eG1wbWV0YT4KICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgIAo8P3hwYWNrZXQgZW5kPSJ3Ij8+SkJaZQAAAAZiS0dEAB4AHgAeyiQhhQAAAAlwSFlzAAALEwAACxMBAJqcGAAAAAd0SU1FB+cCBBAuHt8Z0pIAAAEHSURBVGje7dfvDYIwEAXwp7KXbgJOIk4io+gGruAExgnwCzFNQ+GuHv2TvEtIypf2/WhDeoC+egDj9PTIXHtUXgQQQAABBBBAQM5qnLuNtI7e+KJc82oJ2CnDW63JI+QeIe2Wnpxj9ABwrw1t1Q+YzMPfKAEEEEAAAQQQ8OdlLuYO03MHCgMMAG4Jc//Wa4wma533c4LwreUOuA1Nt/FO+B/LrD3tnOZkFCK0Dc3grTFYfx0tQgPYPHwMQgpIFl6LkACSh9cg1gDZwksRS4Ds4SWIEKCY8GuIOUBx4ZcQPqDY8CHEOzAuMnwIMfcUG16CKD78EqKa8HOI6PCHjIAngBeAz4SJqi/9WqMQHB4aTAAAAABJRU5ErkJggg=="))
        .getScaledInstance(size,size,Image.SCALE_SMOOTH)
    private val moveUp = ImageIcon(Base64.getDecoder().decode("iVBORw0KGgoAAAANSUhEUgAAADAAAAAwCAYAAABXAvmHAAAAAXNSR0IArs4c6QAAAVJJREFUaEPtl9sNwjAMRW8nYAU2gU2ASYBJgE0YhRXYAFlqpajKw3ZuhCo5X7TUzTm2k8CEjY9p4/wIgX9XMCoQFejMQLRQI4FnAAcAl85EF8NHVkDgH/PMz1ESowRS+CV7QyRGCOTgh0mwBWrwQySYAmv4L4DdTJ1+llu0dmIJrOFfAD4ArrPAHcAewCnZTigSDIEcvNy7rQTkWqCpEr0CJXhJdE5gaR+aRI9ADb4mQJXwCrTgWwI0CY+ABl4jQJGwCmjhtQLdEhYBC7xFoEtCK2CFtwq4JTQCHniPgEvCKiAnrAhpRukcaMWmh538j5Dr4tAISLBAHw3w3gqkP/jeLXh5WCvQylrue28FTHOFQCVdUQFNL0ULRQtp+oRwDnimiUWsyVos4ljEmj6JRezL0uZ3IZ+2MWrkLmRE8T0eAr688aKiArxc+t4UFfDljRf1A7TvbzHLemwyAAAAAElFTkSuQmCC"))
        .getScaledInstance(size,size,Image.SCALE_SMOOTH)
    private val moveDown = ImageIcon(Base64.getDecoder().decode("iVBORw0KGgoAAAANSUhEUgAAADAAAAAwCAYAAABXAvmHAAAAAXNSR0IArs4c6QAAAUhJREFUaEPtmP0NwiAQxV83cARHcRN1EnUSdTQ36AYakjYhpIV3H8SQHH/R0IP3u3cU0gmDt2lw/QiAfzsYDoQDxgxECVUSeAdwW8YfANKze+vpQAAwdoUDsQeYOqm8EyUUJRQlZMxAlJAxgfEVGqWEXgC+AK4Cxy2XOXo9poTSZOdFeOqzEFoA0XoMwAXAM8s8C6EByMWnJd8A0vq7jQFIwRoIKYBYfBLGAmggJAAq8VIAKQQLoBavAZBAMAAm8VoAFqIFYBZvAWAgagAu4q0ALYg9ADfxHgA1iC0AV/FeAHsQn+LH1jE70alDirm2SM6B1nzlYTcDOCxBed9NvKcDK1wJsQXdvB60MpWPezrAQLiK7+FADcJdfE+AcmN3Ed8bYIU4ta7Ekpov3+2xByx6xLEBIE6Zc0A44JxQ8XThgDhlzgHDO/ADXFlwMT3+4e0AAAAASUVORK5CYII="))
        .getScaledInstance(size,size,Image.SCALE_SMOOTH)
    private val action: Action = object : AbstractAction() {
        override fun actionPerformed(e: ActionEvent) {
            val modelRow: Int = e.actionCommand.toInt()
            val tableModel = ((e.source as JTable).model as DefaultTableModel)
            when (type) {
                ColumnType.CLEAR -> {
                    clearRow(tableModel,modelRow)
                }
                ColumnType.DELETE -> {
                    if (tableModel.rowCount > 1) {
                        tableModel.removeRow(modelRow)
                    } else {
                        clearRow(tableModel,modelRow)
                    }
                }
                ColumnType.ADD_BEFORE -> {
                    tableModel.insertRow(modelRow,arrayOf("",""))
                }
                ColumnType.ADD_AFTER -> {
                    tableModel.insertRow(modelRow+1,arrayOf("",""))
                }
                ColumnType.MOVE_UP -> {
                    if (modelRow != 0) {
                        tableModel.moveRow(modelRow,modelRow,modelRow-1)
                    }
                }
                ColumnType.MOVE_DOWN -> {
                    if (tableModel.rowCount-1 != modelRow) {
                        tableModel.moveRow(modelRow,modelRow,modelRow+1)
                    }
                }
            }
        }
    }

    fun clearRow(tableModel: DefaultTableModel, modelRow: Int) {
        tableModel.setValueAt("",modelRow,0)
        tableModel.setValueAt("",modelRow,1)
    }

    init {
        when (type) {
            ColumnType.CLEAR -> {
                renderButton = JButton(clearIcon)
                editButton = JButton(clearIcon)
            }
            ColumnType.DELETE -> {
                renderButton = JButton(deleteIcon)
                editButton = JButton(deleteIcon)
            }
            ColumnType.ADD_BEFORE -> {
                renderButton = JButton(addBefore)
                editButton = JButton(addBefore)
            }
            ColumnType.ADD_AFTER -> {
                renderButton = JButton(addAfter)
                editButton = JButton(addAfter)
            }
            ColumnType.MOVE_UP -> {
                renderButton = JButton(moveUp)
                editButton = JButton(moveUp)
            }
            else -> {
                renderButton = JButton(moveDown)
                editButton = JButton(moveDown)
            }
        }
        editButton.isFocusPainted = false
        originalBorder = editButton.border
        setFocusBorder(LineBorder(Color.BLUE))
        val columnModel: TableColumnModel = table.columnModel
        columnModel.getColumn(column).cellRenderer = this
        columnModel.getColumn(column).cellEditor = this
        editButton.addActionListener(this)
        table.addMouseListener(this)
    }

    /**
     * The foreground color of the button when the cell has focus
     *
     * @param focusBorder the foreground color
     */
    private fun setFocusBorder(focusBorder: Border?) {
        this.focusBorder = focusBorder
        editButton.border = focusBorder
    }

    override fun getTableCellEditorComponent(
        table: JTable,
        value: Any?,
        isSelected: Boolean,
        row: Int,
        column: Int
    ): Component {
        editorValue = value
        return editButton
    }

    override fun getCellEditorValue(): Any? {
        return editorValue
    }

    override fun getTableCellRendererComponent(
        table: JTable,
        value: Any?,
        isSelected: Boolean,
        hasFocus: Boolean,
        row: Int,
        column: Int
    ): Component {
        if (isSelected) {
            renderButton.foreground = table.selectionForeground
            renderButton.background = table.selectionBackground
        } else {
            renderButton.foreground = table.foreground
            renderButton.background = UIManager.getColor("Button.background")
        }
        if (hasFocus) {
            renderButton.border = focusBorder
        } else {
            renderButton.border = originalBorder
        }
        return renderButton
    }

    /**
     * The button has been pressed. Stop editing and invoke the custom Action
     */
    override fun actionPerformed(e: ActionEvent) {
        val row: Int = table.convertRowIndexToModel(table.editingRow)
        fireEditingStopped()
        val event = ActionEvent(
            table,
            ActionEvent.ACTION_PERFORMED, row.toString()
        )
        action.actionPerformed(event)
    }

    override fun mouseClicked(e: MouseEvent) {}

    /**
     * When the mouse is pressed the editor is invoked. If you then drag the mouse to another cell
     * before releasing it, the editor is still active. Make sure editing is stopped when the mouse
     * is released.
     */
    override fun mousePressed(e: MouseEvent) {
        if (table.isEditing && table.cellEditor == this) {
            isButtonColumnEditor = true
        }
    }

    override fun mouseReleased(e: MouseEvent) {
        if (isButtonColumnEditor && table.isEditing) {
            table.cellEditor.stopCellEditing()
        }
        isButtonColumnEditor = false
    }

    override fun mouseEntered(e: MouseEvent) {}
    override fun mouseExited(e: MouseEvent) {}

    enum class ColumnType {
        /**
         * Clear the row
         */
        CLEAR,

        /**
         * Delete the row
         */
        DELETE,

        /**
         * Add a new row before
         */
        ADD_BEFORE,

        /**
         * Add a new row after
         */
        ADD_AFTER,

        /**
         * Move row up
         */
        MOVE_UP,

        /**
         * Move row down
         */
        MOVE_DOWN
    }
}