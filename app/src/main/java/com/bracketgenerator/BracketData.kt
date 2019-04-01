package com.bracketgenerator

import androidx.databinding.ObservableField
import java.util.*

data class BracketData(
    var bracketName: ObservableField<String> = ObservableField(""),
    var players: MutableList<String> = mutableListOf("", "")
)