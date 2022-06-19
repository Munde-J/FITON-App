package dev.Jojo.example.workoutlog

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.android.material.textfield.TextInputLayout
import dev.Jojo.example.workoutlog.databinding.ActivityHomeBinding
import dev.Jojo.example.workoutlog.databinding.ActivityLoginBinding
import dev.Jojo.example.workoutlog.databinding.ActivitySignUpBinding

class LoginActivity : AppCompatActivity() {
    lateinit var binding:ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {
            validateLogin()
            startActivity(Intent(this,HomeActivity::class.java))
            finish()

        }
        binding.tvSignup.setOnClickListener {
            val intent = Intent(this,SignUpActivity::class.java)
            startActivity(intent)
        }

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
            startActivity(Intent(this, HomeActivity::class.java))
            finish()
        }
    }
    }