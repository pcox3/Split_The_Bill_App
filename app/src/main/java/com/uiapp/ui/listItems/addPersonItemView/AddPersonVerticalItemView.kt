package com.uiapp.ui.listItems.addPersonItemView

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.uiapp.theme.smallSpacing
import com.uiapp.theme.smallestText

@Preview
@Composable
fun AddPersonVerticalItemViewPreview(){
    AddPersonVerticalItemView()
}

@Composable
fun AddPersonVerticalItemView(){

    Column(
        modifier = Modifier.wrapContentWidth()
            .padding(smallSpacing),
        horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally
    ) {
        Icon(
            imageVector = Icons.Default.Face,
            modifier = Modifier.size(35.dp),
            contentDescription = "Person")

        Text(
            text = "Amara",
            style = MaterialTheme.typography.titleMedium.copy(
                fontSize = smallestText
            )
        )
    }

}