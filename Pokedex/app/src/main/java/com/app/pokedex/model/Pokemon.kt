package com.app.pokedex.model

import java.io.Serializable

class Pokemon: Serializable {

    var id: Int = 0
    var nome: String? = null
    var tipo: String? = null
    var genero: String? = null

    // getters e setters

    fun getIds(): Int {
        return  id
    }

    fun setIds(id: Int){
        this.id = id
    }

    fun getNomes(): String {
        return nome.toString()
    }

    fun setNomes(nome: String){
        this.nome = nome.toString()
    }

    fun getTipos(): String {
        return tipo.toString()
    }

    fun setTipos(tipo: String){
        this.tipo = tipo.toString()
    }

    fun getGeneros(): String {
        return genero.toString()
    }

    fun setGeneros(genero: String){
        this.genero = genero.toString()
    }
}