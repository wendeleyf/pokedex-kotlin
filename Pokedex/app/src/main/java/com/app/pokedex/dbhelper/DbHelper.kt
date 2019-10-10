package com.app.pokedex.dbhelper

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import com.app.pokedex.model.Pokemon
import java.util.ArrayList

class DbHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    // buscando todos os pokémons cadastrados
    val getAllPokemons: ArrayList<Pokemon>
        get() {
            val pknArrayList = ArrayList<Pokemon>()

            val selectQuery = "SELECT  * FROM $TABLE_POKEMON"
            val db = this.readableDatabase
            val c = db.rawQuery(selectQuery, null)
            if (c.moveToFirst()) {
                do {
                    val pkn = Pokemon()
                    pkn.setIds(c.getInt(c.getColumnIndex(KEY_ID)))
                    pkn.setNomes(c.getString(c.getColumnIndex(KEY_NOME)))
                    pkn.setTipos(c.getString(c.getColumnIndex(KEY_TIPO)))
                    pkn.setGeneros(c.getString(c.getColumnIndex(KEY_GENERO)))
                    pknArrayList.add(pkn)
                } while (c.moveToNext())
           }
            c.close()
            db.close()
            return pknArrayList
        }

    init {
        Log.d("table", TABLE_POKEMON)
    }

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(CREATE_TABLE_POKEMONS)

    }
    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        Log.d("path", db?.path)
        db?.execSQL("DROP TABLE IF EXISTS '$TABLE_POKEMON'")
        onCreate(db)
    }

    // adicionar pokémon a database
    fun addPkn(nome: String, tipo: String, genero: String): Boolean {
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(KEY_NOME, nome)
        values.put(KEY_TIPO, tipo)
        values.put(KEY_GENERO, genero)
        Log.v("add", "Inserido com sucesso!")
        db.insert(TABLE_POKEMON, null, values)
        db.close()
        return true
    }

    // atualizar um pokémon especifico na database atras vez do seu id
    fun updatePkn(id: Int, nome: String, tipo: String, genero: String): Int {
        val db = this.writableDatabase

        val values = ContentValues()
        values.put(KEY_NOME, nome)
        values.put(KEY_TIPO, tipo)
        values.put(KEY_GENERO, genero)
        return db.update(
            TABLE_POKEMON, values, "$KEY_ID = ?",
            arrayOf(id.toString())
        )
    }

    // remover um pokémon da database pelo seu id
    fun deletePkn(id: Int) {
        val db = this.writableDatabase
        db.delete(
            TABLE_POKEMON, "$KEY_ID = ?",
            arrayOf(id.toString())
        )
    }

    companion object {

        // dados referente a database
        var DATABASE_NAME = "db_pokedex"
        private val DATABASE_VERSION = 1
        private val TABLE_POKEMON = "pokemons"
        private val KEY_ID = "id"
        private val KEY_NOME = "nome"
        private val KEY_TIPO = "tipo"
        private val KEY_GENERO = "genero"

        // criar tabela no db_pokedex
        private val CREATE_TABLE_POKEMONS = ("CREATE TABLE "
                + TABLE_POKEMON + "(" + KEY_ID
                + " INTEGER PRIMARY KEY AUTOINCREMENT," + KEY_NOME + " TEXT, " + KEY_TIPO + " TEXT, " + KEY_GENERO + " TEXT );")
    }
}