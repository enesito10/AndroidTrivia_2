package com.keygeldi.androidtrivia2.questions

class FlagQuestion(
    val question_text: String,
    val question_answer: List<String>,
    val correct_answer: Int,
    var user_answer: Int? = null
)

val flagquestions = listOf(
    BaseQuestions("Ay yıldız kimin bayrağı", listOf("Amerika", "Türkiye", "Brezilya", "Polonya"), 1),
    BaseQuestions("blabla kimin bayrağı", listOf("Amerika", "Türkiye", "Brezilya", "Polonya"), 2),

    )
