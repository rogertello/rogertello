package com.example.nyc_scorestest.model

import com.example.nyc_scorestest.model.remote.SchoolListResponse
import com.example.nyc_scorestest.model.remote.SchoolsSatResponse
import kotlinx.coroutines.flow.Flow


interface Repository {
    fun useCaseSchoolList(): Flow<UIState>
    fun useCaseSchoolSalByDBN(dbn: String) :Flow<UIState>
}