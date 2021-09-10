package com.maxapps.viewmodelcodelabs.viewmodel

import androidx.lifecycle.ViewModel
import com.maxapps.viewmodelcodelabs.database.Journals

class JournalViewModel: ViewModel() {

    val repository = ArrayList<Journals>()
    var head: String = ""
    var tail: String = ""

    fun insert(){
        val userdata = Journals(head,tail)
        repository.add(userdata)
    }

}
