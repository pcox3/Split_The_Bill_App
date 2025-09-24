package com.uiapp.ui.custom

import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection


class ZigZagShape(
    private val zigZagHeight: Float = 16f,
    private val zigZagWidth: Float = 16f
) : Shape {
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {
        val path = Path().apply {
            moveTo(0f, 0f)
            var x = 0f
            var up = true
            while (x < size.width) {
                val nextX = (x + zigZagWidth).coerceAtMost(size.width)
                val y = if (up) zigZagHeight else 0f
                lineTo(nextX, y)
                x = nextX
                up = !up
            }

            lineTo(size.width, size.height - zigZagHeight)

            x = size.width
            up = true
            while (x > 0f) {
                val nextX = (x - zigZagWidth).coerceAtLeast(0f)
                val y = if (up) size.height else size.height - zigZagHeight
                lineTo(nextX, y)
                x = nextX
                up = !up
            }

            lineTo(0f, 0f)
            close()
        }
        return Outline.Generic(path)
    }
}