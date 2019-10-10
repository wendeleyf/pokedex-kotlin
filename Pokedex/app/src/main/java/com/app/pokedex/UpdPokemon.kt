package com.app.pokedex

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.app.pokedex.dbhelper.DbHelper
import com.app.pokedex.model.Pokemon
import kotlinx.android.synthetic.main.activity_upd_pokemon.*

class UpdPokemon : AppCompatActivity() {

    lateinit var pknNome: EditText
    lateinit var pknTipo: EditText
    lateinit var pknGenero: EditText
    lateinit var pknBtnSalvar: Button
    lateinit var pknBtnRemover: Button
    private var pkn: Pokemon? = null
    private var dbHelper: DbHelper? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_upd_pokemon)

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        pknNome = findViewById(R.id.pknNome)
        pknTipo = findViewById(R.id.pknTipo)
        pknGenero = findViewById(R.id.pknGenero)
        pknBtnSalvar = findViewById(R.id.pknBtnSalvar)
        pknBtnRemover = findViewById(R.id.pknBtnRemover)

        dbHelper = DbHelper(this)
        val intent = intent
        pkn = intent.getSerializableExtra("pkn") as Pokemon

        supportActionBar!!.title = pkn!!.getNomes()

        pknNome.setText(pkn!!.getNomes())
        pknTipo.setText(pkn!!.getTipos())
        pknGenero.setText(pkn!!.getGeneros())

        pknBtnSalvar.setOnClickListener {
            dbHelper!!.updatePkn(pkn!!.getIds(), pknNome.text.toString(), pknTipo.text.toString(), pknGenero.text.toString())
            Toast.makeText(this@UpdPokemon, pknNome.text.toString()+" atualizado", Toast.LENGTH_SHORT).show()
            val intent = Intent(this@UpdPokemon, MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
        }

        pknBtnRemover.setOnClickListener {
            dbHelper!!.deletePkn(pkn!!.getIds())
            Toast.makeText(this@UpdPokemon, pknNome.text.toString()+" removido", Toast.LENGTH_SHORT).show()
            val intent = Intent(this@UpdPokemon, MainActivity::class.java)
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
