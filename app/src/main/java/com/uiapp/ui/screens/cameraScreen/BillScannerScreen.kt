package com.uiapp.ui.screens.cameraScreen

import android.Manifest
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.uiapp.R
import com.uiapp.theme.colorWhite
import com.uiapp.theme.extraLargeRadius
import com.uiapp.theme.mediumSpacing
import com.uiapp.theme.mediumText
import com.uiapp.theme.primaryFaded
import com.uiapp.theme.smallSpacing
import com.uiapp.theme.smallestSpacing
import com.uiapp.ui.custom.AppBar

@Preview
@Composable
fun BillScannerScreenPreview() {
    BillScannerScreen()
}

@Composable
fun BillScannerScreen(
    navController: NavController = rememberNavController()
) {

    var permissionGranted by remember { mutableStateOf(false) }
    val permissionLauncher = rememberLauncherForActivityResult(
            contract = ActivityResultContracts.RequestPermission()) { isGranted ->
        permissionGranted = isGranted
    }

    LaunchedEffect(Unit) {
        permissionLauncher.launch(Manifest.permission.CAMERA)
    }

    Box(modifier = Modifier.fillMaxHeight()) {

        if (permissionGranted) {
            ScannerPreview{ onImageCaptured ->
                //TODO handle image captured
            }
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AppBar(
                canNavigateBack = true,
                moreActions = {
                    AutoScan()
                },
                backNavigationIconClick = {
                    navController.popBackStack()
                },
            )
            Spacer(Modifier.padding(smallSpacing))

            BannerText()

            Spacer(Modifier.padding(smallSpacing))

            Box(
                modifier = Modifier.weight(1f)
                    .padding(mediumSpacing)
                    .fillMaxWidth()
            ){
                Image(
                    modifier = Modifier.fillMaxWidth()
                        .fillMaxHeight(),
                    painter = painterResource(R.drawable.camera_frame),
                    contentDescription = "Camera Frame")
            }

           Column(
               modifier = Modifier.padding(smallSpacing)
           ) {
               Spacer(Modifier.padding(smallSpacing))
               BillInfoCardSection()

               Spacer(Modifier.padding(smallSpacing))
               BottomControls(navController)
           }
        }
    }
}

@Composable
fun AutoScan() {
    Button(
        colors = ButtonDefaults.buttonColors().copy(
            containerColor = Color.Transparent
        ),
        contentPadding = PaddingValues.Zero,
        onClick = {
            //TODO
        }){
        Text(
            modifier = Modifier
                .background(primaryFaded,
                    RoundedCornerShape(extraLargeRadius))
                .padding(
                    top = smallestSpacing,
                    bottom = smallestSpacing,
                    end = mediumSpacing,
                    start = mediumSpacing
                ),
            text = "Auto",
            color = Color.White,
            fontSize = mediumText)
    }
}

@Composable
fun BannerText(){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .background(
            primaryFaded, RoundedCornerShape(extraLargeRadius))
            .padding(
                top = smallestSpacing,
                bottom = smallestSpacing,
                end = mediumSpacing,
                start = mediumSpacing)
    ) {
        Text(
            text = "Scanning bill...",
            color = colorWhite,
            style = MaterialTheme.typography.bodySmall
        )
    }
}