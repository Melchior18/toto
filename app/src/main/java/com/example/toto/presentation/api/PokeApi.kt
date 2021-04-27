package com.example.toto.presentation.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface PokeApi {
    @GET("pokemon")
    fun getPokemonList(): Call<PokemonListResponse>

    @GET("pokemon/{id}")
    fun getPokemonDetail(@Path("id") id: Int): Call<PokemonDetailResponse>
    /*
    @GET("pokemon/{id}/types/slot/{type}")
    fun getPokemonType(@Path ("type") type: String): Call<PokemonDetailResponse>
     */
}