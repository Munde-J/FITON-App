package dev.Jojo.example.repository

import dev.Jojo.example.Api.ApiClient
import dev.Jojo.example.Api.ApiInterface
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ExerciseRepository {
    val apiClient = ApiClient.buildApiClient((ApiInterface::class.java))
    suspend fun fetchExerciseCategory(accessToken: String)=
        withContext(Dispatchers.IO){
            return@withContext apiClient.fetchExerciseCategories(accessToken)



    }
}