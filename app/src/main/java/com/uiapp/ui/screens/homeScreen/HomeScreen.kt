package com.uiapp.ui.screens.homeScreen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.uiapp.theme.greyLight
import com.uiapp.theme.mediumSpacing
import com.uiapp.theme.smallSpacing
import com.uiapp.ui.custom.AppBar
import com.uiapp.ui.listItems.billDetailsItemView.BillDetailsItemView

@Composable
fun HomeScreen(
    navController: NavController = rememberNavController()
){
    Surface(
        color = greyLight,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),) {

        Column(modifier = Modifier.padding(
            end = smallSpacing,
            start = smallSpacing,
            bottom = smallSpacing)) {

            AppBar(
                canNavigateBack = false,
                moreActions = {
                    NavigationMoreActions()
                }
            )
            LazyColumn(modifier = Modifier.weight(1f)) {
                item { HeaderCardSection() }

                item { Spacer(modifier = Modifier.height(mediumSpacing)) }
                item {
                    RecentBillsHeader()
                }

                items(2){ count ->
                    BillDetailsItemView(navController)
                   if(count < 1){
                       Spacer(modifier = Modifier.height(smallSpacing))
                   }
                }

                item { Spacer(modifier = Modifier.height(mediumSpacing)) }
                item { ReferralSection() }
            }
            Spacer(Modifier.size(mediumSpacing))
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.BottomCenter
            ){
                BottomNavigationSection(navController)
            }
        }
    }
}

@Composable
fun RecentBillsHeader() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            modifier = Modifier.weight(1f),
            text = "Recent Bills",
            style = MaterialTheme.typography.titleMedium.copy(
                fontWeight = FontWeight.W500
            )
        )

        TextButton(
            contentPadding = PaddingValues.Zero,
            onClick = {
                //TODO view all bills
            }
        ) {
            Text(
                text = "View All",
                style = MaterialTheme.typography.bodySmall.copy
                    (color = Color.Gray))
        }
    }
}


@Preview
@Composable
fun HomeScreenPreview(){
    HomeScreen()
}
