package dev.Jojo.example.workoutlog.ui

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class SplashActivity : AppCompatActivity() {
    lateinit var sharePrefs:SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharePrefs = getSharedPreferences("WORKOUTLOG_PREFS", MODE_PRIVATE)
        val accessToken = sharePrefs.getString("ACCESS_TOKEN","")
        if (accessToken!!.isNotBlank()){
            startActivity(Intent(this, HomeActivity::class.java))
        }

        else{
        startActivity(Intent(this, LoginActivity::class.java))

    }
        finish()
}
}