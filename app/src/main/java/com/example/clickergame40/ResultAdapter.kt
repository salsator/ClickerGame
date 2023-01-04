package com.example.clickergame40

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ResultAdapter( val scoreBoard: List<Winner>): RecyclerView.Adapter<ResultAdapter.MyViewHolder>() {

    class MyViewHolder(val view: View) : RecyclerView.ViewHolder(view)
    {
        val jmenoT: TextView = view.findViewById(R.id.nameTxt)
        val scoreT: TextView = view.findViewById(R.id.scoreTxt)

    }

    override fun getItemCount(): Int = scoreBoard.size



    override fun onBindViewHolder(viewHolder: MyViewHolder, index: Int) {
        val vysledek = scoreBoard[index]
        val context = viewHolder.view.context

        viewHolder.jmenoT.text = "Jméno: ${vysledek.name}"
        viewHolder.scoreT.text = "Score: ${vysledek.score}"


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item,parent,false)
        return MyViewHolder(view)
    }

}