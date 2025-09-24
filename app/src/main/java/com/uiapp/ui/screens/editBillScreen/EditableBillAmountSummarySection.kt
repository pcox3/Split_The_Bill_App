package com.uiapp.ui.screens.editBillScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.uiapp.theme.primaryColor
import com.uiapp.theme.smallestSpacing
import com.uiapp.ui.custom.EditableText

@Preview
@Composable
fun EditableBillAmountSummarySectionPreview(){
    EditableBillAmountSummarySection()
}

//TODO should take in the bill data for calculation
@Composable
fun EditableBillAmountSummarySection(
    subTotalAmount: String = "$41.51",
    taxAmount: String = "$3.10",
    totalAmount: String = "$41.51"
) {
    Column {
        Row {
            Text(
                text = "Subtotal",
                modifier = Modifier.weight(1f),
                color = Color.Gray, style = MaterialTheme.typography.titleSmall
            )

            EditableText(
                height = 30.dp,
                onValueChange = {

                },
                placeholder = subTotalAmount,
                isWrapContentWidth = true,
                radius = smallestSpacing,
                textStyle = MaterialTheme.typography.titleSmall.copy(
                    color = Color.Gray
                )
            )
        }
        Spacer(Modifier.padding(2.dp))
        Row {
            Text(
                text = "Tax",
                modifier = Modifier.weight(1f),
                color = primaryColor, style = MaterialTheme.typography.titleSmall)

            EditableText(
                height = 30.dp,
                onValueChange = {

                },
                placeholder = taxAmount,
                isWrapContentWidth = true,
                radius = smallestSpacing,
                textStyle = MaterialTheme.typography.titleSmall.copy(
                    color = primaryColor
                )
            )
        }
        Spacer(Modifier.padding(2.dp))
        Row {
            Text(
                text = "Total Bill",
                modifier = Modifier.weight(1f),
                style = MaterialTheme.typography.titleMedium.copy(
                    fontWeight = FontWeight.W500
                ))
            EditableText(
                height = 30.dp,
                onValueChange = {

                },
                placeholder = totalAmount,
                isWrapContentWidth = true,
                radius = smallestSpacing,
                textStyle = MaterialTheme.typography.titleMedium.copy()
            )
        }
    }
}