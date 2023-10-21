package com.lohanna.remote.model

import java.util.*

internal typealias MatchRemote = Match

data class Match(
    val name: String,
    val stadium: Stadium,
    val team1: String,
    val team2: String,
    val date: Date
)

internal typealias StadiumRemote = Stadium

data class Stadium(
    val name: String,
    val image: String
)