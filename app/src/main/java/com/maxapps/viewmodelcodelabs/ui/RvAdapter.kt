package com.maxapps.viewmodelcodelabs.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.maxapps.viewmodelcodelabs.R
import com.maxapps.viewmodelcodelabs.database.Journals
import com.maxapps.viewmodelcodelabs.databinding.ListitemsBinding

class RvAdapter(private val journal: ArrayList<Journals>): RecyclerView.Adapter<RvAdapter.MyViewHolder>(){

    inner class MyViewHolder( binding: ListitemsBinding) : RecyclerView.ViewHolder(binding.root){

        var title = binding.titleView
        var body = binding.bodyView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = ListitemsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentitem = journal[position]
        holder.title.text = currentitem.title
        holder.body.text = currentitem.body
    }

    override fun getItemCount() = journal.size
}