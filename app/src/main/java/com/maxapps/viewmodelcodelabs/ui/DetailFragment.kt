package com.maxapps.viewmodelcodelabs.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.maxapps.viewmodelcodelabs.R

class DetailFragment : Fragment() {

    private lateinit var fab: FloatingActionButton

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_detail, container, false)
        fab = view.findViewById(R.id.floatingActionButton)
        fab.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_detailFragment_to_addListFragment)
            )
        return view
    }
 }
