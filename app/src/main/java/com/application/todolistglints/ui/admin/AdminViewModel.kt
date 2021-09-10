package com.application.todolistglints.ui.admin

import androidx.lifecycle.ViewModel
import com.application.todolistglints.data.TodoEntity
import com.application.todolistglints.data.UserEntity
import com.application.todolistglints.utils.DataDummy

class AdminViewModel : ViewModel() {


    fun getUser(): List<UserEntity> {
        val listUser = ArrayList<UserEntity>()
        for (item in DataDummy.generateDummyUser()) {
            if(item.username != "admin"){
                listUser.add(item)
            }
        }
        return listUser
    }

}