package com.application.todolistglints.ui.authentication.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.application.todolistglints.data.UserEntity
import com.application.todolistglints.utils.DataDummy

class LoginViewModel : ViewModel() {

    fun getUsername(username: String, password: String): Boolean {
        for(item in DataDummy.generateDummyUser()) {
            if (username == item.username && password == item.password) {
                return true
            }
        }
        return false
    }
}