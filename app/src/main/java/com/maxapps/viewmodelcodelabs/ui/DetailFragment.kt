package com.maxapps.viewmodelcodelabs.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.maxapps.viewmodelcodelabs.R
import com.maxapps.viewmodelcodelabs.database.repository
import com.maxapps.viewmodelcodelabs.viewmodel.JournalViewModel

class DetailFragment : Fragment() {

    private lateinit var fab: FloatingActionButton
    private lateinit var recyclerView: RecyclerView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_detail, container, false)

        fab = view.findViewById(R.id.floatingActionButton)
        recyclerView = view.findViewById(R.id.recyclerView)

        recyclerView.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = RvAdapter(repository)
        }
        fab.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_detailFragment_to_addListFragment)
            )
        return view
    }
 }

