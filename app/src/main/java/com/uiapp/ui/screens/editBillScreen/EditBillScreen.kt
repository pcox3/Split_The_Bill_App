package com.uiapp.ui.screens.editBillScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.uiapp.R
import com.uiapp.navigation.Route
import com.uiapp.theme.extraLargeSpacing
import com.uiapp.theme.largeSpacing
import com.uiapp.theme.primaryColor
import com.uiapp.theme.smallSpacing
import com.uiapp.theme.smallestSpacing
import com.uiapp.ui.custom.AppBar
import com.uiapp.ui.custom.ButtonsSection
import com.uiapp.ui.custom.CancelButton
import com.uiapp.ui.custom.ZigZagShape
import com.uiapp.ui.listItems.EditBillItemView

@Preview
@Composable
fun EditBillScreenPreview(){
    EditBillScreen()
}

@Composable
fun EditBillScreen(
    navController: NavController = rememberNavController()
){

    Column(
        modifier = Modifier.fillMaxSize()
            .fillMaxHeight()
    ){

        AppBar(
            title = "Edit Bill",
            backNavigationIconClick = { navController.popBackStack()},
            moreActions = {
                CancelButton {
                    //TODO
                }
            }
        )

        Spacer(Modifier.padding(smallSpacing))

        Box(
            modifier = Modifier.weight(1f)
                .padding(smallSpacing)
        ) {
            Card(
                shape = ZigZagShape(50f, 50f),
                modifier = Modifier.fillMaxWidth()
                    .wrapContentHeight(),
                colors = CardDefaults.cardColors().copy(containerColor = Color.White)
            ){

                Column(
                    modifier = Modifier.padding(start = smallSpacing, end = smallSpacing,
                        top = extraLargeSpacing, bottom = extraLargeSpacing)
                ) {
                    EditableBillBreakdownHeader()

                    Spacer(Modifier.padding(largeSpacing))

                    /**
                     * TODO list goes here.
                     */
                    LazyColumn {

                        items(4){
                            EditBillItemView()
                            if (it < 4){
                                Spacer(Modifier.padding(smallSpacing))
                            }
                        }
                    }

                    TextButton(
                        contentPadding = PaddingValues.Zero,
                        onClick = {
                            //TODO
                        }
                    ) {
                        Row(
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            Icon(
                                imageVector = ImageVector.vectorResource(
                                    R.drawable.ic_add_outline
                                ),
                                contentDescription = "Add Item",
                                tint = primaryColor

                            )
                            Spacer(Modifier.padding(smallestSpacing))
                            Text("Add Item")
                        }
                    }


                    Spacer(Modifier.padding(largeSpacing))

                    EditableBillAmountSummarySection()
                }

            }
        }

        ButtonsSection(
            primaryButtonText = "Save Edit",
            shouldShowSecondaryButton = false,
            primaryButtonAction = {
                //TODO replace with actual route
                navController.navigate(Route.SUMMARY_BREAKDOWN)
            }
        )

    }

}