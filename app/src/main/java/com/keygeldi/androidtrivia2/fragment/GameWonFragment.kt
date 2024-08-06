package com.keygeldi.androidtrivia2.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

import androidx.navigation.fragment.findNavController
import com.keygeldi.androidtrivia2.R

class GameWonFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_game_won, container, false)
        val newBtn: Button = view.findViewById(R.id.new_button)

        newBtn.setOnClickListener {
        findNavController().navigate(R.id.action_gameWonFragment_to_gameFragment)
    }
        return view
    }

}