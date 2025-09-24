package com.uiapp.ui.screens.cameraScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import com.uiapp.theme.colorWhite
import com.uiapp.theme.primaryFaded

@Composable
fun BottomControls(
    navController: NavController = rememberNavController()
) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(
            modifier = Modifier.background(primaryFaded,
                shape = CircleShape), onClick = {
                /* Gallery */
            }) {
            Icon(painterResource(R.drawable.ic_gallery),
                contentDescription = "Gallery", tint = Color.White)
        }
        Spacer(Modifier.weight(1f))

        IconButton(
            modifier = Modifier
                .size(72.dp)
                .background(Color.Transparent, shape = CircleShape),
            onClick = {
                //TODO replace with capture image
                navController.navigate(Route.BILLS_DETAILS)
            }
        ){
            Icon(
                modifier = Modifier.fillMaxWidth()
                    .fillMaxHeight(),
                tint = colorWhite,
                painter = painterResource(R.drawable.ic_capture),
                contentDescription = "Capture")
        }

        Spacer(Modifier.weight(1f))

        IconButton(
            modifier = Modifier
                .background(primaryFaded, shape = CircleShape),
            onClick = {
                /* Flash */
            }) {
            Icon(painterResource(R.drawable.ic_flash),
                contentDescription = "Flash", tint = Color.White)
        }
    }
}


@Preview
@Composable
fun ButtonControlsPreview(){
    BottomControls()
}