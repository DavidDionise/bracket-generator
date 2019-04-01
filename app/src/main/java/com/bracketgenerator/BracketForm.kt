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
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bracketgenerator.databinding.FragmentBracketFormBinding
import java.util.zip.Inflater

class BracketForm : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: NameInputListAdapter
    private lateinit var viewManager: RecyclerView.LayoutManager
    private lateinit var model: BracketViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        model = ViewModelProviders.of(activity!!).get(BracketViewModel::class.java)
        return inflater.inflate(
            R.layout.fragment_bracket_form,
            container,
            false
        ).apply {
            setOnClickListener { view ->
                view.clearFocus()
                val ims = activity!!.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
                ims.hideSoftInputFromWindow(windowToken, 0)
            }

            findViewById<EditText>(R.id.bracket_form_input_field).addTextChangedListener(object : TextWatcher {
                override fun afterTextChanged(s: Editable?) {}

                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    model.name = s.toString()
                }
            })

            findViewById<Button>(R.id.save_bracket_button)?.setOnClickListener {
                it.findNavController().navigate(
                    R.id.action_bracketForm_to_bracketView
                )
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
        viewAdapter = NameInputListAdapter(model)
        recyclerView = view!!.findViewById<RecyclerView>(R.id.bracket_form_names_input_list).apply {
            setHasFixedSize(false)
            layoutManager = viewManager
            adapter = viewAdapter
        }
    }

    private fun initAddPlayerButton() {
        val addPlayerButton = view!!.findViewById<Button>(
            R.id.add_player_button
        )
        addPlayerButton.setOnClickListener {
            model.users.add("")
            viewAdapter.notifyDataSetChanged()
        }
    }
}

