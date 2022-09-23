package dev.Jojo.example.Api

import android.media.session.MediaSession
import dev.Jojo.example.workoutlog.models.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface ApiInterface {
    @POST("/register")
    suspend fun registerUser(@Body registerRequests: RegisterRequests):Response<RegisterResponse>

    @POST("/login")
    suspend fun login(@Body loginRequest: LoginRequest): Response<LoginResponse>

    @POST("/profile")
    suspend fun profile(@Body profileRequest: ProfileRequests): Response<ProfileResponse>

//header is a key value pair of some additional information that you send with your request

    @GET("/exercise-categories")
    suspend fun fetchExerciseCategories(@Header("Authorization")accessToken: String):Response<List<ExerciseCategory>>



}

