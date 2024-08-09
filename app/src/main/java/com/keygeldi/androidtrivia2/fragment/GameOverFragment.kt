package com.keygeldi.androidtrivia2.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.keygeldi.androidtrivia2.R
import com.keygeldi.androidtrivia2.databinding.FragmentGameOverBinding

class GameOverFragment : Fragment() {
    private var _binding: FragmentGameOverBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentGameOverBinding.inflate(inflater, container, false)

        val questionSet = arguments?.getString("question_set")
        val status = arguments?.getInt("status") ?: 0

        binding.againButton.setOnClickListener {
            val bundle = Bundle().apply {
                putInt("status", status)
                putString("question_set",questionSet)
            }
            findNavController().navigate(R.id.action_gameOverFragment_to_gameFragment, bundle)
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
