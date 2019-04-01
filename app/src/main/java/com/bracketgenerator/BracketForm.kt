package com.bracketgenerator


import android.app.Activity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bracketgenerator.databinding.FragmentBracketFormBinding

class BracketForm : Fragment() {
    private val data: MutableList<String> = mutableListOf(
        "",
        ""
    )
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: NameInputListAdapter
    private lateinit var viewManager: RecyclerView.LayoutManager
    private lateinit var binding: FragmentBracketFormBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate<FragmentBracketFormBinding>(
            inflater,
            R.layout.fragment_bracket_form,
            container,
            false
        ).also {
            it.bracket = BracketData()
            it.root.run {
                setOnClickListener { view ->
                    view.clearFocus()
                    val ims = activity!!.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
                    ims.hideSoftInputFromWindow(windowToken, 0)
                }

                findViewById<EditText>(R.id.bracket_form_input_field).addTextChangedListener(object : TextWatcher {
                    override fun afterTextChanged(s: Editable?) {}

                    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

                    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                        binding.bracket!!.bracketName.set(s.toString())
                    }
                })
            }
        }
        return binding.root
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

