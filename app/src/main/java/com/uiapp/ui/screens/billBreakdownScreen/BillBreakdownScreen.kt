package com.uiapp.ui.screens.billBreakdownScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.uiapp.R
import com.uiapp.theme.colorWhite
import com.uiapp.theme.primaryColor
import com.uiapp.theme.smallRadius
import com.uiapp.theme.smallSpacing
import com.uiapp.theme.smallestSpacing
import com.uiapp.ui.custom.AppBar
import com.uiapp.ui.custom.BillAmountSummarySection
import com.uiapp.ui.custom.ButtonsSection
import com.uiapp.ui.listItems.BillBreakdownItemView
import com.uiapp.ui.screens.billDetailsScreen.BillBreakdownSection


@Preview
@Composable
fun BillBreakdownPreview(){
    BillBreakdownScreen()
}

@Composable
fun BillBreakdownScreen(
    navController: NavController = rememberNavController()
){
    Column(
        modifier = Modifier.fillMaxWidth()
            .fillMaxHeight()
    ) {

        AppBar(
            canNavigateBack = true,
            title = "Chill Brekkie",
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
                BillBreakdownItemView()
            }

            Spacer(Modifier.padding(smallSpacing))
            Column(
                modifier = Modifier.background(color = colorWhite,
                    shape = RoundedCornerShape(smallRadius))
                    .padding(smallSpacing)
            ) {
                BillAmountSummarySection()
            }
        }

        ButtonsSection(
            primaryButtonText = "Confirm Result",
            shouldShowSecondaryButton = false,
            primaryButtonAction = {
                //TODO
            }
        )

    }
}


@Composable
fun MoreAction(){
    Button(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
        colors = ButtonDefaults.buttonColors().copy(
            containerColor = colorWhite,
        ),
        onClick = {
            //TODO
        }) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(smallestSpacing)
        ) {
            Text("Equal", color = primaryColor)
            Icon(
                modifier = Modifier.size(20.dp),
                painter = painterResource(R.drawable.ic_equal),
                tint = primaryColor, contentDescription = "Back")
        }
    }
}