package com.keygeldi.androidtrivia2.questions

class Question(
    val question_text: String,
    val question_answer: List<String>,
    val correct_answer: Int,
    var user_answer: Int? = null

) val questions = listOf(
    BaseQuestions("What is the capital of France?", listOf("Berlin", "Madrid", "Paris", "Rome"), 2),
    BaseQuestions("What is the capital of Turkey?", listOf("Berlin", "Madrid", "Paris", "Ankara"), 3),
    BaseQuestions("What is the capital of Germany?", listOf("Berlin", "Madrid", "Paris", "Rome"), 0),
    BaseQuestions("What is the capital of Spain?", listOf("Berlin", "Madrid", "Paris", "Rome"), 1),
    BaseQuestions("What is the capital of Italy?", listOf("Berlin", "Madrid", "Paris", "Rome"), 3),
    BaseQuestions("What is the capital of Russia?", listOf("Berlin", "Moscow", "Paris", "Rome"), 1),
    BaseQuestions("What is the capital of USA?", listOf("Washington", "Moscow", "Paris", "Rome"), 0),
    BaseQuestions("What is the capital of England?", listOf("Berlin", "London", "Paris", "Rome"), 1),
    BaseQuestions("What is the capital of Japan?", listOf("Berlin", "Tokyo", "Paris", "Rome"), 1),
    BaseQuestions("What is the capital of China?", listOf("Berlin", "Beijing", "Paris", "Rome"), 1),
    BaseQuestions("What is the capital of India?", listOf("Berlin", "New Delhi", "Paris", "Rome"), 1)
)