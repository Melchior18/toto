package com.example.toto.presentation.detail

import android.icu.text.IDNA
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.toto.R
import com.example.toto.presentation.Singletons
import com.example.toto.presentation.api.PokemonDetailResponse
import com.example.toto.presentation.api.PokemonType
import retrofit2.Call
import retrofit2.Response
import retrofit2.Callback
import java.lang.Error


class PokemonDetailFragment : Fragment() {

    private lateinit var textViewName: TextView
    private lateinit var textViewType: TextView
    private lateinit var textViewWeight: TextView
    private lateinit var imageView: ImageView
    private lateinit var imageShinyView: ImageView

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pokemon_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        imageView = view.findViewById(R.id.pokemon_img)
        imageShinyView= view.findViewById(R.id.pokemonShiny_img)
        textViewName = view.findViewById(R.id.pokemon_detail_name)
        textViewType = view.findViewById(R.id.pokemon_detail_type)
        // textViewWeight = view.findViewById(R.id.pokemon_detail_weight)
        callApi()
    }

    private fun callApi() {
        val id = arguments?.getInt("pokemonId") ?: -1
        val types = arguments?.getString("pokemonType") ?: -1

        Singletons.pokeApi.getPokemonDetail(id).enqueue(object : Callback<PokemonDetailResponse>{
            override fun onFailure(
                call: Call<PokemonDetailResponse>,
                t: Throwable)
            {
            }

            override fun onResponse(
                    call: Call<PokemonDetailResponse>,
                    response: Response<PokemonDetailResponse>)
            {
                if(response.isSuccessful && response.body() != null){

                    Glide
                        .with(this@PokemonDetailFragment)
                        .load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/$id.png")
                        .centerCrop()
                        .into(imageView)

                    Glide
                        .with(this@PokemonDetailFragment)
                        .load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/shiny/$id.png")
                        .centerCrop()
                        .into(imageShinyView)

                    textViewName.text = response.body()!!.name
                    textViewType.text =response.body()!!.types.map { it.type.name }.joinToString()
                    // textViewWeight.text = response.body()!!.weight.toString()
            }}

        })
        fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)

            // get reference to button
            val btn_back = view?.findViewById(R.id.btn_back) as Button
            // set on-click listener
            btn_back.setOnClickListener {
                // your code to perform when the user clicks on the button
                findNavController().navigate(R.id.navigateToPokemonListFragment, bundleOf())
            }
        }
        /*Singletons.pokeApi.getPokemonDetail(types).enqueue(object : Callback<PokemonDetailResponse>{
            override fun onFailure(
                    call: Call<PokemonDetailResponse>,
                    t: Throwable)
            {
            }

            override fun onResponse(
                    call: Call<PokemonDetailResponse>,
                    response: Response<PokemonDetailResponse>)
            {
                if (response.isSuccessful && response.body() != null){
                    textViewType.text = response.body()!!.types.toString()
            }}
        })*/
    }
}

