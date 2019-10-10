package com.app.pokedex.util

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.app.pokedex.R
import com.app.pokedex.model.Pokemon

// classe para definir os dados em todas as linhas da ListView
class ListAdapter(private val context: Context, private val pknArrayList: ArrayList<Pokemon>) :
    BaseAdapter() {

    override fun getCount(): Int {
        return pknArrayList.size
    }

    override fun getItem(position: Int): Any {
        return pknArrayList[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getView(position: Int, convertView: View?, viewGroup: ViewGroup?): View {
        val inflater = LayoutInflater.from(context)
        val rowCard = inflater.inflate(R.layout.adapter_pkn_items, viewGroup, false)

        val pknId = rowCard.findViewById<TextView>(R.id.pknId)
        val pknNome = rowCard.findViewById<TextView>(R.id.pknNome)
        val pknTipo = rowCard.findViewById<TextView>(R.id.pknTipo)
        val pknGenero = rowCard.findViewById<TextView>(R.id.pknGenero)

        pknId.text = pknArrayList[position].getIds().toString()
        pknNome.text = pknArrayList[position].getNomes()
        pknTipo.text = pknArrayList[position].getTipos()
        pknGenero.text = pknArrayList[position].getGeneros()

        return rowCard
    }
}