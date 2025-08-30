package com.quinn.quizardo.ui.screens.home

import android.content.Context
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.quinn.quizardo.data.model.Quiz
import org.json.JSONArray
import java.io.File
import kotlinx.serialization.json.Json

class HomeScreenViewModel: ViewModel() {
    private val _quizzes = mutableStateListOf<Quiz>()

    val quizzes: List<Quiz> = _quizzes

    fun refresh(context: Context) {
        _quizzes.clear()
        readFile(context)
    }

    private fun readFile(context: Context) {
        val filePath = File(context.filesDir,"quizzes.json") // File path

        // Check if the file exist
        val fileJson = if (filePath.exists()) {
            JSONArray(filePath.readText()) // Read the file as JSON array
        } else {JSONArray()} // Return a empty JSON array

        if (fileJson.length() > 1) {
            val fileList = mutableListOf<Quiz>() // holds the list of tasks found in file
            for (task in (fileJson.length()-1) downTo 1) {
                fileList.add(
                    Json.decodeFromString<Quiz>(fileJson.getString(task)) // Load the content
                )
            }

            _quizzes.addAll(fileList) // Load all the contents
        }
    }
}