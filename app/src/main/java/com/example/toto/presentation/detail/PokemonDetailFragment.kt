package com.example.toto.presentation.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.example.toto.R
import com.example.toto.presentation.Singletons
import com.example.toto.presentation.api.PokemonDetailResponse
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback


class PokemonDetailFragment : Fragment() {

    private lateinit var textViewName: TextView

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pokemon_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        textViewName = view.findViewById(R.id.pokemon_detail_name)
        callApi()
    }

    private fun callApi() {
        val id = arguments?.getInt("pokemmonId") ?: -1

        Singletons.pokeApi.getPokemonDetail(id).enqueue(object : retrofit2.Callback<PokemonDetailResponse>{
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
                textViewName.text = response.body()!!.name
            }}



        })
    }
}

