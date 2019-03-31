package com.bracketgenerator


import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class BracketForm : Fragment() {
    private val data: MutableList<String> = mutableListOf(
        "",
        ""
    )
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: NameInputListAdapter
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(
            R.layout.fragment_bracket_form, container, false
        ).apply {
            setOnClickListener {
                clearFocus()
                val ims = activity!!.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
                ims.hideSoftInputFromWindow(it.windowToken, 0)
            }
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        generateRecyclerView()
        initAddPlayerButton()
    }

    private fun generateRecyclerView() {
        viewManager = LinearLayoutManager(this.context)
        viewAdapter = NameInputListAdapter(data)
        recyclerView = view!!.findViewById<RecyclerView>(R.id.bracket_form_names_input_list).apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter
        }
    }

    private fun initAddPlayerButton() {
        val addPlayerButton = view!!.findViewById<Button>(
            R.id.add_player_button
        )
        addPlayerButton.setOnClickListener {
            data.add("")
            viewAdapter.notifyDataSetChanged()
        }
    }
}

