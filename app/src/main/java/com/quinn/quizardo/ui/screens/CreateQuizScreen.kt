package com.quinn.quizardo.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults.buttonColors
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.quinn.quizardo.functions.addQuizFile
import com.quinn.quizardo.ui.components.Header
import com.quinn.quizardo.ui.components.Logo
import com.quinn.quizardo.ui.components.NavBar
import com.quinn.quizardo.ui.components.TextFieldLabeled
import com.quinn.quizardo.R

@Composable
fun CreateQuizScreen(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    var checkFields by remember {mutableStateOf(false)}
    var title by remember { mutableStateOf("") }
    var subject by remember { mutableStateOf("") }

    Scaffold(
        modifier = Modifier
            .statusBarsPadding()
            .fillMaxSize(),
        topBar = {
            NavBar(
                leftBanner = {
                    Image (
                        painter = painterResource(R.drawable.back_icon),
                        contentDescription = "back icon",
                        modifier = Modifier.size(16.dp)
                    )
                },
                leftBannerToggle = true,
                leftBannerFunction = { navController.popBackStack() }
            )
        }
    ) { innerPadding ->
        CreateQuizBody(
            checkField = checkFields,
            title = title,
            subject = subject,
            setTitleFunction = { input ->
                title = input
            },
            setSubjectFunction = { input ->
                subject = input
            },
            createQuiz = {
                checkFields = true
                if (title.isNotBlank() && subject.isNotBlank()) {
                    addQuizFile(
                        context = context,
                        title = title,
                        subject = subject
                    )
                }
            },
            modifier = Modifier.padding(innerPadding))
    }
}

@Composable
fun CreateQuizBody(
    checkField: Boolean,
    title: String,
    subject: String,
    setTitleFunction: (String) -> Unit,
    setSubjectFunction: (String) -> Unit,
    createQuiz: () -> Unit,
    modifier: Modifier = Modifier

) {
    Column(
        modifier = modifier
            .padding(vertical = 20.dp, horizontal = 15.dp)
            .fillMaxSize()
    ) {
        Header(
            leftColumn = listOf(
                { Text(
                    text = "New Quiz",
                    color = Color(0xFF8154EF),
                    fontWeight = FontWeight.Bold,
                    fontSize = 32.sp
                ) }
            )
        )
        Spacer(Modifier.height(40.dp))
        TextFieldLabeled(
            label = "Title",
            onValueChanged = { setTitleFunction(it) },
            checkField = checkField,
            inputValue = title
        )
        Spacer(Modifier.height(30.dp))
        TextFieldLabeled(
            label = "Subject",
            onValueChanged = { setSubjectFunction(it) },
            checkField = checkField,
            inputValue = subject
        )
        Spacer(Modifier.height(20.dp))
        Row (
            horizontalArrangement = Arrangement.End,
            modifier = modifier.fillMaxWidth()
        ) {
            Button (
                onClick = { createQuiz() },
                colors = buttonColors(
                    contentColor = Color(0xFF8154EF),
                    containerColor = Color(0xFF8154EF)
                )
            ) {
                Text (
                    text = "Create",
                    color = Color.White,
                    fontSize = 20.sp
                )
            }
        }
    }
}


@Preview(
    showBackground = true,
    showSystemUi = true,
    name = "Create quiz screen"
)
@Composable
fun CreateQuizScreenPreview() {
    CreateQuizScreen(navController = rememberNavController())
}