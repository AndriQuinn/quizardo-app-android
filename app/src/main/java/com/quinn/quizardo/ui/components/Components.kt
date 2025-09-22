package com.quinn.quizardo.ui.components

import androidx.compose.foundation.Image

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults.buttonColors
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.quinn.quizardo.R
import com.quinn.quizardo.ui.theme.MyTheme

@Composable
fun NavBar(
    modifier: Modifier = Modifier,
    leftBanner: @Composable () -> Unit = @Composable {},
    leftBannerToggle: Boolean = false,
    leftBannerFunction: () -> Unit = {},
    rightBannerToggle: Boolean = false,
    rightBanner: @Composable () -> Unit = @Composable {},
    rightBannerFunction: () -> Unit = {},
){
    Row (
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
            .fillMaxWidth()
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
            modifier = Modifier.size(50.dp)
        )
        Spacer(Modifier.width(3.dp))
        Text (
            text = "Quizardo",
            color = Color(0xFF8154EF),
            fontWeight = FontWeight.Bold,
            fontSize = 25.sp
        )
    }
}

@Composable
fun Header(
    leftColumn: List<@Composable () -> Unit> = emptyList<@Composable () -> Unit>(),
    rightColumn: List<@Composable () -> Unit> = emptyList<@Composable () -> Unit>(),
    modifier: Modifier = Modifier
) {
    Row (
        modifier = Modifier
            .fillMaxWidth()
    ) {
        // Left column
        Column (
            modifier = Modifier.weight(1f)
        ) {
            leftColumn.forEach { composable ->
                composable()
                Spacer(Modifier.height(5.dp))
            }

        }
        // Right column
        Column (
            horizontalAlignment = Alignment.End,
            modifier = Modifier.weight(1f)
        ) {
            rightColumn.forEach { composable ->
                composable()
                Spacer(Modifier.height(5.dp))
            }
        }
    }
}

@Composable
fun TextFieldLabeled(
    label: String,
    checkField: Boolean = false,
    inputValue: String,
    onValueChanged: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Text(
        text = label,
        color = Color(0xFF4B4453),
        style = MyTheme.header3
    )
    Spacer(Modifier.height(10.dp))
    TextField(
        value = inputValue,
        onValueChange = {onValueChanged(it)}, // Return the value to parent
        label = {Text(label)},
        singleLine = true,
        colors = TextFieldDefaults.colors(
            focusedContainerColor = Color.Transparent,
            unfocusedContainerColor = Color.Transparent,
            unfocusedTextColor = Color.White,
            focusedTextColor = Color.White
        ),
        isError = if (checkField) {
            inputValue.isBlank()
        } else {false},
        modifier = modifier
            .padding(horizontal = 20.dp)
            .fillMaxWidth()
    )
}
