package com.keygeldi.androidtrivia2.viewmodel

import android.graphics.Color
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.keygeldi.androidtrivia2.databinding.FragmentChooseBinding

class ChooseViewModel:ViewModel() {

    private val _complatedQuestionSet = MutableLiveData<String?>()
    val completedQuestionSet: LiveData<String?>
        get() = _complatedQuestionSet

    fun setCompletedQuestionSet(setName: String?) {
        _complatedQuestionSet.value = setName
    }

}