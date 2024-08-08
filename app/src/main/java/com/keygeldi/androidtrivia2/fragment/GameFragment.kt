package com.keygeldi.androidtrivia2.fragment

import android.graphics.Color
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
    var questionIndex: Int = 0
    var score = 0
    var selectedIndex: Int? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentGameBinding.inflate(inflater, container, false)

        shuffledQuestions = questions.shuffled()
        loadNewQuestion()

        binding.skor.text = "Skor : $score"

        binding.textBack.setOnClickListener{
            findNavController().navigate(R.id.action_gameFragment_to_titleFragment)
        }

        binding.option1.setOnClickListener {
            resetOptionColors()
            binding.option1.setBackgroundColor(Color.GRAY)
            onOptionSelected(0)
        }
        binding.option2.setOnClickListener {
            resetOptionColors()
            binding.option2.setBackgroundColor(Color.GRAY)
            onOptionSelected(1)
        }
        binding.option3.setOnClickListener {
            resetOptionColors()
            binding.option3.setBackgroundColor(Color.GRAY)
            onOptionSelected(2)
        }
        binding.option4.setOnClickListener {
            resetOptionColors()
            binding.option4.setBackgroundColor(Color.GRAY)
            onOptionSelected(3)
        }

        binding.submitButton.setOnClickListener {
            if (selectedIndex == currentQuestion.correct_answer) {
                score++
                questionIndex++
                displayCorrectAnswer()
                binding.submitButton.postDelayed({
                    if (questionIndex < shuffledQuestions.size) {
                        loadNewQuestion()
                    } else {
                        findNavController().navigate(R.id.action_gameFragment_to_gameWonFragment)
                    }
                }, 1000)
            } else {
                displayCorrectAnswer()
                binding.submitButton.postDelayed({
                    score = 0
                    questionIndex = 0
                    findNavController().navigate(R.id.action_gameFragment_to_gameOverFragment)
                }, 1000)
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
        currentQuestion = shuffledQuestions[questionIndex]

        binding.textView2.text = currentQuestion.question_text
        binding.option1.text = currentQuestion.question_answer[0]
        binding.option2.text = currentQuestion.question_answer[1]
        binding.option3.text = currentQuestion.question_answer[2]
        binding.option4.text = currentQuestion.question_answer[3]

        resetOptionColors()
        selectedIndex = null // Seçimi sıfırla
    }

    private fun onOptionSelected(index: Int) {
        selectedIndex = index
    }

    private fun resetOptionColors() {
        binding.option1.setBackgroundColor(Color.WHITE)
        binding.option1.setTextColor(Color.BLACK)
        binding.option2.setBackgroundColor(Color.WHITE)
        binding.option2.setTextColor(Color.BLACK)
        binding.option3.setBackgroundColor(Color.WHITE)
        binding.option3.setTextColor(Color.BLACK)
        binding.option4.setBackgroundColor(Color.WHITE)
        binding.option4.setTextColor(Color.BLACK)
    }
    private fun displayCorrectAnswer() {
        // Tüm seçenekleri sıfırla
        resetOptionColors()
        // Doğru cevabı yeşil yap
        when (currentQuestion.correct_answer) {
            0 -> binding.option1.setBackgroundColor(Color.GREEN)
            1 -> binding.option2.setBackgroundColor(Color.GREEN)
            2 -> binding.option3.setBackgroundColor(Color.GREEN)
            3 -> binding.option4.setBackgroundColor(Color.GREEN)
        }
        // Yanlış cevabı kırmızı yap
        selectedIndex?.let {
            if (it != currentQuestion.correct_answer) {
                when (it) {
                    0 -> binding.option1.setBackgroundColor(Color.RED)
                    1 -> binding.option2.setBackgroundColor(Color.RED)
                    2 -> binding.option3.setBackgroundColor(Color.RED)
                    3 -> binding.option4.setBackgroundColor(Color.RED)
                }
            }
        }
    }
}
