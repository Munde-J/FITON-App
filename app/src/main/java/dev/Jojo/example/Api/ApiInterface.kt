package dev.Jojo.example.Api

import dev.Jojo.example.workoutlog.models.LoginRequest
import dev.Jojo.example.workoutlog.models.LoginResponse
import dev.Jojo.example.workoutlog.models.RegisterResponse
import dev.Jojo.example.workoutlog.models.RegisterRequests
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiInterface {
    @POST("/register")
    suspend fun registerUser(@Body registerRequests: RegisterRequests):Response<RegisterResponse>

    @POST("/login")
    suspend fun login(@Body loginRequest: LoginRequest): Response<LoginResponse>

}

