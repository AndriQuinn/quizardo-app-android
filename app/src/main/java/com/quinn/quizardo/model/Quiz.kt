package com.quinn.quizardo.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Quiz(
    val title: String,
    val subject: String,
    val id: String
) {
    val listOfQuestions = mutableListOf<QuizQuestion>()
    val score: Int = 0

    fun addQuestion(question: QuizQuestion) {
        listOfQuestions.add(question)
    }

    fun removeQuestion(question: QuizQuestion) {
        listOfQuestions.remove(question)
    }
}