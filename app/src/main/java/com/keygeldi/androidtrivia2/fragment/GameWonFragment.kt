package com.keygeldi.androidtrivia2.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

import androidx.navigation.fragment.findNavController
import com.keygeldi.androidtrivia2.R
import com.keygeldi.androidtrivia2.databinding.FragmentGameBinding
import com.keygeldi.androidtrivia2.databinding.FragmentGameWonBinding

class GameWonFragment : Fragment() {
    private lateinit var binding: FragmentGameWonBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentGameWonBinding.inflate(inflater, container, false)


        binding.newButton.setOnClickListener {
        findNavController().navigate(R.id.action_gameWonFragment_to_gameFragment)
    }
        return binding.root
    }

}