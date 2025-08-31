package com.quinn.quizardo

import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.quinn.quizardo.ui.screens.CreateQuizScreen
import com.quinn.quizardo.ui.screens.home.HomeScreen
import com.quinn.quizardo.ui.theme.QuizardoTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            QuizardoApp()
        }
    }
}

@Composable
fun QuizardoApp(modifier: Modifier = Modifier) {
    val navController: NavHostController = rememberNavController()

    // Navigation address and options
    NavHost(
        navController = navController,
        startDestination = "home",
        enterTransition = { slideInHorizontally(
            initialOffsetX = { -it },
            animationSpec = tween(250)
        )  },
        popEnterTransition = { slideInHorizontally(
            initialOffsetX = { -it },
            animationSpec = tween(250)
        ) },
        exitTransition = {
            slideOutHorizontally(
                targetOffsetX = {-it},
                animationSpec = tween(250)
            )
        },
        popExitTransition = {
            slideOutHorizontally(
                targetOffsetX = {-it},
                animationSpec = tween(250)
            )
        },
        modifier = Modifier.background(Color(0xFF1E1E1E))
    ) {
        composable("home") { HomeScreen(navController = navController) }
        composable("createQuiz") { CreateQuizScreen(navController = navController) }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    QuizardoTheme {
        QuizardoApp()
    }
}