package com.keygeldi.androidtrivia2.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.keygeldi.androidtrivia2.R
import com.keygeldi.androidtrivia2.databinding.FragmentGameOverBinding
import com.keygeldi.androidtrivia2.viewmodel.GameOverViewModel

class GameOverFragment : Fragment() {
    private var _binding: FragmentGameOverBinding? = null
    private val binding get() = _binding!!
    private val viewModel: GameOverViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentGameOverBinding.inflate(inflater, container, false)

        val questionSet = arguments?.getString("question_set")
        val status = arguments?.getInt("status") ?: 0

        viewModel.setStatus(status)
        viewModel.setQuestionSet(questionSet)

        binding.againButton.setOnClickListener {
            val bundle = Bundle().apply {
                putInt("status", viewModel.status.value ?: 0)
                putString("question_set", viewModel.questionSet.value)
            }
            findNavController().navigate(R.id.action_gameOverFragment_to_gameFragment, bundle)
        }

        binding.homeButton.setOnClickListener {
            findNavController().navigate((R.id.action_gameOverFragment_to_chooseFragment2))
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
