package dev.Jojo.example.workoutlog.ui

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import dev.Jojo.example.Api.ApiClient
import dev.Jojo.example.Api.ApiInterface
import dev.Jojo.example.viewmodel.UserViewModel
import dev.Jojo.example.workoutlog.databinding.ActivityLoginBinding
import dev.Jojo.example.workoutlog.models.LoginRequest
import dev.Jojo.example.workoutlog.models.LoginResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class LoginActivity : AppCompatActivity() {
    lateinit var binding:ActivityLoginBinding
    lateinit var sharedPrefs: SharedPreferences
    val userViewModel: UserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPrefs = getSharedPreferences("WORKOUTLOG_PREFS", MODE_PRIVATE)

        binding.btnLogin.setOnClickListener {
            validateLogin()
            startActivity(Intent(this, HomeActivity::class.java))
            finish()

        }
        binding.tvSignup.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        userViewModel.loginResponseLiveData.observe(this, Observer{loginResponse->
            Toast.makeText(baseContext, loginResponse?.message,Toast.LENGTH_LONG).show()
            binding.pbLogin.visibility = View.GONE
            startActivity(Intent(baseContext,HomeActivity::class.java))
            finish()
        })
        userViewModel.loginErrorLiveData.observe(this, Observer{ error->
            Toast.makeText(baseContext,error,Toast.LENGTH_LONG).show()
        })
    }
    fun validateLogin(){
        var email = binding.etEmail1.text.toString()
        var password = binding.etPassword1.text.toString()
        var error = false

        if (email.isBlank()){
            binding.etEmail1.error = "Email required"
            error = true
        }

        if (password.isBlank()){
            binding.etPassword1.error = "Password required"
            error = true
        }
        if (!error){
            var loginRequest = LoginRequest(email,password)
            binding.pbLogin.visibility = View.GONE
            userViewModel.loginUser(loginRequest)
        }
    }
//    fun makeLoginRequest(loginRequest:LoginRequest){
//        var apiClient = ApiClient.buildApiClient(ApiInterface::class.java)
//        val request = apiClient.login(loginRequest)
//
//        request.enqueue(object : Callback<LoginResponse> {
//            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
//                binding.pbLogin.visibility = View.GONE
//                if (response.isSuccessful){
//                    val loginResponse = response.body()
//            }
//                else{
//                    val error = response.errorBody()?.string()
//                }
//            }
//            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
//                binding.pbLogin.visibility = View.GONE
//                Toast.makeText(baseContext,t.message,Toast.LENGTH_LONG).show()
//            }
//        })
//    }
    fun saveLoginDetails(loginResponse:LoginResponse){
        val editor = sharedPrefs.edit()
        val token = "Bearer ${loginResponse.accessToken}"

        editor.putString("ACCESS_TOKEN", loginResponse.accessToken)
        editor.putString("USER_ID", loginResponse.userId)
        editor.putString("PROFILE_ID", loginResponse.profileId)
        editor.apply()
        startActivity(Intent(this,LoginActivity::class.java))
        finish()

    }
    }
