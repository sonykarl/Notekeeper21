package com.maxapps.viewmodelcodelabs.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.maxapps.viewmodelcodelabs.R
import com.maxapps.viewmodelcodelabs.database.Journals

class RvAdapter(private val journal: ArrayList<Journals>): RecyclerView.Adapter<RvAdapter.MyViewHolder>(){
    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        var title: TextView = itemView.findViewById(R.id.titleView)
        var body: TextView = itemView.findViewById(R.id.bodyView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemview = LayoutInflater.from(parent.context).inflate(R.layout.listitems, parent, false)
        return MyViewHolder(itemview)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentitem = journal[position]
        holder.title.text = currentitem.title
        holder.body.text = currentitem.body
    }

    override fun getItemCount() = journal.size
}