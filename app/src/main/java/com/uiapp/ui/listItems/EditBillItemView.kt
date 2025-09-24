package com.uiapp.ui.listItems

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.uiapp.theme.smallestSpacing
import com.uiapp.ui.custom.EditableText

@Preview
@Composable
fun EditBillItemViewPreview(){
    EditBillItemView()
}

@Composable
fun EditBillItemView(){

    Row(
        modifier = Modifier.fillMaxWidth()
    ) {

        EditableText(
            height = 30.dp,
            padding = smallestSpacing,
            isWrapContentWidth = true,
            placeholder = "1x",
            onValueChange = {

            },
            radius = smallestSpacing
        )

        Spacer(Modifier.padding(smallestSpacing))

        Box(
            modifier = Modifier.weight(1f),
        ) {
            EditableText(
                padding = smallestSpacing,
                height = 30.dp,
                isWrapContentWidth = true,
                placeholder = "Caesar Salad",
                onValueChange = {

                },
                radius = smallestSpacing
            )
        }

        Spacer(Modifier.padding(smallestSpacing))

        EditableText(
            padding = smallestSpacing,
            height = 30.dp,
            isWrapContentWidth = true,
            placeholder = "$4.60",
            onValueChange = {

            },
            radius = smallestSpacing
        )

    }
}