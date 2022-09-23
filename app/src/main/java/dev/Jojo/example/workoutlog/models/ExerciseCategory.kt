package dev.Jojo.example.workoutlog.models

import com.google.gson.annotations.SerializedName

data class ExerciseCategory(
    @SerializedName("category_id") var category: String,
    @SerializedName("category_name") var categoryName: String
)
