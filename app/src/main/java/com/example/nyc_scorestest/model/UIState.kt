package com.example.nyc_scorestest.model

import com.example.nyc_scorestest.model.remote.SchoolListResponse
import com.example.nyc_scorestest.model.remote.SchoolsSatResponse

sealed class UIState {
    data class ResponseListSchool(val data: List<SchoolListResponse>) : UIState()
    data class ResponseSchoolSat(val data: SchoolsSatResponse) : UIState()
    data class Error(val errorMessage: String) : UIState()
    data class Loading(val isLoading: Boolean = false) : UIState()


}
