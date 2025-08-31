package com.quinn.quizardo.ui.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import com.quinn.quizardo.R
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults.buttonColors
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.quinn.quizardo.data.model.Quiz
import com.quinn.quizardo.ui.components.Header
import com.quinn.quizardo.ui.components.Logo
import com.quinn.quizardo.ui.components.NavBar
import com.quinn.quizardo.ui.theme.QuizardoTheme


@Composable
fun HomeScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
    homeViewModel: HomeScreenViewModel = HomeScreenViewModel()
) {

    val listOfQuizzes = mutableListOf<Quiz>()     

    Scaffold(
        modifier = Modifier
            .statusBarsPadding()
            .fillMaxSize(),
        topBar = {
            NavBar(
                leftBanner = { Logo() },
                leftBannerToggle = false,
                rightBanner = {
                    Text(
                        text = "Create",
                        color = Color(0xFF8154EF),
                        fontWeight = FontWeight.Bold
                    )
                },
                rightBannerToggle = true,
                rightBannerFunction = { navController.navigate("createQuiz") }
            )
        }
    ) { innerPadding ->
        HomeScreenBody(
            quizzes = listOfQuizzes,
            modifier = Modifier.padding(innerPadding)
        )
    }
}

@Composable
fun HomeScreenBody(
    quizzes: List<Quiz>,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .padding(15.dp)
            .fillMaxSize(),
        horizontalAlignment =Alignment.CenterHorizontally
    ) {
        if (quizzes.isEmpty()) {
            CreateBanner()
        } else {
            Column (
                modifier = modifier.fillMaxSize()
            ) {
                // Header
                Header(
                    leftColumn = listOf<@Composable () -> Unit>(
                        { Text(
                            text = "Quizzes",
                            color = Color(0xFF8154EF),
                            fontWeight = FontWeight.Bold,
                            fontSize = 32.sp
                        ) },
                    ),
                    rightColumn = listOf<@Composable () -> Unit>(
                        { Text(
                            text = "${quizzes.size}",
                            color = Color(0xFF8154EF),
                            fontWeight = FontWeight.SemiBold,
                        ) },
                    )
                )

                Spacer(Modifier.height(10.dp))
                // Body
                quizzes.forEach { quiz ->
                    QuizTab(
                        quiz = quiz
                    )
                    Spacer(Modifier.height(5.dp))
                }
            }
        }
    }
}

@Composable
fun CreateBanner(modifier: Modifier = Modifier) {
    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxSize()
    ) {
        Image (
            painter = painterResource(R.drawable.witch),
            contentDescription = "wizard hat",
            modifier = Modifier.size(150.dp)
        )
        Spacer(Modifier.height(10.dp))
        Text (
            text = "Create your own quiz now!",
            style = TextStyle(
                color = Color(0xFF8154EF),
                fontWeight = FontWeight.ExtraBold,
                fontSize = 40.sp,
                textAlign = TextAlign.Center,
            ),
            modifier = modifier
                .padding(horizontal = 15.dp)
                .fillMaxWidth()
        )
        Spacer(Modifier.height(10.dp))
        Button (
            onClick = {},
            colors = buttonColors(
                contentColor = Color(0xFF8154EF),
                containerColor = Color(0xFF8154EF)
            )
        ) {
            Text (
                text = "Create",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
        }
    }
}

@Composable
fun QuizTab(
    quiz: Quiz,
    modifier: Modifier = Modifier
) {
    Surface(
        shape = RoundedCornerShape(8.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .background(Color(0xFF8154EF))
                .clip(RoundedCornerShape(16.dp))
                .padding(20.dp)
                .fillMaxWidth()

        ) {
            Header(
                leftColumn = listOf<@Composable () -> Unit>(
                    {
                        Text(
                            text = quiz.title,
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            fontSize = 25.sp
                        )
                    },
                    {
                        Text(
                            text = quiz.subject,
                            color = Color.White,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 14.sp
                        )
                    },
                ),
                rightColumn = listOf<@Composable () -> Unit>(
                    {
                        Text(
                            text = "25",
                            color = Color.White,
                            fontWeight = FontWeight.SemiBold,
                        )
                    },
                )
            )
        }
    }
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

