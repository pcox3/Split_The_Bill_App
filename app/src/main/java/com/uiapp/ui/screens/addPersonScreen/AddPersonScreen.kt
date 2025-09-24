package com.uiapp.ui.screens.addPersonScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.uiapp.theme.colorWhite
import com.uiapp.theme.errorColor
import com.uiapp.theme.largeSpacing
import com.uiapp.theme.smallSpacing
import com.uiapp.theme.smallestSpacing
import com.uiapp.ui.custom.AppBar
import com.uiapp.ui.custom.ButtonsSection
import com.uiapp.ui.custom.CancelButton
import com.uiapp.ui.custom.EditableText
import com.uiapp.ui.listItems.addPersonItemView.AddPersonHorizontalItemView
import com.uiapp.ui.listItems.addPersonItemView.AddPersonVerticalItemView

@Preview
@Composable
fun AddPersonScreenPreview(){
    AddPersonScreen()
}

@Composable
fun AddPersonScreen(
    navController: NavController = rememberNavController()
){

    Column {

        AppBar(
            canNavigateBack = true,
            title = "Who's Joining The Split",
            backNavigationIconClick = {
                navController.popBackStack()
            },
            moreActions = {
                CancelButton {
                    //TODO
                }
            }
        )


        LazyRow(
            modifier = Modifier.fillMaxWidth()
                .padding(smallestSpacing),
            verticalAlignment = Alignment.CenterVertically
        ) {
            //TODO update with list
            items(7){
                AddPersonVerticalItemView()
            }
        }

        EditableText(
            onValueChange = { it ->
                //TODO perform search
            },
            onSearch = { it ->
                //TODO perform search on keyboard action
            },
            modifier = Modifier.padding(smallSpacing),
            placeholder = "Search friends to split the bill...",
            showIcon = true,
            isOutlined = false,
            imeAction = ImeAction.Search
        )

        Card(
            colors = CardDefaults.cardColors().copy(
                containerColor = colorWhite
            ),
            modifier = Modifier.weight(1f)
                .fillMaxWidth()
                .padding(smallSpacing)
        ) {
            //TODO replace with data
            PersonList(
                listOf(
                    "Amara Blessing",
                    "Amaka Joy",
                    "Blessing Chika",
                    "Chidi Pascal",
                    "Chioma Ada"
                ),
                modifier = Modifier.fillMaxHeight()
                    .background(colorWhite)
                    .weight(1f)
                    .fillMaxWidth()
            )

            Spacer(Modifier.padding(smallSpacing))

            ButtonsSection(
                primaryButtonText = "Add Friends",
                secondaryButtonText = "Delete All",
                secondaryButtonColor = ButtonDefaults.outlinedButtonColors(
                    contentColor = errorColor
                ),
                primaryButtonAction = {
                    //TODO
                },
                secondaryButtonAction = {
                    //TODO
                }
            )
        }

    }

}


@Composable
fun PersonList(
    contacts: List<String>,
    modifier: Modifier
) {
    val groupedContacts = contacts.groupBy { it.first().uppercaseChar() }

    LazyColumn(
        modifier = modifier
    ) {
        groupedContacts.forEach { (initial, names) ->
            stickyHeader {
                Text(
                    text = initial.toString(),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = largeSpacing, top = smallSpacing),
                    style = MaterialTheme.typography.bodyLarge.copy(
                        color = Color.Gray
                    ),
                    fontWeight = FontWeight.Bold
                )
            }

            items(names) { name ->
                AddPersonHorizontalItemView(
                    personName = name
                )
                if(names.size < 4){
                    Spacer(modifier = Modifier.height(smallSpacing))
                }
            }
        }
    }
}