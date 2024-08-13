package com.keygeldi.androidtrivia2.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.keygeldi.androidtrivia2.questions.BaseQuestions

class GameViewModel : ViewModel() {

    private val _shuffledQuestions = MutableLiveData<List<BaseQuestions>>()
    val shuffledQuestions: LiveData<List<BaseQuestions>>
        get() = _shuffledQuestions

    private val _currentQuestion = MutableLiveData<BaseQuestions>()
    val currentQuestion: LiveData<BaseQuestions>
        get() = _currentQuestion

    private val _questionIndex = MutableLiveData<Int>()
    val questionIndex: LiveData<Int>
        get() = _questionIndex

    private val _score = MutableLiveData<Int>()
    val score: LiveData<Int>
        get() = _score

    private val _selectedIndex = MutableLiveData<Int?>()
    val selectedIndex: LiveData<Int?>
        get() = _selectedIndex

    init {
        _score.value = 0
        _questionIndex.value = 0
        _selectedIndex.value = null
    }

    fun setShuffledQuestions(questions: List<BaseQuestions>) {
        _shuffledQuestions.value = questions
    }

    fun setCurrentQuestion(question: BaseQuestions) {
        _currentQuestion.value = question
    }

    fun setQuestionIndex(index: Int) {
        _questionIndex.value = index
    }

    fun setScore(score: Int) {
        _score.value = score
    }

    fun setSelectedIndex(index: Int?) {
        _selectedIndex.value = index
    }

    fun incrementScore() {
        _score.value = _score.value?.plus(1)
    }

    fun incrementQuestionIndex() {
        _questionIndex.value = _questionIndex.value?.plus(1)
    }
}
