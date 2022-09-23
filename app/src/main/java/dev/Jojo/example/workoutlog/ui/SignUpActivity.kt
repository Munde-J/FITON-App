package dev.Jojo.example.workoutlog.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import dev.Jojo.example.Api.ApiClient
import dev.Jojo.example.Api.ApiInterface
import dev.Jojo.example.viewmodel.UserViewModel
import dev.Jojo.example.workoutlog.databinding.ActivitySignUpBinding
import dev.Jojo.example.workoutlog.models.RegisterResponse
import dev.Jojo.example.workoutlog.models.RegisterRequests
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignUpActivity : AppCompatActivity() {
   lateinit var binding: ActivitySignUpBinding
   val userViewModel: UserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSignup.setOnClickListener {
            validateSignUp()
        }
        binding.tvLogin.setOnClickListener {
            val intent=Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }
        fun validateSignUp(){
            var Firstname = binding.etFirstName.text.toString()
            var Secondname =binding.etSecondName.text.toString()
            var Email1 = binding.etEmail1.text.toString()
            var PhoneNumber = binding.etPhoneNumber.text.toString()
            var Password =binding.etPassword1.text.toString()
            var Confirm = binding.etConfirm.text.toString()
            var error = false
//

            if (Firstname.isBlank()){
                binding.etFirstName.error = "First Name required"
            }

            if (Secondname.isBlank()){
                error=true
                binding.etSecondName.error = "Second Name required"
            }

            if (Email1.isBlank()){
                error=true
                binding.etEmail1.error = "Email required"
            }

            if (Password.isBlank()){
                error=true
                binding.etPassword1.error = "Password required"
            }

            if (Confirm.isBlank()){
                error=true
                binding.etConfirm.error = "Confirm your details"
            }

            if (Password!=Confirm){
                error=true
                binding.tilPassword.error="Password does not match"
            }

            if (PhoneNumber.isBlank()){
                error=true
                binding.etPhoneNumber.error="Phonenumber required"
            }

            if (!error){
                val registerRequests = RegisterRequests(Firstname, Secondname, Email1, PhoneNumber, Password)
//                makeRegistrationRequests(registerRequests)
                userViewModel.registerUser(registerRequests)
            }

        }

    override fun onResume() {
        super.onResume()
        userViewModel.registerResponseLiveData.observe(this, Observer {
            registerResponse->
            Toast.makeText(baseContext,registerResponse.message,Toast.LENGTH_LONG).show()
            startActivity(Intent(baseContext, LoginActivity::class.java))
        })
        userViewModel.registerErrorLiveData.observe(this, Observer {
            errorMsg->
            Toast.makeText(baseContext,errorMsg,Toast.LENGTH_LONG).show()
        })
    }
}