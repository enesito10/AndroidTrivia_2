package com.keygeldi.androidtrivia2.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.keygeldi.androidtrivia2.R
import com.keygeldi.androidtrivia2.databinding.FragmentGameBinding
import com.keygeldi.androidtrivia2.questions.Question
import com.keygeldi.androidtrivia2.questions.questions

class GameFragment : Fragment() {
    private lateinit var binding: FragmentGameBinding
    private lateinit var currentQuestion: Question
    private var status: Int = 1  // 1 for random question, 0 for fixed question

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentGameBinding.inflate(inflater, container, false)

        status = arguments?.getInt("status") ?: 1

        binding.submitButton.setOnClickListener {
            val selectedOption = binding.colorOptions.checkedRadioButtonId
            val selectedIndex = when (selectedOption) {
                R.id.optionBlack -> 0
                R.id.optionGreen -> 1
                R.id.optionYellow -> 2
                R.id.optionRed -> 3
                else -> -1
            }

            if (selectedIndex == currentQuestion.correctOptionIndex) {
                val bundle = Bundle().apply {
                    putInt("status", 1)
                }
                findNavController().navigate(R.id.action_gameFragment_to_gameWonFragment, bundle)
            } else {
                val bundle = Bundle().apply {
                    putInt("status", 0)
                }
                findNavController().navigate(R.id.action_gameFragment_to_gameOverFragment, bundle)
            }
        }

        loadNewQuestion()

        return binding.root
    }

    private fun loadNewQuestion() {
        if (status == 1) {
            currentQuestion = questions.random()
        } else
            currentQuestion = questions.last()


        binding.textView2.text = currentQuestion.text
        binding.optionBlack.text = currentQuestion.options[0]
        binding.optionGreen.text = currentQuestion.options[1]
        binding.optionYellow.text = currentQuestion.options[2]
        binding.optionRed.text = currentQuestion.options[3]

        binding.colorOptions.clearCheck()
    }
}
