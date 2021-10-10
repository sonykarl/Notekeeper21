package com.maxapps.viewmodelcodelabs.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.firestore.*
import com.maxapps.viewmodelcodelabs.R
import com.maxapps.viewmodelcodelabs.database.Notes
import com.maxapps.viewmodelcodelabs.databinding.FragmentDetailBinding


class DetailFragment : Fragment() {
    private lateinit var db: FirebaseFirestore
    private lateinit var repository: ArrayList<Notes>
    private lateinit var myAdapter: RvAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentDetailBinding.inflate(inflater, container, false)
        repository = arrayListOf()
        myAdapter = RvAdapter(repository)
        binding.recyclerView.apply {
            adapter = RvAdapter(repository)
            layoutManager = LinearLayoutManager(activity)
        }

        binding.floatingActionButton.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_detailFragment_to_add_Fragment))
        return binding.root

    }
}



