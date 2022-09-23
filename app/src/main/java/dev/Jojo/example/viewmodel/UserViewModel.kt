package dev.Jojo.example.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.Jojo.example.repository.UserRepository
import dev.Jojo.example.workoutlog.models.*
import kotlinx.coroutines.launch

class UserViewModel: ViewModel() {
    val userRepository = UserRepository()
    var loginResponseLiveData = MutableLiveData<LoginResponse>()
    val loginErrorLiveData = MutableLiveData<String?>()

    var registerResponseLiveData = MutableLiveData<RegisterResponse>()
    val registerErrorLiveData = MutableLiveData<String?>()
    var profileResponseLiveData = MutableLiveData<ProfileResponse>()
    val profileErrorLiveData = MutableLiveData<String?>()

    fun loginUser(loginRequest: LoginRequest) {
        viewModelScope.launch {
            val response = userRepository.loginUser(loginRequest)
            if (response.isSuccessful) {
                loginResponseLiveData.postValue(response.body())
            } else {
                val error = response.errorBody()?.string()
                loginErrorLiveData.postValue(error)
            }
        }
    }

    fun registerUser(registerRequests: RegisterRequests) {
        viewModelScope.launch {
            val response = userRepository.registerUser(registerRequests)
            if (response.isSuccessful) {
                registerResponseLiveData.postValue(response.body())
            } else {
                val error = response.errorBody()?.string()
                registerErrorLiveData.postValue(error)
            }
        }
    }

    fun profileUser(profileRequest: ProfileRequests) {
        viewModelScope.launch {
            val response = userRepository.profileUser(profileRequest)
            if (response.isSuccessful) {
                profileResponseLiveData.postValue(response.body())
            } else {
                val error = response.errorBody()?.string()
                profileErrorLiveData.postValue(error)
            }
        }
    }
}
