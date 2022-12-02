package com.kugemi.marvelapp.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.kugemi.marvelapp.data.recources.*

@Composable
fun CustomButton(
    text: String,
    modifier: Modifier,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = customButtonPadding),
        shape = RoundedCornerShape(customButtonCorner),
        colors = ButtonDefaults.buttonColors(
            containerColor = customButtonColor
        )
    ) {
        Row(horizontalArrangement = Arrangement.Center) {
            Text(
                modifier = Modifier
                    .padding(vertical = customButtonTextPadding)
                    .align(Alignment.CenterVertically),
                text = text,
                fontSize = fontCustomButton,
                color = Color.White
            )
        }
    }
}