package com.app.pokedex

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var input_pesquisar : EditText
    lateinit var btn_pesquisar : Button
    lateinit var btn_avancar : Button
    lateinit var nome_pokemon : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adicionarActionBar()

        input_pesquisar = findViewById(R.id.input_pesquisar)
        btn_pesquisar = findViewById(R.id.btn_pesquisar)
        nome_pokemon = findViewById(R.id.nome_pokemon)
        btn_avancar = findViewById(R.id.btn_avancar)

        // Realizando pesquisa por nome
        btn_pesquisar.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {

                // Exibindo mensagem em um toast
                Toast.makeText(applicationContext,
                    "Pesquisando ...", Toast.LENGTH_SHORT).show()

                // Exibindo nome digitado em um text view
                nome_pokemon.text = input_pesquisar.text.toString()
            }

        })

        // Mudando de activity
        btn_avancar.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {

                // Chamando activity para listar os atributos de um pokemon
                startActivity(Intent (this@MainActivity, PokemonAtributosActivity::class.java))
            }
        })
    }

    fun adicionarActionBar(){
        // Capturando action bar
        var action_bar = supportActionBar

        // Adicionando titulo
        action_bar!!.title = "Pokedex"
    }
}