package com.app.pokedex

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.AdapterView
import android.widget.Button
import android.widget.ListView
import android.widget.Toast
import com.app.pokedex.dbhelper.DbHelper
import com.app.pokedex.model.Pokemon
import com.app.pokedex.util.ListAdapter

class MainActivity : AppCompatActivity() {

    lateinit var listView: ListView
    lateinit var pknArrayList: ArrayList<Pokemon>
    private var listAdapter: ListAdapter? = null
    lateinit var dbHelper: DbHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listView = findViewById(R.id.pknListView)

        dbHelper = DbHelper(this)

        // buscando todos os pokémons cadastrados e adicionando ao ArrayList
        pknArrayList = dbHelper.getAllPokemons
        listAdapter = ListAdapter(this, this.pknArrayList)
        listView.adapter = listAdapter

        listView.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            val intent = Intent(this@MainActivity, UpdPokemon::class.java)
            intent.putExtra("pkn", pknArrayList[position])
            startActivity(intent)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.addPkn ->
                startActivity(Intent (this@MainActivity, AddPokemon::class.java))
        }
        return super .onOptionsItemSelected(item)
    }
}
