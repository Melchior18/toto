package com.example.toto.presentation.api


class PokemonDetailResponse (
    val name: String,
    val types: List<PokemonSlot>
    )

data class PokemonSlot(
    val Slot: Int,
    val type: PokemonType
)

data class PokemonType(
        val name: String,
        val url: String
)