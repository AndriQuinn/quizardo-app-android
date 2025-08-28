package com.quinn.quizardo.ui.components

import androidx.compose.foundation.Image

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults.buttonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.quinn.quizardo.R

@Composable
fun NavBar(
    modifier: Modifier = Modifier,
    leftBanner: @Composable () -> Unit,
    leftBannerToggle: Boolean,
    leftBannerFunction: () -> Unit = {},
    rightBannerToggle: Boolean,
    rightBanner: @Composable () -> Unit,
    rightBannerFunction: () -> Unit = {},
){
    Row (
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier.fillMaxWidth()
            .height(56.dp)

    ) {
        Button(
            enabled = leftBannerToggle,
            onClick = {leftBannerFunction},
            colors = buttonColors(
                disabledContainerColor = Transparent,
                disabledContentColor = Transparent,
                contentColor = Transparent,
                containerColor = Transparent
            )
        ) {
            leftBanner()
        }
        Button(
            enabled = rightBannerToggle,
            onClick = {rightBannerFunction},
            colors = buttonColors(
                disabledContainerColor = Transparent,
                disabledContentColor = Transparent,
                contentColor = Transparent,
                containerColor = Transparent
            )
        ) {
            rightBanner()
        }
    }
}

@Composable
fun Logo(modifier: Modifier = Modifier) {
    Row (
        verticalAlignment =Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Image (
            painter = painterResource(R.drawable.witch),
            contentDescription = "wizard hat",
            modifier = Modifier.size(40.dp)
        )
        Spacer(Modifier.width(5.dp))
        Text (
            text = "Quizardo",
            color = Color.White
        )
    }
}
