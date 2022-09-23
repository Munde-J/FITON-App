package dev.Jojo.example.workoutlog.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dev.Jojo.example.viewmodel.UserViewModel
import dev.Jojo.example.workoutlog.R
import dev.Jojo.example.workoutlog.databinding.FragmentPlanBinding
import dev.Jojo.example.workoutlog.databinding.FragmentProfileBinding
import dev.Jojo.example.workoutlog.models.ProfileRequests


class ProfileFragment : Fragment() {
     private lateinit var binding: FragmentProfileBinding
     private lateinit var userViewModel: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        userViewModel =
                ViewModelProvider(this).get(userViewModel::class.java)
        binding = FragmentProfileBinding.inflate(inflater, container, false)

       return  binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnProfileLogin.setOnClickListener{
            validateProfile()
        }
    }
    fun validateProfile() {
        var age = binding.tilAge.text.toString()
        var gender = binding.tilGender.text.toString()
        var email = binding.tilEmail.text.toString()
        var height = binding.tilHeight.text.toString()
        var weight = binding.tilWeight.text.toString()
        var BMI = binding.tilBMI.text.toString()
        var target = binding.tilTarget.text.toString()
        var error = false
        if (gender.isBlank()){
            binding.tilGender.error = "gender required"
        }
        if (age.isBlank()){
            binding.etAge.error = "age required"
        }
        if (email.isBlank()){
            binding.etEmail.error = "email required"
        }
        if (height.isBlank()){
            binding.etHeight.error = "height required"
        }
        if (weight.isBlank()){
            binding.etWeight.error = "weight required"
        }
        if (BMI.isBlank()){
            binding.etBMI.error = "BMI required"
        }
        if (target.isBlank()){
            binding.etTarget.error = "target required"
        }
        if (!error) {
            val profilerequest = ProfileRequests(age,gender,email,height,weight,BMI,target)
            userViewModel.profileUser(profilerequest)
        }
    }

}