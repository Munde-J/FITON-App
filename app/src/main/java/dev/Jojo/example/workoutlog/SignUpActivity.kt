package dev.Jojo.example.workoutlog

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class SignUpActivity : AppCompatActivity() {
    lateinit var tilFirstName:TextInputLayout
    lateinit var etFirstName:TextInputEditText
    lateinit var tilSecondName:TextInputLayout
    lateinit var etSecondName:TextInputEditText
    lateinit var tilEmail:TextInputLayout
    lateinit var etEmail:TextInputEditText
    lateinit var tilPassword:TextInputLayout
    lateinit var etPassword:TextInputEditText
    lateinit var tilConfirm:TextInputLayout
    lateinit var etConfirm:TextInputEditText
    lateinit var btnSignup:Button
    lateinit var tvLogin:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        tilFirstName = findViewById(R.id.tilFirstName)
        etFirstName = findViewById(R.id.etFirstName)
        tilSecondName = findViewById(R.id.tilSecondName)
        etSecondName = findViewById(R.id.etSecondName)
        tilEmail = findViewById(R.id.tilEmail)
        etEmail = findViewById(R.id.etEmail1)
        tilPassword = findViewById(R.id.tilPassword)
        etPassword = findViewById(R.id.etPassword1)
        tilConfirm = findViewById(R.id.tilConfirm)
        etConfirm = findViewById(R.id.etConfirm)
        btnSignup = findViewById(R.id.btnSignup)

        btnSignup.setOnClickListener {
            val intent=Intent(this,SignUpActivity::class.java)
            startActivity(intent)
            validateSignUp()
        }
    }

        fun validateSignUp(){
            var Firstname = etFirstName.text.toString()
            var Secondname =etSecondName.text.toString()
            var Email = etEmail.text.toString()
            var Password =etPassword.text.toString()
            var Confirm = etConfirm.text.toString()

            if (Firstname.isBlank()){
                etFirstName.error = "First Name required"
            }

            if (Secondname.isBlank()){
                etSecondName.error = "Second Name required"
            }

            if (Email.isBlank()){
                etEmail.error = "Email required"
            }

            if (Password.isBlank()){
                etPassword.error = "Password required"
            }

            if (Confirm.isBlank()){
                etConfirm.error = "Confirm your details"
            }

            if (Password!=Confirm){
                tilPassword.error="Password does not match"
            }

        }
}