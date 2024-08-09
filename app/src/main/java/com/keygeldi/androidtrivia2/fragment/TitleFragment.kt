package com.keygeldi.androidtrivia2.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.keygeldi.androidtrivia2.R
import com.keygeldi.androidtrivia2.databinding.FragmentTitleBinding


class TitleFragment : Fragment() {
    private lateinit var binding: FragmentTitleBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentTitleBinding.inflate(inflater,container,false)


        binding.startButton.setOnClickListener{
            findNavController().navigate(R.id.action_titleFragment_to_chooseFragment2)

            //val fragment = GameFragment()
            //val transaction = fragmentManager?.beginTransaction()
            //transaction?.replace(R.id.nav_container,fragment)?.commit()
        }

        return binding.root
    }
}

