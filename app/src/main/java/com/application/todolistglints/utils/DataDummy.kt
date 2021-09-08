package com.application.todolistglints.utils

import com.application.todolistglints.data.UserEntity

object DataDummy {
    fun generateDummyUser(): List<UserEntity> {

        val user = ArrayList<UserEntity>()

        user.add(UserEntity(1,
            "johnSmith",
            "johnSmith123",
            "johnSmith@gmail.com"))
        user.add(UserEntity(2,
            "renaTan",
            "renaTan123",
            "renatan27@gmail.com"))
        user.add(UserEntity(3,
            "leeJiAh",
            "leeJiAh123",
            "leejiah@gmail.com"))
        user.add(UserEntity(4,
            "user",
            "user123",
            "user@gmail.com"))
        user.add(UserEntity(5,
            "admin",
            "admin123",
            "admin@gmail.com"))
        return user
    }
}