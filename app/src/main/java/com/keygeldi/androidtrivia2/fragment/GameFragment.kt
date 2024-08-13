package com.keygeldi.androidtrivia2.fragment

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.keygeldi.androidtrivia2.R
import com.keygeldi.androidtrivia2.databinding.FragmentGameBinding
import com.keygeldi.androidtrivia2.questions.BaseQuestions
import com.keygeldi.androidtrivia2.questions.flagquestions
import com.keygeldi.androidtrivia2.questions.questions
import com.keygeldi.androidtrivia2.viewmodel.GameViewModel

class GameFragment : Fragment() {

    private lateinit var binding: FragmentGameBinding
    private lateinit var viewModel: GameViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentGameBinding.inflate(inflater, container, false)

        viewModel = ViewModelProvider(this).get(GameViewModel::class.java)

        val questionSet = arguments?.getString("question_set")

        val questionsList = when (questionSet) {
            "city_questions" -> questions.shuffled()
            "flag_questions" -> flagquestions.shuffled()
            else -> questions.shuffled() // Default
        }

        viewModel.setShuffledQuestions(questionsList)
        loadNewQuestion()

        viewModel.score.observe(viewLifecycleOwner) { score ->
            binding.skor.text = "Skor : $score"
        }

        binding.textBack.setOnClickListener{
            findNavController().navigate(R.id.action_gameFragment_to_chooseFragment2)
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
            if (viewModel.selectedIndex.value == viewModel.currentQuestion.value?.correct_answer) {
                viewModel.incrementScore()
                viewModel.incrementQuestionIndex()
                displayCorrectAnswer()
                binding.submitButton.postDelayed({
                    if (viewModel.questionIndex.value!! < viewModel.shuffledQuestions.value!!.size) {
                        loadNewQuestion()
                    } else {
                        findNavController().navigate(R.id.action_gameFragment_to_gameWonFragment, Bundle().apply {
                            putString("question_set", questionSet)
                        })
                    }
                }, 1000)
            } else {
                displayCorrectAnswer()
                binding.submitButton.postDelayed({
                    viewModel.setScore(0)
                    viewModel.setQuestionIndex(0)
                    findNavController().navigate(R.id.action_gameFragment_to_gameOverFragment, Bundle().apply {
                        putString("question_set", questionSet)
                    })
                }, 1000)
            }
        }

        return binding.root
    }

    private fun loadNewQuestion() {
        if (viewModel.score.value == 0) {
            viewModel.setShuffledQuestions(viewModel.shuffledQuestions.value!!.shuffled())
            viewModel.setQuestionIndex(0)
        }
        val currentQuestion = viewModel.shuffledQuestions.value!![viewModel.questionIndex.value!!]
        viewModel.setCurrentQuestion(currentQuestion)

        binding.textView2.text = currentQuestion.question_text
        binding.option1.text = currentQuestion.question_answer[0]
        binding.option2.text = currentQuestion.question_answer[1]
        binding.option3.text = currentQuestion.question_answer[2]
        binding.option4.text = currentQuestion.question_answer[3]

        resetOptionColors()
        viewModel.setSelectedIndex(null) // Reset selection
    }

    private fun onOptionSelected(index: Int) {
        viewModel.setSelectedIndex(index)
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
        resetOptionColors()
        when (viewModel.currentQuestion.value?.correct_answer) {
            0 -> binding.option1.setBackgroundColor(Color.GREEN)
            1 -> binding.option2.setBackgroundColor(Color.GREEN)
            2 -> binding.option3.setBackgroundColor(Color.GREEN)
            3 -> binding.option4.setBackgroundColor(Color.GREEN)
        }
        viewModel.selectedIndex.value?.let {
            if (it != viewModel.currentQuestion.value?.correct_answer) {
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
