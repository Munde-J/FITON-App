package dev.Jojo.example.workoutlog.ui

import android.content.Intent
import android.content.SharedPreferences
import android.media.session.MediaSession
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import dev.Jojo.example.util.Constants
import dev.Jojo.example.viewmodel.ExerciseViewModel
import dev.Jojo.example.workoutlog.R
import dev.Jojo.example.workoutlog.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    lateinit var binding: ActivityHomeBinding
    lateinit var sharedPrefs: SharedPreferences
    val exerciseViewModel : ExerciseViewModel by viewModels()


//A class is a tamplate used to create objects.
//A companion object allows you access values directly

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//    setContentView(layout.activity_home)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        castViews()
        setupBottomNav()
        sharedPrefs = getSharedPreferences(Constants.prefsFile, MODE_PRIVATE)
        val token = sharedPrefs.getString(Constants.accessToken, Constants.EMPTY_STRING)
        exerciseViewModel.fetchExerciseCategories(token!!)
        logoutRequest()

        }

    override fun onResume() {
        super.onResume()
        exerciseViewModel.exerciseCategoryLiveData.observe(this, Observer { exerciseCategories->
            Toast.makeText(this,"fetched ${exerciseCategories.size} categories",Toast.LENGTH_LONG).show()
        })
        exerciseViewModel.errorLiveData.observe(this, Observer { errorMsg->
            Toast.makeText(this, errorMsg, Toast.LENGTH_LONG).show()
        })
    }

//        binding.tvLogout.setOnClickListener {
//            val intent = Intent(this, LoginActivity::class.java)
//            startActivity(intent)
//            finish()
//            logoutRequest()
//        }
//        castViews()
//        setupBottomNav()
//        sharedPrefs
//
//    }
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
