package com.quinn.quizardo.data.model

import kotlinx.serialization.Serializable

@Serializable
data class QuizQuestion (
    val question: String,
    val answer: String,
    val questionType: String
)