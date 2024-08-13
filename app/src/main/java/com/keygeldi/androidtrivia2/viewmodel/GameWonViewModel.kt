package com.keygeldi.androidtrivia2.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GameWonViewModel:ViewModel() {
    private val _status = MutableLiveData<Int>()
    val status: LiveData<Int>
        get() = _status

    private val _questionSet = MutableLiveData<String?>()
    val questionSet: LiveData<String?>
        get() = _questionSet

    fun setStatus(newStatus: Int){
        _status.value = newStatus
    }

    fun setQuestionSet(newQuestionSet: String?) {
        _questionSet.value = newQuestionSet
    }

}