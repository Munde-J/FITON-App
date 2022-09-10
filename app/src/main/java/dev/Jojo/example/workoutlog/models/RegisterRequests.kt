package dev.Jojo.example.workoutlog.models

import com.google.gson.annotations.SerializedName

data class RegisterRequests(
    @SerializedName("first_name")var firstName:String,
    @SerializedName("first_name")var lastName:String,
    var email:String,
    @SerializedName("first_name")var phoneNumber:String,
    var password:String
)
