package dev.Jojo.example.workoutlog.models

import com.google.gson.annotations.SerializedName

class ProfileResponse (
    @SerializedName("age") var age:String,
    @SerializedName("gender") var gender:String,
    @SerializedName("email") var email:String,
    @SerializedName("height") var height:String,
    @SerializedName("weight") var weight:String,
    @SerializedName("BMI") var BMI:String,
    @SerializedName("target") var target:String,

    )

