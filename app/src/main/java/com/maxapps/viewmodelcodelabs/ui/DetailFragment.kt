package com.maxapps.viewmodelcodelabs.ui


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.firestore.*
import com.google.firebase.firestore.ktx.toObject
import com.maxapps.viewmodelcodelabs.R
import com.maxapps.viewmodelcodelabs.database.Notes
import com.maxapps.viewmodelcodelabs.databinding.FragmentDetailBinding


class DetailFragment : Fragment() {

    private var adapter: RvAdapter ?= null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentDetailBinding.inflate(inflater, container, false)
        val db = FirebaseFirestore.getInstance()
        var notelist = arrayListOf<Notes>()

        db.collection("Notes")
            .get()
            .addOnSuccessListener {
                for (document in it){
                    val note = document.toObject<Notes>()
                    notelist.add(note)
                }
                binding.recyclerView.apply {
                    adapter = RvAdapter(notelist)
                    layoutManager = LinearLayoutManager(activity)
                }
            }

        binding.floatingActionButton.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_detailFragment_to_add_Fragment))
        return binding.root

    }

}



