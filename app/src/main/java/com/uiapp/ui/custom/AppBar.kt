package com.uiapp.ui.custom

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.uiapp.R
import com.uiapp.theme.colorWhite
import com.uiapp.theme.extraLargeRadius
import com.uiapp.theme.greyDarker
import com.uiapp.theme.smallSpacing


@Composable
fun AppBar(
    title:String? = null,
    canNavigateBack: Boolean = true,
    backNavigationIconClick:  () -> Unit = {},
    moreActions: @Composable (() -> Unit) = {}
){

    Row(
        modifier = Modifier.fillMaxWidth()
            .padding(smallSpacing)
    ) {
        if (canNavigateBack){
            IconButton(
                modifier = Modifier.background(
                    colorWhite,
                    RoundedCornerShape(extraLargeRadius))
                    .size(40.dp),
                onClick = {
                    backNavigationIconClick()
                }) {
                Icon(
                    modifier = Modifier.size(20.dp),
                    painter = painterResource(R.drawable.ic_back),
                    tint = greyDarker, contentDescription = "Back")
            }
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.CenterVertically)
                .weight(1f)
        ){
            title?.let {
                Text(
                    text = it,
                    style = MaterialTheme.typography.titleMedium,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth())
            }
        }

        moreActions()
    }

}



@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun Preview(){
    AppBar()
}