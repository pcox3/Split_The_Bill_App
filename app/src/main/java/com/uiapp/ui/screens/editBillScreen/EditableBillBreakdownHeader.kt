package com.uiapp.ui.screens.editBillScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.uiapp.theme.smallSpacing
import com.uiapp.theme.smallestSpacing
import com.uiapp.ui.custom.EditableText

@Preview
@Composable
fun EditableBillBreakdownHeaderPreview(){
    EditableBillBreakdownHeader()
}

@Composable
fun EditableBillBreakdownHeader() {
    Column(
        Modifier.fillMaxWidth(),
    ) {
        EditableText(
            padding = smallSpacing,
            onValueChange = {},
            modifier = Modifier.align(Alignment.CenterHorizontally),
            placeholder = "Gourmet Coffee",
            isWrapContentWidth = true,
            radius = smallestSpacing,
            textStyle = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.W500)
        )

        Spacer(Modifier.padding(smallestSpacing))

        Row(
            modifier = Modifier.wrapContentWidth()
                .align(Alignment.CenterHorizontally),
        ) {

            EditableText(
                height = 30.dp,
                padding = smallestSpacing,
                onValueChange = {},
                modifier = Modifier.wrapContentWidth(),
                placeholder = "Sept 4. 2024",
                isWrapContentWidth = true,
                radius = smallestSpacing,
                textStyle = MaterialTheme.typography.titleSmall.copy(
                    color = Color.Gray,
                )
            )

            Spacer(Modifier.padding(smallSpacing))

            EditableText(
                height = 30.dp,
                padding = smallestSpacing,
                onValueChange = {},
                placeholder = "08:36 AM",
                isWrapContentWidth = true,
                radius = smallestSpacing,
                textStyle = MaterialTheme.typography.titleSmall.copy(
                color = Color.Gray)
            )

        }
    }
}