package com.keygeldi.androidtrivia2.questions

data class Question(
    val text: String,
    val options: List<String>,
    val correctOptionIndex: Int
)

val questions = listOf(
    Question("What color is the Android mascot's background?", listOf("Black", "Green", "Yellow", "Red"), 0),
    Question("What is the capital of France?", listOf("Berlin", "Madrid", "Paris", "Rome"), 2),
    Question("What color is the Android mascot's ?", listOf("Black", "White", "Yellow", "Red"), 1),

    // Diğer sorular burada
)
