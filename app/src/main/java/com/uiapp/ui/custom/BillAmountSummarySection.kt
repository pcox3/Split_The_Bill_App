package com.uiapp.ui.custom

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.uiapp.theme.primaryColor

//TODO should take in the bill data for calculation
@Composable
fun BillAmountSummarySection(
    subTotalAmount: String = "$41.51",
    taxAmount: String = "$3.10",
    totalAmount: String = "$41.51"
) {
    Row {
        Text(
            text = "Subtotal",
            modifier = Modifier.weight(1f),
            color = Color.Gray, style = MaterialTheme.typography.titleSmall)
        Text(
            text = subTotalAmount,
            style = MaterialTheme.typography.titleSmall,
            color = Color.Gray)
    }
    Spacer(Modifier.padding(2.dp))
    Row {
        Text(
            text = "Tax",
            modifier = Modifier.weight(1f),
            color = primaryColor, style = MaterialTheme.typography.titleSmall)
        Text(
            text = taxAmount,
            style = MaterialTheme.typography.titleSmall,
            color = primaryColor)
    }
    Spacer(Modifier.padding(2.dp))
    Row {
        Text(
            text = "Total Bill",
            modifier = Modifier.weight(1f),
            style = MaterialTheme.typography.titleMedium.copy(
                fontWeight = FontWeight.W500
            ))
        Text(
            text = totalAmount,
            style = MaterialTheme.typography.titleMedium.copy(
                fontWeight = FontWeight.W500
            ))
    }
}