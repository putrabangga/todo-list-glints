package com.application.todolistglints.ui.authentication.login

import androidx.lifecycle.ViewModel
import com.application.todolistglints.utils.DataDummy

class LoginViewModel : ViewModel() {

    fun getUsername(username: String, password: String): String? {
        for(item in DataDummy.generateDummyUser()) {
            if (username == item.username && password == item.password) {
                if(username.equals("admin")){
                    return "admin"
                }else{
                    return "user"
                }
            }
        }
        return null
    }
}