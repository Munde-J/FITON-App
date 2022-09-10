package dev.Jojo.example.repository

import dev.Jojo.example.Api.ApiClient
import dev.Jojo.example.Api.ApiInterface
import dev.Jojo.example.workoutlog.models.LoginRequest
import dev.Jojo.example.workoutlog.models.RegisterRequests
import dev.Jojo.example.workoutlog.models.RegisterResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class UserRepository{
    val apiClient = ApiClient.buildApiClient(ApiInterface::class.java)

    suspend fun loginUser(loginRequest: LoginRequest)
            = withContext(Dispatchers.IO){
        val response = apiClient.login(loginRequest)
        return@withContext response
    }
    suspend fun registerUser(registerRequests: RegisterRequests):Response<RegisterResponse>
    = withContext(Dispatchers.IO){
        val response=apiClient.registerUser(registerRequests)
        return@withContext response
    }
}