package com.uiapp.ui.listItems.addPersonItemView

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.uiapp.theme.smallSpacing
import com.uiapp.theme.smallestSpacing
import com.uiapp.ui.custom.CircularCheckbox

@Preview
@Composable
fun AddPersonHorizontalItemViewPreview(){
    AddPersonHorizontalItemView()
}

@Composable
fun AddPersonHorizontalItemView(
    checkedState: (Boolean) -> Unit = {},
    personName: String = "Amara Blessing"
){

    var isChecked by remember { mutableStateOf(false) }

    Row(
        modifier = Modifier.fillMaxWidth()
            .padding(smallSpacing),
        verticalAlignment = androidx.compose.ui.Alignment.CenterVertically
    ) {
        Icon(
            imageVector = Icons.Default.Face,
            modifier = Modifier.size(35.dp),
            contentDescription = "Person")

        Spacer(Modifier.padding(smallestSpacing))

        Text(
            modifier = Modifier.weight(1f),
            text = personName,
            style = MaterialTheme.typography.titleMedium
        )

        CircularCheckbox(isChecked, {
            isChecked = it
            checkedState(it)
        })

    }

}