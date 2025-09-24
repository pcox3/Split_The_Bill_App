package com.uiapp.ui.screens.billDetailsScreen

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.PopupProperties
import com.uiapp.theme.extraLargeRadius
import com.uiapp.theme.largeSpacing
import com.uiapp.theme.primaryColor
import com.uiapp.theme.smallRadius
import com.uiapp.theme.smallSpacing

@Composable
fun BillCategoryDropDown(
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    options: List<String> = arrayListOf("Coffee", "Chocolate", "Tea"),
    placeholder: String = "",
    radius: Dp = extraLargeRadius,
    padding: Dp = smallSpacing,
    textStyle: TextStyle = MaterialTheme.typography.bodyMedium,
    leadingIcon: ImageVector? = null,
    iconTint: Color = MaterialTheme.colorScheme.onSurface
) {
    var expanded by remember { mutableStateOf(false) }
    var value by remember { mutableStateOf("") }

    val borderColor = if (expanded)
        primaryColor
    else
        MaterialTheme.colorScheme.outline.copy(alpha = 1f)

    val shape = RoundedCornerShape(radius)

    Column(modifier = modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clip(shape)
                .border(width = 1.dp, color = borderColor, shape = shape)
                .clickable { expanded = !expanded }
                .padding(padding),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                if (leadingIcon != null) {
                    Icon(
                        imageVector = leadingIcon,
                        contentDescription = null,
                        tint = iconTint,
                        modifier = Modifier.padding(end = smallSpacing)
                    )
                }

                Text(
                    text = value.ifEmpty { placeholder },
                    style = textStyle.copy(color = MaterialTheme.colorScheme.onSurface)
                )
            }
            Icon(
                modifier = Modifier.size(largeSpacing),
                imageVector = if (expanded) Icons.Filled.KeyboardArrowUp
                else Icons.Filled.KeyboardArrowDown,
                contentDescription = null,
                tint = iconTint
            )
        }
        DropdownMenu(
            modifier = Modifier.fillMaxWidth(0.9f),
            shape = RoundedCornerShape(smallRadius),
            expanded = expanded,
            offset = DpOffset(x = 0.dp, y = 10.dp),
            properties = PopupProperties(
                focusable = true,
                clippingEnabled = false
            ),
            onDismissRequest = { expanded = false }
        ) {
            options.forEach { option ->
                DropdownMenuItem(
                    text = { Text(option) },
                    onClick = {
                        value = option
                        onValueChange(option)
                        expanded = false
                    }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun EditableDropdownPreview() {
    BillCategoryDropDown(
        onValueChange = {  },
        options = listOf("Espresso", "Cappuccino", "Latte", "Mocha"),
        placeholder = "Select Coffee"
    )
}