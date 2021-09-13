package com.maxapps.viewmodelcodelabs.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.maxapps.viewmodelcodelabs.R
import com.maxapps.viewmodelcodelabs.databinding.FragmentAddListBinding
import com.maxapps.viewmodelcodelabs.viewmodel.JournalViewModel


class AddListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = FragmentAddListBinding.inflate(inflater,container,false)
        val viewModel = ViewModelProvider(this).get(JournalViewModel::class.java)

        binding.savebutton.setOnClickListener{
            viewModel.insert(binding.titleText.text.toString(), binding.bodyText.text.toString())
        }

        return binding.root
    }
}