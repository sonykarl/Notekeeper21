package com.maxapps.viewmodelcodelabs.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.ViewModelProvider
import com.maxapps.viewmodelcodelabs.R
import com.maxapps.viewmodelcodelabs.viewmodel.JournalViewModel


class AddListFragment : Fragment() {

    private lateinit var savebutton: Button
    private lateinit var title: EditText
    private lateinit var body: EditText
    private lateinit var viewModel: JournalViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_add_list, container, false)

        title = view.findViewById(R.id.titleText)
        body = view.findViewById(R.id.bodyText)
        viewModel = ViewModelProvider(this).get(JournalViewModel::class.java)
        savebutton = view.findViewById(R.id.savebutton)
        savebutton.setOnClickListener{

            viewModel.insert(title.text.toString(),body.text.toString())
            title.text.clear()
            body.text.clear()
        }
        return view
    }

}