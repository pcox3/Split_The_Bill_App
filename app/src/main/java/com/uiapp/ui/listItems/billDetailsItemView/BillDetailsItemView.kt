package com.uiapp.ui.listItems.billDetailsItemView

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DividerDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.uiapp.navigation.Route
import com.uiapp.theme.mediumSpacing
import com.uiapp.theme.smallRadius
import com.uiapp.theme.smallSpacing


@Composable
fun BillDetailsItemView(
    navController: NavController = rememberNavController()
) {
    Card(
        modifier = Modifier
            .clickable{
                navController.navigate(Route.BILL_SUMMARY)
            }
            .fillMaxWidth(),
        colors = CardDefaults.cardColors().copy(containerColor = Color.White),
        shape = RoundedCornerShape(smallRadius),
    ) {
        Column(modifier = Modifier.padding(mediumSpacing)) {
            BillTitleAndAmount()
            HorizontalDivider(
                modifier = Modifier.padding(vertical = smallSpacing),
                thickness = 1.dp,
                color = DividerDefaults.color
            )
            PersonsSection()
        }
    }
}



@Preview
@Composable
fun BillDetailsItemViewPreview() {
    BillDetailsItemView()
}

//TODO will be replace with vector icons
@Composable
fun Avatar(color: Color) {
    Box(
        modifier = Modifier
            .size(28.dp)
            .clip(CircleShape)
            .background(color)
            .border(2.dp, Color.White, CircleShape)
    )
}