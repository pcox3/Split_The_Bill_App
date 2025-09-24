package com.uiapp.ui.screens.homeScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.uiapp.R
import com.uiapp.navigation.Route
import com.uiapp.theme.extraLargeRadius
import com.uiapp.theme.mediumSpacing
import com.uiapp.theme.primaryColor
import com.uiapp.theme.smallSpacing

@Composable
fun BottomNavigationSection(
    navController: NavController = rememberNavController()
){
    Card(
        modifier = Modifier.wrapContentWidth(),
        shape = RoundedCornerShape(extraLargeRadius),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(
            modifier = Modifier.padding(vertical = smallSpacing, horizontal = mediumSpacing),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            //TODO replace with button to make clickable
            Icon(painterResource(R.drawable.ic_email),
                contentDescription = "Home", tint = Color.Gray)

            Spacer(modifier = Modifier.width(mediumSpacing))

            Button(
                modifier = Modifier.size(40.dp),
                contentPadding = PaddingValues.Zero,
                shape = CircleShape,
                colors = ButtonDefaults.buttonColors(containerColor = primaryColor),
                onClick = {
                    navController.navigate(Route.CAMERA)
                }
            ) {
                Icon(
                    painterResource(id = R.drawable.ic_camera), // Replace with actual icon
                    contentDescription = "Scan",
                    tint = Color.White,
                )
            }

            Spacer(modifier = Modifier.width(mediumSpacing))

            Icon(imageVector = Icons.Filled.Refresh, //TODO replace with Button to make clickable
                contentDescription = "Refresh", tint = Color.Gray)
        }
    }
}


@Preview
@Composable
fun BottomNavigationSectionPreview(){
    BottomNavigationSection()
}