package com.uiapp.ui.screens.homeScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.uiapp.R
import com.uiapp.theme.extraLargeRadius
import com.uiapp.theme.extraLargeSpacing
import com.uiapp.theme.smallestSpacing


@Preview
@Composable
fun NavigationMoreActionsPreview(){
    NavigationMoreActions()
}

@Composable
fun NavigationMoreActions(){
    Row {
        Box(
            modifier = Modifier.size(extraLargeSpacing)
                .background(
                    color = Color.White,
                    shape = RoundedCornerShape(extraLargeRadius))
                .clickable{
                    //TODO
                }) {
            //TODO if this is going to be expanded, use searchBar
            Icon(
                painterResource(R.drawable.ic_search),
                contentDescription = "More Info",
                tint = Color.Gray,
                modifier = Modifier.size(20.dp)
                    .align(Alignment.Center)
            )
        }
        Spacer(Modifier.padding(smallestSpacing))
        Box(
            modifier = Modifier.size(extraLargeSpacing)
                .background(
                    color = Color.White,
                    shape = RoundedCornerShape(extraLargeRadius))
                .clickable{
                    //TODO
                }
        ) {
            IconButton(
                onClick = {

                }
            ){
                Icon(
                    painterResource(R.drawable.ic_notification),
                    contentDescription = "More Info",
                    tint = Color.Gray,
                    modifier = Modifier.size(20.dp)
                        .align(Alignment.Center)
                )
            }
        }
    }
}