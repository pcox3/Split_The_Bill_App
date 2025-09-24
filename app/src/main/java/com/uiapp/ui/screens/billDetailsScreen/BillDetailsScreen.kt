package com.uiapp.ui.screens.billDetailsScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.uiapp.R
import com.uiapp.theme.colorWhite
import com.uiapp.theme.errorColor
import com.uiapp.theme.greyLight
import com.uiapp.theme.smallSpacing
import com.uiapp.ui.custom.AppBar
import com.uiapp.ui.custom.ButtonsSection

@Composable
fun BillDetailsScreen(
  navController: NavController = rememberNavController()
){

  val scrollState = rememberScrollState()
  Surface(
    color = greyLight,
    modifier = Modifier.fillMaxWidth()
      .fillMaxHeight()) {
    Column {
      AppBar(
        canNavigateBack = true,
        title = "Recognized Items",
        backNavigationIconClick = {
          navController.popBackStack()
        },
        moreActions = {
          AppBarInfoIcon()
        })

      Column(
        modifier = Modifier.weight(1f).fillMaxSize()
          .verticalScroll(scrollState)
        .padding(smallSpacing)) {

        BillBreakdownSection() //TODO can take in title and subtitle

        Spacer(Modifier.padding(smallSpacing))

        BillNameSection(navController){
          billName, category ->
          
        }
      }
      ButtonsSection(
        secondaryButtonColor = ButtonDefaults.outlinedButtonColors().copy(
          contentColor = errorColor
        )
      )
    }
  }
}


@Composable
fun AppBarInfoIcon() {
  IconButton(
    modifier = Modifier.size(40.dp),
    colors = IconButtonDefaults.iconButtonColors().copy(
      containerColor = colorWhite
    ),
    onClick = {
      //TODO
    }) {
    Icon(
      painterResource(R.drawable.ic_info),
      contentDescription = "More Info",
      tint = Color.Gray,
      modifier = Modifier.size(20.dp)
    )
  }
}



@Preview
@Composable
fun BillDetailsScreenPreview() {
  BillDetailsScreen()
}