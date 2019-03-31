package com.bracketgenerator

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController


class HomePage : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(
            R.layout.fragment_home_page, container, false
        )
        val newBracketButton = view.findViewById<Button>(R.id.new_bracket_button)
        newBracketButton?.setOnClickListener {
            it.findNavController().navigate(
                R.id.action_homePage_to_bracketForm
            )
        }
        return view
    }
}
