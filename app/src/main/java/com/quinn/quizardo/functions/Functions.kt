package com.quinn.quizardo.functions

import android.content.Context
import com.quinn.quizardo.data.model.Quiz
import org.json.JSONArray
import org.json.JSONObject
import java.io.File

fun addQuizFile(context: Context, title: String, subject: String) {

    val filePath = File(context.filesDir,"quiz-list.json") // Get the file path

    // Checks if the file exist in the path, if not create one
    if (!filePath.exists()) {
        val file = JSONArray()
        val lengthObj = JSONObject().put("length","0") // Create a json object length for id's
        file.put(lengthObj)
        filePath.writeText(file.toString())
    }
    val fileContent = JSONArray(filePath.readText()) // place the file content in the variable
    var length = fileContent.getJSONObject(0).getInt("length") // Get the value of length
    length++ // Iterate length
    val quizObject = JSONObject() // Create json object to hold the task data e.g. title
    quizObject.put("title", title)
    quizObject.put("subject", subject)
    quizObject.put("id", "$length") // Assign the id as the current length

    fileContent.put(quizObject) // put the task object to the json array
    fileContent.getJSONObject(0).put("length","$length") // Update the length on the file
    filePath.writeText(fileContent.toString()) // rewrite the file with the updated one
}

fun getTotal(list: List<Quiz>): Int {
    var total = 0
    for (tasks in list) {
        total++
    }
    return total
}