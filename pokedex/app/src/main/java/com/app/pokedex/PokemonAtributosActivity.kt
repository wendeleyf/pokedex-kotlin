package com.app.pokedex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class PokemonAtributosActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokemon_atributos)

        // Adicionando action bar personalizada a activity
        adicionarActionBar()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    fun adicionarActionBar(){
        // Capturando action bar
        var action_bar = supportActionBar

        // Adicionando titulo e botão de voltar
        action_bar!!.title = "Pokémon"
        action_bar.setDisplayHomeAsUpEnabled(true)
    }
}
