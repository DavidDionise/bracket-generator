package com.bracketgenerator

import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.RecyclerView


class NameInputListAdapter(private val data: MutableList<String>) :
    RecyclerView.Adapter<NameInputListAdapter.InputListViewHolder>() {

    class InputListViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val inputField: EditText = view.findViewById(R.id.bracket_form_input_field)
        val removePlayerButton: Button = view.findViewById(R.id.remove_player_button)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NameInputListAdapter.InputListViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.name_input_text_field, parent, false)

        return InputListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: InputListViewHolder, position: Int) {
        holder.inputField.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                data[holder.adapterPosition] = s.toString()
            }

            override fun afterTextChanged(s: Editable?) {}
        })

        holder.removePlayerButton.setOnClickListener {
            holder.inputField.setText("")
            data.removeAt(holder.adapterPosition)
            this.notifyItemRemoved(holder.adapterPosition)
        }
    }


}
