package dev.Jojo.example.workoutlog.ui

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dev.Jojo.example.workoutlog.R
import dev.Jojo.example.workoutlog.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    lateinit var binding: ActivityHomeBinding
    lateinit var sharedPrefs: SharedPreferences


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvLogout.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
            logoutRequest()
        }
        castViews()
        setupBottomNav()
    }
    fun castViews() {
        binding.fcvHome
        binding.bnvHome
    }

    fun setupBottomNav() {
        binding.bnvHome.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.plan -> {
                    val transaction = supportFragmentManager.beginTransaction()
                    transaction.replace(R.id.fcvHome, PlanFragment())
                    transaction.commit()
                    true
                }
                R.id.track -> {
                    supportFragmentManager.beginTransaction().replace(R.id.fcvHome, TrackFragment()).commit()
                    true
                }
                R.id.profile -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fcvHome, ProfileFragment()).commit()
                    true
                }
                else -> false
            }
        }
    }

 fun logoutRequest () {
    sharedPrefs.edit().clear().commit()
    startActivity(Intent(this, LoginActivity::class.java))
    finish()
}
}
