package com.quinn.quizardo.ui.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults.buttonColors
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.quinn.quizardo.ui.components.Logo
import com.quinn.quizardo.ui.components.NavBar
import com.quinn.quizardo.ui.theme.QuizardoTheme

@Composable
fun HomeScreen(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier = Modifier
            .statusBarsPadding()
            .fillMaxSize(),
        topBar = {
            NavBar(
                modifier = Modifier.background(Color(0xFF8154EF)),
                leftBanner = { Logo() },
                leftBannerToggle = false,
                rightBanner = {
                    Text(
                        text = "Create",
                        color = Color.White
                    )
                },
                rightBannerToggle = true
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .background(Color.Yellow)
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            Text("")
        }

    }
}

@Composable
fun HomeScreenBody(
    homeViewModel: HomeScreenViewModel = HomeScreenViewModel(),
    modifier: Modifier = Modifier
) {

}


@Preview (
    name = "Home Screen",
    showBackground = true,
    showSystemUi = true
)
@Composable
fun HomeScreenPreview() {
    QuizardoTheme {
        HomeScreen(
            navController = rememberNavController()
        )
    }
}
