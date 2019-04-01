package com.bracketgenerator

import androidx.lifecycle.ViewModel

data class BracketViewModel(
    var name: String = "",
    var users: MutableList<String> = mutableListOf("", "")
) : ViewModel()