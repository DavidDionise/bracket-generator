package com.bracketgenerator

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.bracketgenerator.databinding.FragmentHomePageBinding


class HomePage : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentHomePageBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_home_page, container, false
        )

        binding.newBracketButton.setOnClickListener {
            it.findNavController().navigate(
                R.id.action_homePage_to_bracketForm
            )
        }

        return binding.root
    }
}
