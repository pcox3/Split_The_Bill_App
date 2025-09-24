package com.uiapp.ui.screens.cameraScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.uiapp.theme.colorWhite
import com.uiapp.theme.largeText
import com.uiapp.theme.mediumRadius
import com.uiapp.theme.mediumSpacing
import com.uiapp.theme.primaryColor
import com.uiapp.theme.primaryColorLight
import com.uiapp.theme.smallRadius
import com.uiapp.theme.smallSpacing
import com.uiapp.theme.smallText

@Composable
fun BillInfoCardSection() {

    var splitBillCheckState by remember { mutableStateOf(false) }

    Card(
        shape = RoundedCornerShape(mediumRadius),
        colors = CardDefaults.cardColors().copy(
            containerColor = Color.White
        ),
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier.fillMaxWidth()
                    .padding(smallSpacing)
                    .weight(1f)
            ) {
                Text("Gourmet Coffee", style = MaterialTheme.typography.titleMedium.copy(
                    fontWeight = FontWeight.Bold
                ))
                Text("60th Ave New York", color = Color.Gray, fontSize = smallText)

                Spacer(Modifier.padding(smallSpacing))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        modifier = Modifier.weight(1f),
                        text = "$44.61", style = MaterialTheme.typography.titleMedium.copy(
                            fontWeight = FontWeight.Bold,
                            fontSize = largeText
                        ))
                    Text("Sept 4, 2024", color = Color.Gray,
                        style = MaterialTheme.typography.labelMedium.copy(
                            fontSize = smallText
                        ))
                }
            }
            Column(
                modifier = Modifier
                    .background(
                        color = primaryColor,
                        shape = RoundedCornerShape(smallRadius)
                    ).padding(mediumSpacing),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.End
            ) {
                Text("$3.10", color = primaryColorLight,
                    style = MaterialTheme.typography.labelSmall)
                Text("Split Tax",
                    style = MaterialTheme.typography.titleSmall.copy(
                        color = colorWhite
                        , fontWeight = FontWeight.W400
                    ))
                Switch(checked = splitBillCheckState,
                    onCheckedChange = {
                        splitBillCheckState = it
                    },
                    colors = SwitchDefaults.colors(
                        checkedThumbColor = primaryColor,
                        checkedTrackColor = colorWhite,
                        uncheckedThumbColor = primaryColor,
                        uncheckedTrackColor = colorWhite
                    ))
            }
        }
    }
}

@Preview
@Composable
fun BillInfoCardSectionPreview(){
    BillInfoCardSection()
}