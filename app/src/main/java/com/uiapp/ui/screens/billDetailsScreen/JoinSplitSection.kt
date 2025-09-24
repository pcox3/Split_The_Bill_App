package com.uiapp.ui.screens.billDetailsScreen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.uiapp.R
import com.uiapp.navigation.Route
import com.uiapp.theme.primaryColor

//TODO replace with actual person avatar
@Composable
fun JoinSplitSection(
    navController: NavController = rememberNavController()
){
    Row {
        Row(
            modifier = Modifier.weight(1f),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.Face,
                contentDescription = "Dinner Icon",
                tint = Color(0xFFFF9800),
                modifier = Modifier.size(35.dp)
            )
            Icon(
                imageVector = Icons.Default.Face,
                contentDescription = "Dinner Icon",
                tint = Color(0xFFFF9800),
                modifier = Modifier.size(35.dp)
            )
            Icon(
                imageVector = Icons.Default.Face,
                contentDescription = "Dinner Icon",
                tint = Color(0xFFFF9800),
                modifier = Modifier.size(35.dp)
            )
        }

        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.ic_add),
            contentDescription = "Dinner Icon",
            tint = primaryColor,
            modifier = Modifier
                .size(35.dp)
                .clickable(onClick = {
                    navController.navigate(Route.ADD_PERSON)
                })
        )
    }
}

@Preview
@Composable
fun JoinSplitSectionPreview(){
    JoinSplitSection()
}
