package com.uiapp.ui.listItems

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.uiapp.R
import com.uiapp.theme.extraLargeRadius
import com.uiapp.theme.grey
import com.uiapp.theme.iconColor
import com.uiapp.theme.largeRadius
import com.uiapp.theme.smallSpacing

@Preview
@Composable
fun BillBreakdownItemViewPreview(){
    BillBreakdownItemView()
}

@Composable
fun BillBreakdownItemView(){

    Column {
        BillItemView()

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.wrapContentWidth()
        ) {
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(smallSpacing),
            ) {
                //TODO replace with actual people list
                items(2){
                    AvatarWithDropdown{}
                }
            }

            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.ic_add),
                contentDescription = "Dinner Icon",
                tint = iconColor,
                modifier = Modifier
                    .size(45.dp)
                    .clickable(onClick = {
                        //TODO
                    })
            )
        }
    }

}

@Composable
fun AvatarWithDropdown(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {
    Row(
        modifier = modifier
            .border(0.7.dp, grey, RoundedCornerShape(extraLargeRadius))
            .clip(RoundedCornerShape(largeRadius))
            .clickable { onClick() }
            .padding(horizontal = 4.dp, vertical = 2.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Avatar circle with icon
        Box(
            modifier = Modifier
                .size(26.dp)
                .background(Color(0x6280b7f6), CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Default.Face, //TODO replace with icon
                contentDescription = "User Avatar",
                tint = iconColor,
                modifier = Modifier.size(20.dp)
            )
        }

        Spacer(modifier = Modifier.width(4.dp))

        // Dropdown Arrow
        Icon(
            imageVector = Icons.Default.KeyboardArrowDown,
            contentDescription = "Dropdown",
            tint = Color.Black
        )
    }
}