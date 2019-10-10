package com.app.pokedex

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.app.pokedex.dbhelper.DbHelper
import com.app.pokedex.model.Pokemon

class AddPokemon : AppCompatActivity() {

    lateinit var pknNome: EditText
    lateinit var pknTipo: EditText
    lateinit var pknGenero: EditText
    lateinit var pknBtnSalvar: Button
    private var dbHelper: DbHelper? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_pokemon)

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.title = "Cadastrar Pokémon"

        dbHelper = DbHelper(this)

        pknNome = findViewById(R.id.pknNome)
        pknTipo = findViewById(R.id.pknTipo)
        pknGenero = findViewById(R.id.pknGenero)
        pknBtnSalvar = findViewById(R.id.pknBtnSalvar)

        pknBtnSalvar.setOnClickListener {
            dbHelper!!.addPkn(pknNome.text.toString(), pknTipo.text.toString(), pknGenero.text.toString())
            Toast.makeText(this@AddPokemon, pknNome.text.toString()+" adicionado", Toast.LENGTH_SHORT).show()

            val intent = Intent(this@AddPokemon, MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
        }
    }

    // Seta para retornar a main activity
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
