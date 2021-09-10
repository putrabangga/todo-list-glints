package com.application.todolistglints.ui.authentication.forgot_password

import androidx.lifecycle.ViewModel
import com.application.todolistglints.utils.DataDummy

class ForgotPasswordViewModel: ViewModel() {

    fun sendEmail(email: String): Boolean {
        for(item in DataDummy.generateDummyUser()){
            if(email.equals(item.email)){
                return true
            }
        }
        return false
    }

}