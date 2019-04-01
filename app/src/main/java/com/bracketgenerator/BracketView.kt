package com.bracketgenerator


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders


/**
 * A simple [Fragment] subclass.
 *
 */
class BracketView : Fragment() {
    private lateinit var model: BracketViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        model = ViewModelProviders.of(activity!!).get(BracketViewModel::class.java)
        Log.i(">>>", "Model : $model")
        return inflater.inflate(R.layout.fragment_bracket_view, container, false)
    }


}
