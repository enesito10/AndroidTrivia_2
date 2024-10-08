package com.keygeldi.androidtrivia2.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.keygeldi.androidtrivia2.R
import com.keygeldi.androidtrivia2.databinding.FragmentGameWonBinding
import com.keygeldi.androidtrivia2.viewmodel.GameWonViewModel

class GameWonFragment : Fragment() {
    private var _binding: FragmentGameWonBinding? = null
    private val binding get() = _binding!!
    private val viewModel: GameWonViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentGameWonBinding.inflate(inflater, container, false)

        val questionSet = arguments?.getString("question_set")
        val status = arguments?.getInt("status") ?: 1

        viewModel.setStatus(status)
        viewModel.setQuestionSet(questionSet)

        binding.newButton.setOnClickListener {
            val bundle = Bundle().apply {
                putString("completed_question_set", viewModel.questionSet.value)
                putInt("status",viewModel.status.value ?: 0)
            }
            findNavController().navigate(R.id.action_gameWonFragment_to_chooseFragment2, bundle)
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
