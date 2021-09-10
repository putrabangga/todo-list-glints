package com.application.todolistglints.utils

import com.application.todolistglints.R
import com.application.todolistglints.data.TodoEntity
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

    fun listTodo(): ArrayList<TodoEntity> {
        val listTodoUser = ArrayList<TodoEntity>()
        listTodoUser += TodoEntity(
            0,
            "Workout",
            "Do my daily workout for my body goals, keep spirit up",
            "High Priority",
            "13 September 2021",
            "10 Am",
            R.drawable.workout
        )

        listTodoUser += TodoEntity(
            1,
            "Make a Salad",
            "Make a Salad for my breakfast because salad is a healthy food",
            "Medium Priority",
            "13 September 2021",
            "11 AM",
            R.drawable.food,
        )

        listTodoUser += TodoEntity(
            2,
            "Playing Badminton",
            "sparring and play badminton with my friends at the Nusantara Gor",
            "Low Priority",
            "14 September 2021",
            "06 AM",
            R.drawable.badminton
        )

        listTodoUser += TodoEntity(
            3,
            "Feeding my cat Oslo",
            "give the oslo whiskas and then play together",
            "High Priority",
            "14 September 2021",
            "8 AM",
            R.drawable.cat
        )

        return listTodoUser
    }
}