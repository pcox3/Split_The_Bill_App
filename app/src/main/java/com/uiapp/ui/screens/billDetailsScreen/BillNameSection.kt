package com.uiapp.ui.screens.billDetailsScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.uiapp.theme.smallSpacing
import com.uiapp.theme.smallestSpacing
import com.uiapp.ui.custom.EditableText

@Preview
@Composable
fun BillNameSectionPreview(){
    BillNameSection()
}

@Composable
fun BillNameSection(
    navController: NavController = rememberNavController(),
    data: (String?, String?) -> Unit = {
            billName, category ->
    },
){
    var billName by rememberSaveable { mutableStateOf("") }
    var category by rememberSaveable { mutableStateOf("") }

    Card(
        colors = CardDefaults.cardColors().copy(containerColor = Color.White),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(smallSpacing)
        ) {
            Text(
                text = "Bill's Name",
                style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.W500))

            Spacer(Modifier.padding(smallestSpacing))

            EditableText(
                onValueChange = {
                    billName = it
                    data(billName, category)
                }
            )

            Spacer(Modifier.padding(smallestSpacing))
            Text(
                text = "Category",
                style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.W500))

            Spacer(Modifier.padding(smallestSpacing))

            BillCategoryDropDown({
                category = it
                data(billName, category)
            })

            Spacer(Modifier.padding(smallSpacing))

            Text(
                text = "Who's Join the Split",
                style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.W500))

            Spacer(Modifier.padding(smallestSpacing))

            JoinSplitSection(navController)

        }
    }
}