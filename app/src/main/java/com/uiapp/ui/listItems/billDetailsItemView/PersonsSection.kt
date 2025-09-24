package com.uiapp.ui.listItems.billDetailsItemView

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.uiapp.theme.primaryColor
import com.uiapp.theme.primaryFaded
import com.uiapp.theme.smallestSpacing
import com.uiapp.theme.smallestText

@Preview
@Composable
fun PersonSectionPreview(){
    PersonsSection()
}

@Composable
fun PersonsSection(){
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {

            //TODO Convert this to a dynamic list
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(smallestSpacing)
            ) {
                items(3){
                    //TODO refers to the person avatar
                    Avatar(Color(0xFF0D47A1))
                }
            }

            Spacer(Modifier.padding(smallestSpacing))

            //TODO this should be made hideable based on the number of persons
            Box(
                modifier = Modifier
                    .wrapContentSize()
                    .background(primaryFaded, CircleShape)
                    .padding(5.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "+2",
                    style = MaterialTheme.typography.labelSmall.copy(
                        fontWeight = FontWeight.Medium,
                        color = primaryColor),
                )
            }
        }

        val styled = buildAnnotatedString {
            withStyle(SpanStyle(color = Color.Gray)) { append("Sharing: ") }
            withStyle(SpanStyle(color = primaryColor)) { append("5 Persons") }
        }

        Text(
            text = styled,
            style = MaterialTheme.typography.bodySmall.copy(
                fontSize = smallestText
            )
        )
    }
}