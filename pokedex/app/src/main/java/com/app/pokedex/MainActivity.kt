package com.app.pokedex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var inpPesquisar : EditText
    lateinit var btnPesquisar : Button
    lateinit var nomePokemon : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        inpPesquisar = findViewById(R.id.inpPesquisar)
        btnPesquisar = findViewById(R.id.btnPesquisar)
        nomePokemon = findViewById(R.id.nomePokemon)

        // Editando evento do botão pesquisar
        btnPesquisar.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {

                // Exibindo mensagem em um toast
                Toast.makeText(applicationContext,
                    "Pesquisando ...", Toast.LENGTH_SHORT).show()

                // Exibindo nome digitado em um text view
                nomePokemon.text = inpPesquisar.text.toString()
            }

        })
    }
}