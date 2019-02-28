package com.bracketgenerator

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.EditText
import androidx.recyclerview.widget.RecyclerView

class NameInputListAdapter(private val data: Array<String>, val inflater: LayoutInflater) :
    RecyclerView.Adapter<NameInputListAdapter.InputListViewHolder>() {

    class InputListViewHolder(val inputField: EditText) : RecyclerView.ViewHolder(inputField)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InputListViewHolder {
        val view = inflater.inflate(R.layout.name_input_text_field, null, false)

        val nameText = view.findViewById<EditText>(R.id.bracket_form_input_field)
        return InputListViewHolder(nameText)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: InputListViewHolder, position: Int) {
        holder.inputField.setText(data[position])
    }
}
