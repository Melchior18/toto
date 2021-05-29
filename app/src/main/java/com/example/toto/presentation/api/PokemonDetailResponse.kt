package com.example.toto.presentation.api


class PokemonDetailResponse (
    val name: String,
    val types: List<PokemonSlot>
     //val weight: PokemonWeight
    )

data class PokemonSlot(
    val Slot: Int,
    val type: PokemonType
)

data class PokemonType(
        val name: String,
        val url: String
)

/*data class PokemonWeight(
        val int: Int
)*/