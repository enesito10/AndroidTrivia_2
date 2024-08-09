package com.keygeldi.androidtrivia2.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.keygeldi.androidtrivia2.R
import com.keygeldi.androidtrivia2.databinding.FragmentChooseBinding


class ChooseFragment : Fragment() {

private lateinit var binding: FragmentChooseBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentChooseBinding.inflate(inflater, container, false)

        binding.linearLayout3.setOnClickListener{
            val bundle = Bundle()
            bundle.putString("question_set","city_questions")
            findNavController().navigate(R.id.action_chooseFragment2_to_gameFragment,bundle) //City
        }
        binding.linearLayout1.setOnClickListener{
            val bundle = Bundle()
            bundle.putString("question_set","flag_questions")
            findNavController().navigate(R.id.action_chooseFragment2_to_gameFragment,bundle) //Flag
        }

        binding.linearLayout2.setOnClickListener{
            val bundle = Bundle()
            bundle.putString("question_set","3_questions")
            findNavController().navigate(R.id.action_chooseFragment2_to_gameFragment,bundle) //3
        }

        binding.linearLayout4.setOnClickListener{
            val bundle = Bundle()
            bundle.putString("question_set","4_questions")
            findNavController().navigate(R.id.action_chooseFragment2_to_gameFragment,bundle) //4
        }

        binding.linearLayout5.setOnClickListener{
            val bundle = Bundle()
            bundle.putString("question_set","5_questions")
            findNavController().navigate(R.id.action_chooseFragment2_to_gameFragment,bundle) //5
        }

        binding.linearLayout6.setOnClickListener{
            val bundle = Bundle()
            bundle.putString("question_set","6_questions")
            findNavController().navigate(R.id.action_chooseFragment2_to_gameFragment,bundle) //6
        }

        return binding.root
    }

}