package dev.Jojo.example.workoutlog

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import dev.Jojo.example.workoutlog.databinding.ActivityHomeBinding
import dev.Jojo.example.workoutlog.databinding.ActivityLoginBinding
import dev.Jojo.example.workoutlog.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {
   lateinit var binding: ActivitySignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnSignup.setOnClickListener {
            val intent=Intent(this,SignUpActivity::class.java)
            startActivity(intent)
            validateSignUp()
        }
        binding.tvLogin.setOnClickListener {
            val intent=Intent(this,LoginActivity::class.java)
            startActivity(intent)
        }
    }

        fun validateSignUp(){
            var Firstname = binding.etFirstName.text.toString()
            var Secondname =binding.etSecondName.text.toString()
            var Email1 = binding.etEmail1.text.toString()
            var Password =binding.etPassword1.text.toString()
            var Confirm = binding.etConfirm.text.toString()

            if (Firstname.isBlank()){
                binding.etFirstName.error = "First Name required"
            }

            if (Secondname.isBlank()){
                binding.etSecondName.error = "Second Name required"
            }

            if (Email1.isBlank()){
                binding.etEmail1.error = "Email required"
            }

            if (Password.isBlank()){
                binding.etPassword1.error = "Password required"
            }

            if (Confirm.isBlank()){
                binding.etConfirm.error = "Confirm your details"
            }

            if (Password!=Confirm){
                binding.tilPassword.error="Password does not match"
            }

        }
}