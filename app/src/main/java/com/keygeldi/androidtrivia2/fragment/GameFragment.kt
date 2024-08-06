package com.keygeldi.androidtrivia2.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.keygeldi.androidtrivia2.R
import com.keygeldi.androidtrivia2.questions.Question
import com.keygeldi.androidtrivia2.questions.questions


class GameFragment : Fragment() {
    private lateinit var questionTextView: TextView
    private lateinit var radioGroup: RadioGroup
    private lateinit var option1: RadioButton
    private lateinit var option2: RadioButton
    private lateinit var option3: RadioButton
    private lateinit var option4: RadioButton
    private lateinit var currentQuestion: Question

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_game,container,false)

        questionTextView = view.findViewById(R.id.textView2)
        radioGroup = view.findViewById(R.id.colorOptions)
        option1 = view.findViewById(R.id.optionBlack)
        option2 = view.findViewById(R.id.optionGreen)
        option3 = view.findViewById(R.id.optionYellow)
        option4 = view.findViewById(R.id.optionRed)

        val submitBtn : Button = view.findViewById(R.id.submit_button)
        submitBtn.setOnClickListener{
            val selectedOption = radioGroup.checkedRadioButtonId
            val selectedIndex = when (selectedOption){
                R.id.optionBlack -> 0
                R.id.optionGreen -> 1
                R.id.optionYellow -> 2
                R.id.optionRed -> 3
                else -> -1
            }
            if (selectedIndex == currentQuestion.correctOptionIndex) {
                findNavController().navigate(R.id.action_gameFragment_to_gameWonFragment)
            } else {
                findNavController().navigate(R.id.action_gameFragment_to_gameOverFragment)
            }
        }

        loadNewQuestion()

        return view
    }

    private fun loadNewQuestion(){
        currentQuestion = questions.random()

        questionTextView.text=currentQuestion.text
        option1.text = currentQuestion.options[0]
        option2.text = currentQuestion.options[1]
        option3.text = currentQuestion.options[2]
        option4.text = currentQuestion.options[3]

        radioGroup.clearCheck()
    }
}
