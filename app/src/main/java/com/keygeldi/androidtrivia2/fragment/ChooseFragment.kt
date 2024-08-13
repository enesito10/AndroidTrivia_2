package com.keygeldi.androidtrivia2.fragment

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.keygeldi.androidtrivia2.R
import com.keygeldi.androidtrivia2.databinding.FragmentChooseBinding
import com.keygeldi.androidtrivia2.viewmodel.ChooseViewModel

class ChooseFragment : Fragment() {

    private lateinit var binding: FragmentChooseBinding
    private lateinit var viewModel: ChooseViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentChooseBinding.inflate(inflater, container, false)

        viewModel = ViewModelProvider(this).get(ChooseViewModel::class.java)

        val completedQuestionSet = arguments?.getString("completed_question_set")
        viewModel.setCompletedQuestionSet(completedQuestionSet)
        highlightCompletedSet()

        binding.linearLayout3.setOnClickListener{
            val bundle = Bundle()
            bundle.putString("question_set", "city_questions")
            findNavController().navigate(R.id.action_chooseFragment2_to_gameFragment, bundle) //City
        }
        binding.linearLayout1.setOnClickListener{
            val bundle = Bundle()
            bundle.putString("question_set", "flag_questions")
            findNavController().navigate(R.id.action_chooseFragment2_to_gameFragment, bundle) //Flag
        }
        binding.linearLayout2.setOnClickListener{
            val bundle = Bundle()
            bundle.putString("question_set", "3_questions")
            findNavController().navigate(R.id.action_chooseFragment2_to_gameFragment, bundle) //3
        }
        binding.linearLayout4.setOnClickListener{
            val bundle = Bundle()
            bundle.putString("question_set", "4_questions")
            findNavController().navigate(R.id.action_chooseFragment2_to_gameFragment, bundle) //4
        }
        binding.linearLayout5.setOnClickListener{
            val bundle = Bundle()
            bundle.putString("question_set", "5_questions")
            findNavController().navigate(R.id.action_chooseFragment2_to_gameFragment, bundle) //5
        }
        binding.linearLayout6.setOnClickListener{
            val bundle = Bundle()
            bundle.putString("question_set", "6_questions")
            findNavController().navigate(R.id.action_chooseFragment2_to_gameFragment, bundle) //6
        }

        return binding.root
    }

    private fun highlightCompletedSet() {
        viewModel.completedQuestionSet.observe(viewLifecycleOwner) { completedQuestionSet ->
            when (completedQuestionSet) {
                "city_questions" -> binding.linearLayout3.setBackgroundColor(Color.GREEN)
                "flag_questions" -> binding.linearLayout1.setBackgroundColor(Color.GREEN)
                "3_questions" -> binding.linearLayout2.setBackgroundColor(Color.GREEN)
                "4_questions" -> binding.linearLayout4.setBackgroundColor(Color.GREEN)
                "5_questions" -> binding.linearLayout5.setBackgroundColor(Color.GREEN)
                "6_questions" -> binding.linearLayout6.setBackgroundColor(Color.GREEN)
            }
        }
    }
}
