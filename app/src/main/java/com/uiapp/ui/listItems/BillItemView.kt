package com.uiapp.ui.listItems

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.uiapp.theme.greyDark
import com.uiapp.theme.smallSpacing

@Composable
fun BillItemView(
    shouldShowAmount: Boolean = true
){
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically

    ) {
        Text(text = "1X", style = MaterialTheme.typography.titleSmall.copy(
            color = greyDark
        ))
        Spacer(Modifier.padding(smallSpacing))
        Text(
            modifier = Modifier.weight(1f),
            text = "Chocolate Donut",
            style = MaterialTheme.typography.titleSmall.copy(
                fontWeight = FontWeight.W400
            ))
        if(shouldShowAmount){
            Spacer(Modifier.padding(smallSpacing))
            Text("$3.50", style = MaterialTheme.typography.titleSmall.copy(
                fontWeight = FontWeight.W700
            ))
        }
    }

}


@Preview
@Composable
fun BillItemViewPreview(){
    BillItemView()
}