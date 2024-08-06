package com.keygeldi.androidtrivia2.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.keygeldi.androidtrivia2.R


class TitleFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_title,container,false)
        val startBtn : Button= view.findViewById(R.id.start_button)

        startBtn.setOnClickListener{
            findNavController().navigate(R.id.action_titleFragment_to_gameFragment)

            //val fragment = GameFragment()
            //val transaction = fragmentManager?.beginTransaction()
            //transaction?.replace(R.id.nav_container,fragment)?.commit()
        }

        return view
    }
}

