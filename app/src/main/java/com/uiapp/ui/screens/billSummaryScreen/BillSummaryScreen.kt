package com.uiapp.ui.screens.billSummaryScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.uiapp.R
import com.uiapp.theme.colorWhite
import com.uiapp.theme.extraLargeRadius
import com.uiapp.theme.primaryColor
import com.uiapp.theme.smallSpacing
import com.uiapp.ui.custom.AppBar
import com.uiapp.ui.custom.ButtonsSection
import com.uiapp.ui.listItems.BillSummaryItemView
import com.uiapp.ui.screens.billDetailsScreen.BillBreakdownSection

@Preview
@Composable
fun BillScannerScreenPreview(){
    BillSummaryScreen()
}

@Composable
fun BillSummaryScreen(
    navController: NavController = rememberNavController()
){
    Column(
        modifier = Modifier.fillMaxWidth()
            .fillMaxHeight()
    ) {

        AppBar(
            canNavigateBack = true,
            title = "Bill Split Summary",
            backNavigationIconClick = {
                navController.popBackStack()
            },
            moreActions = {
                MoreAction()
            }
        )

        Column(
            modifier = Modifier.fillMaxWidth()
                .weight(1f)
                .padding(smallSpacing)
        ) {
            //TODO can take in title and subtitle
            BillBreakdownSection(
                shouldDisplayTotal = false
            ){
                BillSummaryItemView(navController)
            }
        }

        ButtonsSection(
            primaryButtonText = "Copy Link",
            secondaryButtonText = "Save Bill",
            primaryButtonAction = {
                //TODO
            }
        ) {
            //TODO
        }

    }
}


@Composable
fun MoreAction(){
    IconButton(
        modifier = Modifier.background(
            colorWhite,
            RoundedCornerShape(extraLargeRadius))
            .size(40.dp),
        onClick = {

        }) {
        Icon(
            modifier = Modifier.size(20.dp),
            painter = painterResource(R.drawable.ic_share),
            tint = primaryColor, contentDescription = "Back")
    }
}