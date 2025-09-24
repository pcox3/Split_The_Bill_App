package com.uiapp.ui.custom

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.SolidColor
import com.uiapp.theme.colorWhite
import com.uiapp.theme.extraLargeRadius
import com.uiapp.theme.primaryColor
import com.uiapp.theme.smallSpacing


@Composable
fun ButtonsSection(
    primaryButtonText: String = "Continue",
    secondaryButtonText: String = "Cancel",
    shouldShowSecondaryButton: Boolean = true,
    secondaryButtonColor: ButtonColors = ButtonDefaults
        .outlinedButtonColors().copy(contentColor = primaryColor),
    primaryButtonAction: () -> Unit = {},
    secondaryButtonAction: () -> Unit = {}
){
    Surface(
        color = colorWhite
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(smallSpacing)
        ) {

            if (shouldShowSecondaryButton){
                OutlinedButton(
                    colors = secondaryButtonColor,
                    border = ButtonDefaults.outlinedButtonBorder().copy(
                        brush = SolidColor(secondaryButtonColor.contentColor)
                    ),
                    modifier = Modifier.weight(1f),
                    onClick = {
                        secondaryButtonAction()
                    }) {
                    Text(secondaryButtonText)
                }

                Spacer(Modifier.padding(smallSpacing))
            }

            Button(
                interactionSource = remember { MutableInteractionSource()},
                modifier = Modifier.weight(1f),
                onClick = {
                    primaryButtonAction()
                },
                shape = RoundedCornerShape(extraLargeRadius)
            ) {
                Text(primaryButtonText)
            }
        }
    }
}