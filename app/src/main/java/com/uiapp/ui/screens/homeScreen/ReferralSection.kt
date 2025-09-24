package com.uiapp.ui.screens.homeScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.uiapp.R
import com.uiapp.theme.extraLargeRadius
import com.uiapp.theme.mediumRadius
import com.uiapp.theme.mediumSpacing
import com.uiapp.theme.primaryColor
import com.uiapp.theme.primaryColorLighter
import com.uiapp.theme.smallSpacing
import com.uiapp.theme.smallestSpacing

@Preview
@Composable
fun ReferralSectionPreview(){
    ReferralSection()
}

@Composable
fun ReferralSection() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        ReferralHeaderText()
        Spacer(modifier = Modifier.height(mediumSpacing))
        Row(
            modifier = Modifier.fillMaxWidth()
                .height(220.dp), //TODO might need
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.Top
        ) {
            ReferralCodeSection()
            More()
        }
    }
}

@Composable
fun ReferralHeaderText(){
    Text(
        modifier = Modifier.fillMaxWidth(),
        text = "Refer a Friend",
        style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.W500))
}

@Composable
fun RowScope.ReferralCodeSection(){
    Card(
        modifier = Modifier
            .weight(1.3f)
            .fillMaxHeight()
            .padding(end = smallestSpacing),
        shape = RoundedCornerShape(mediumRadius),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(
            modifier = Modifier.padding(mediumSpacing),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            //TODO replace this with image loaded with coil library(if its a network image)
            Image(
                modifier = Modifier.weight(1f),
                painter = painterResource(R.drawable.ic_img),
                contentDescription = "Image",
            )

            Spacer(modifier = Modifier.height(smallSpacing))

            Button(
                contentPadding = PaddingValues.Zero,
                colors = ButtonDefaults.buttonColors().copy(
                    containerColor = primaryColorLighter
                ),
                onClick = {
                    //TODO copy referral code
                }) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        modifier = Modifier.fillMaxWidth()
                            .padding(start = mediumSpacing)
                            .weight(1f),
                        text = "Jellyhello2024",
                        color = primaryColor,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        style = MaterialTheme.typography.bodySmall)

                    Spacer(modifier = Modifier.width(smallSpacing))

                    Box(
                        modifier = Modifier.size(30.dp)
                            .background(
                                color = primaryColor,
                                shape = RoundedCornerShape(extraLargeRadius)),
                        contentAlignment = Alignment.Center){
                        Icon(
                            painterResource(id = R.drawable.ic_copy), // Replace with actual icon
                            contentDescription = "Scan",
                            modifier = Modifier.size(20.dp),
                            tint = primaryColorLighter
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun RowScope.More(){
    Column(modifier = Modifier.weight(1f).padding(start = smallestSpacing)) {
        Card(
            shape = RoundedCornerShape(mediumRadius),
            colors = CardDefaults.cardColors(containerColor = Color.White)
        ) {
            Column(
                modifier = Modifier.padding(mediumSpacing)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    modifier = Modifier.size(60.dp),
                    painter = painterResource(R.drawable.ic_coins),
                    contentDescription = "Coins")

                Spacer(modifier = Modifier.height(smallestSpacing))

                Text("Pay $50, Get $5", style = MaterialTheme.typography.bodySmall)
            }
        }

        Spacer(modifier = Modifier.height(smallSpacing))

        ViewProfileCard()
    }
}

@Composable
fun ViewProfileCard() {
    Card(
        shape = RoundedCornerShape(mediumRadius),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(
            modifier = Modifier.padding(mediumSpacing)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Your Buzz Level", style = MaterialTheme.typography.bodySmall)
            Spacer(modifier = Modifier.height(smallSpacing))
            Button(
                onClick = {
                    /*TODO Goto profile*/
                },
                shape = RoundedCornerShape(extraLargeRadius),
                colors = ButtonDefaults.buttonColors(containerColor = primaryColor)
            ) {
                Text("See Profile", fontSize = 12.sp)
            }
        }
    }
}