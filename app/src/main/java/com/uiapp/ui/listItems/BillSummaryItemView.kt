package com.uiapp.ui.listItems

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.uiapp.R
import com.uiapp.navigation.Route
import com.uiapp.theme.primaryColor
import com.uiapp.theme.smallSpacing
import com.uiapp.theme.smallestSpacing


@Preview
@Composable
fun BillSummaryItemPreview(){
    BillSummaryItemView()
}

@Composable
fun BillSummaryItemView(
    navController: NavController = rememberNavController(),
    summaryTitle: String = "Jelly's Total",
    summaryAMount: String = "$12.63"
){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(Color.White)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = androidx.compose.ui.Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.Face, // You can replace with custom dinner icon
                contentDescription = "Dinner Icon",
                tint = Color(0xFFFF9800), // Orange color
                modifier = Modifier.size(40.dp)
            )
            Text(
                modifier = Modifier
                    .weight(1f)
                    .padding(smallSpacing),
                text = summaryTitle,
                style = MaterialTheme.typography.titleSmall.copy(
                    fontWeight = FontWeight.W500
                ))
            Text(summaryAMount, style = MaterialTheme.typography.titleSmall.copy(
                fontWeight = FontWeight.W700
            ))
        }
        Column(
            Modifier.padding(
                start = smallSpacing
            )
        ){
            val data = listOf("item1", "item2")
            data.forEachIndexed { index, string ->
                BillItemView(
                    shouldShowAmount = false
                )
                if(index != data.size - 1){
                    Spacer(Modifier.padding(smallestSpacing))
                }
            }

            Spacer(Modifier.padding(smallestSpacing))
            Row {
                Spacer(modifier = Modifier.weight(.13f))
                Text(
                    modifier = Modifier.weight(1f),
                    text = "Bill Details",
                    color = primaryColor,
                    style = MaterialTheme.typography.titleSmall
                )
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.ic_dropdown), // You can replace with custom dinner icon
                    contentDescription = "Dinner Icon",
                    tint = primaryColor, // Orange color
                    modifier = Modifier
                        .size(20.dp)
                        .clickable {
                            //TODO
                            navController.navigate(Route.EDIT_BILL)
                        }
                )
            }
        }
    }

}