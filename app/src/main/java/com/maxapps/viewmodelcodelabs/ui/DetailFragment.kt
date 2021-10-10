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
import com.maxapps.viewmodelcodelabs.databinding.ActivityMainBinding
import com.maxapps.viewmodelcodelabs.databinding.FragmentDetailBinding
import com.maxapps.viewmodelcodelabs.viewmodel.JournalViewModel

class DetailFragment : Fragment() {
    private lateinit var db: FirebaseFirestore

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentDetailBinding.inflate(inflater,container,false)

        binding.recyclerView.apply {
            adapter = RvAdapter(repository)
            layoutManager = LinearLayoutManager(activity)
        }
        binding.floatingActionButton.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_detailFragment_to_addListFragment))
        return binding.root
    }
 }

