package com.uiapp.ui.screens.billDetailsScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.uiapp.theme.extraLargeSpacing
import com.uiapp.theme.mediumSpacing
import com.uiapp.theme.smallSpacing
import com.uiapp.ui.custom.BillAmountSummarySection
import com.uiapp.ui.custom.BillBreakdownHeader
import com.uiapp.ui.custom.ZigZagShape
import com.uiapp.ui.listItems.BillItemView


@Composable
fun BillBreakdownSection(
    title: String = "Gourmet Coffee",
    subtitle: String = "Sept 4, 2024   08:36 AM",
    data: List<String> = listOf("item1", "item2", "item3", "item4"),
    shouldDisplayTotal: Boolean = true,
    summaryItem: @Composable () -> Unit = {
        BillItemView()
    }
){
    Card(
        shape = ZigZagShape(50f, 50f),
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors().copy(containerColor = Color.White)
    ) {
        Column(
            Modifier.padding(start = smallSpacing, end = smallSpacing,
                top = extraLargeSpacing, bottom = extraLargeSpacing)) {

            BillBreakdownHeader(
                title = title,
                subtitle = subtitle
            )

            Spacer(Modifier.padding(mediumSpacing))

            //TODO populate with data
            data.forEachIndexed { index, string ->
                //Since there's no interaction the list, we simply iterate and render the items
                if(index != data.size - 1){
                    summaryItem()
                    Spacer(Modifier.padding(smallSpacing))
                }
            }

            Spacer(Modifier.padding(smallSpacing))

            if(shouldDisplayTotal)
                BillAmountSummarySection()

        }
    }
}

@Preview
@Composable
fun BillBreakdownSectionPreview(){
    BillBreakdownSection()
}