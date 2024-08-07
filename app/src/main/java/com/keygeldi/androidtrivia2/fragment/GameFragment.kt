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
    private lateinit var shuffledQuestions: List<Question>
    var questionIndex:Int = 0
    var score = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentGameBinding.inflate(inflater, container, false)

        shuffledQuestions = questions.shuffled()
        loadNewQuestion()

        binding.skor.text = "Skor : $score"

        binding.submitButton.setOnClickListener {
            val selectedOption = binding.cevaplar.checkedRadioButtonId
            val selectedIndex = when (selectedOption) {
                R.id.option1 -> 0
                R.id.option2 -> 1
                R.id.option3 -> 2
                R.id.option4 -> 3
                else -> -1
            }
            if (selectedIndex == currentQuestion.correct_answer) {
                score++
                questionIndex++
                if (questionIndex < shuffledQuestions.size) {
                    loadNewQuestion()
                } else {
                    findNavController().navigate(R.id.action_gameFragment_to_gameWonFragment) // oyun bittiğinde
                }
            } else {

                score = 0
                questionIndex = 0
                findNavController().navigate(R.id.action_gameFragment_to_gameOverFragment, )
            }
            binding.skor.text = "Skor : $score"

        }

        return binding.root
    }

    private fun loadNewQuestion() {
        if (score == 0) {
            shuffledQuestions = questions.shuffled()
            questionIndex = 0
        }
            currentQuestion =shuffledQuestions[questionIndex]

            binding.textView2.text = currentQuestion.question_text
            binding.option1.text = currentQuestion.question_answer[0]
            binding.option2.text = currentQuestion.question_answer[1]
            binding.option3.text = currentQuestion.question_answer[2]
            binding.option4.text = currentQuestion.question_answer[3]

            binding.cevaplar.clearCheck()

    }
}
