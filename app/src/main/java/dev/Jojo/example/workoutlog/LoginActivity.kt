package dev.Jojo.example.workoutlog

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.android.material.textfield.TextInputLayout

class LoginActivity : AppCompatActivity() {
    lateinit var  btnLogin:Button
    lateinit var tilEmail1:TextInputLayout
    lateinit var tilPassword1:TextInputLayout
    lateinit var etEmail1:EditText
    lateinit var etPassword1:EditText
    lateinit var tvSignup:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btnLogin = findViewById(R.id.btnLogin)
        tilEmail1 = findViewById(R.id.tilEmail1)
        tilPassword1 = findViewById(R.id.tilPassword1)
        etEmail1 = findViewById(R.id.etEmail1)
        etPassword1 =findViewById(R.id.etPassword1)
        tvSignup = findViewById(R.id.tvSignup)

        btnLogin.setOnClickListener {
            val intent=Intent(this,LoginActivity::class.java)
            startActivity(intent)
            validateLogin()

        }

        tvSignup.setOnClickListener {
            val intent=Intent(this,SignUpActivity::class.java)
            startActivity(intent)
            validateLogin()
        }
    }
    fun validateLogin(){
        var email = etEmail1.text.toString()
        var password = etPassword1.text.toString()

        if (email.isBlank()){
            etEmail1.error = "Email required"
        }

        if (password.isBlank()){
            etPassword1.error = "Password required"
        }
    }
    }