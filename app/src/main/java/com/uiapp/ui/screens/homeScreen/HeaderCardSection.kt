package com.uiapp.ui.screens.homeScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import com.uiapp.theme.extraLargeRadius
import com.uiapp.theme.mediumRadius
import com.uiapp.theme.mediumSpacing
import com.uiapp.theme.primaryColor
import com.uiapp.theme.smallSpacing

@Composable
fun HeaderCardSection() {
    Card(
        modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth(),
        colors = CardDefaults.cardColors().copy(containerColor = Color.White),
        shape = RoundedCornerShape(mediumRadius)
    ) {
        Column(
            modifier = Modifier
                .padding(20.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Welcome back, Jelly!",
                style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.W500)
            )

            Spacer(modifier = Modifier.height(smallSpacing))

            AmountText()

            Spacer(modifier = Modifier.height(mediumSpacing))

            Button(
                onClick = {

                },
                shape = RoundedCornerShape(extraLargeRadius)
            ) {
                Text("Pay Bills")
            }
        }
    }
}

@Composable
fun AmountText(){
    Text(
        text = buildAnnotatedString {
            append("You have in total ")
            withStyle(
                style = SpanStyle(color = primaryColor)
            ) {
                append("$${"%.2f".format(430.00)}")
            }
            append(" unpaid bills.")
        },
        color = Color.Gray,
        style = MaterialTheme.typography.bodySmall,
        textAlign = TextAlign.Center
    )
}