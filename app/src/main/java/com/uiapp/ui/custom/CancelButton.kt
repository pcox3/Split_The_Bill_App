package com.uiapp.ui.custom

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.uiapp.R
import com.uiapp.theme.colorWhite
import com.uiapp.theme.errorColor
import com.uiapp.theme.extraLargeRadius

@Preview
@Composable
fun CancelButtonPreview(){
    CancelButton()
}

@Composable
fun CancelButton(
    action: () -> Unit = {}
){
    IconButton(
        modifier = Modifier.background(
            colorWhite,
            RoundedCornerShape(extraLargeRadius))
            .size(40.dp),
        onClick = {
            action()
        }) {
        Icon(
            modifier = Modifier.size(20.dp),
            painter = painterResource(R.drawable.ic_cancel),
            tint = errorColor, contentDescription = "Back")
    }
}