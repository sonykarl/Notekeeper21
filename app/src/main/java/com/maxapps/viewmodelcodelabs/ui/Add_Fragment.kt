package com.maxapps.viewmodelcodelabs.ui

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.google.firebase.firestore.FirebaseFirestore
import com.maxapps.viewmodelcodelabs.R
import com.maxapps.viewmodelcodelabs.databinding.FragmentAddBinding

class Add_Fragment : Fragment() {

    lateinit var binding: FragmentAddBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAddBinding.inflate(inflater, container, false)


        binding.button.setOnClickListener{

            val title = binding.titleText.text.toString()
            val body = binding.bodyText.text.toString()
            saveFirestore(title, body)

        }

        return binding.root
    }

    fun saveFirestore(title:String, body:String){

        val db = FirebaseFirestore.getInstance()
        val notes = hashMapOf( "Title" to "$title", "Body" to "$body")

        db.collection("Notes").document("$title").set(notes).addOnSuccessListener { Log.d(TAG, "DocumentSnapshot successfully written!") }
            .addOnFailureListener { e -> Log.w(TAG, "Error writing document", e) }
    }
}

