package com.maxapps.viewmodelcodelabs.ui

import android.os.Bundle
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

        val title = binding.titleText.text.toString()
        val body = binding.bodyText.text.toString()
        binding.button.setOnClickListener{
            saveFirestore(title, body)
        }

        return binding.root
    }

    fun saveFirestore(title:String, body:String){
        val db = FirebaseFirestore.getInstance()
        val notes: MutableMap<String, String> = HashMap()
        notes["Title"] = title
        notes["Body"] = body

        db.collection("Notes")
            .add(notes)

    }
}

