package com.application.todolistglints.ui.authentication.register

import androidx.lifecycle.ViewModel
import com.application.todolistglints.utils.DataDummy

class RegisterViewModel : ViewModel() {

    fun checkUsername(username: String): Boolean {
        for(item in DataDummy.generateDummyUser()) {
            if (username == item.username) {
                return true
            }
        }
        return false
    }
}