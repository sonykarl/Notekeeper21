package com.maxapps.viewmodelcodelabs.ui


import android.os.Bundle
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

    val noteslist = ArrayList<Notes>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentDetailBinding.inflate(inflater, container, false)

        FetchData()

        binding.recyclerView.apply {
            adapter = RvAdapter(noteslist)
            layoutManager = LinearLayoutManager(activity)
        }

        binding.floatingActionButton.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_detailFragment_to_add_Fragment))
        return binding.root

    }
    private fun FetchData() {
        val db = FirebaseFirestore.getInstance()

        db.collection("Notes")
            .get()
            .addOnSuccessListener {result ->
                for (document in result){
                    val note = document.toObject(Notes::class.java)
                    noteslist.add(note)
                }
            }


            }


}



