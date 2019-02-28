package com.bracketgenerator


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bracketgenerator.databinding.FragmentBracketFormBinding


class BracketForm : Fragment() {
    private val data: Array<String> = arrayOf(
        "David",
        "Lydia"
    )
    lateinit var binding: FragmentBracketFormBinding
    lateinit var recyclerView: RecyclerView
    lateinit var inflater: LayoutInflater

    override fun onCreateView(
        _inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        inflater = _inflater
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_bracket_form, container, false
        )
        generateRecyclerView()
        return binding.root
    }

    private fun generateRecyclerView() {
        val viewManager = LinearLayoutManager(this.context)
        val viewAdapter = NameInputListAdapter(data, inflater)
        recyclerView = binding.root.findViewById<RecyclerView>(R.id.bracket_form_names_input_list).apply {
//            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter
        }
    }
}

