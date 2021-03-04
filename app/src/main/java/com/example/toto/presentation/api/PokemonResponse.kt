package com.example.toto.presentation.api

import com.example.toto.presentation.list.Pokemon

data class PokemonResponse(
    val count: Int,
    val next: String,
    val results: List<Pokemon>
)