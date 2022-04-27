package com.example.nyc_scorestest.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.nyc_scorestest.model.Repository
import com.example.nyc_scorestest.model.UIState
import com.example.nyc_scorestest.model.remote.SchoolListResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class NYCViewModel (private val repository: Repository): ViewModel() {
    private val _schoolList = MutableLiveData<UIState>()
    val schoolList : LiveData<UIState>
    get() = _schoolList

init{
    getSchoolListList()
}
//corrutine non blocking action
    /*Coroutine scope define a "container" of coroutines
    * have 2 types,
    * launch - create & forget
    * async - create & await for a value
    *
    * Disparchers.IO Network calls, DB Transactions, java.io.file
    * Disparchers.Main  Main thread reference
    * Disparchers.Default Default thread pool.
    * Disparchers.Unconfined DONT USE!! ANR (Aplication Not Responding)
    *
    * */
    private fun getSchoolListList() {
    CoroutineScope(Dispatchers.IO)
        .launch {
            delay(500)
        repository.useCaseSchoolList()
            .collect {
            _schoolList.value = it
        }
    }
    }


}