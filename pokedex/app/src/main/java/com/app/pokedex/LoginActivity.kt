package com.app.pokedex

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class LoginActivity : AppCompatActivity() {

    lateinit var btn_login : Button
    lateinit var usuario_input : EditText
    lateinit var senha_input : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        supportActionBar!!.hide()

        // Obtendo login e senha
        usuario_input = findViewById(R.id.usuario_input)
        senha_input = findViewById(R.id.senha_input)

        // Alterando evento de click do botão de login
        btn_login = findViewById(R.id.btn_login)

        btn_login.setOnClickListener(object: View.OnClickListener {
            override fun onClick(v: View?) {
                // Validação de login simple (TEMPORARIA)
                if (usuario_input.text.toString().equals("cleefsouza") && senha_input.text.toString().equals("123456")) {
                    startActivity(Intent (this@LoginActivity , MainActivity::class.java))
                } else {
                    Toast.makeText(applicationContext, "Usuário ou senha inválidos!", Toast.LENGTH_SHORT).show()
                }
            }
        })
    }
}
