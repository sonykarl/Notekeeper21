package com.maxapps.viewmodelcodelabs.viewmodel

import androidx.lifecycle.ViewModel
import com.maxapps.viewmodelcodelabs.database.Journals
import com.maxapps.viewmodelcodelabs.database.repository

class JournalViewModel: ViewModel() {

    fun insert(head: String, tail: String){
        var userdata = Journals(head,tail)
        repository.add(userdata)
    }

}