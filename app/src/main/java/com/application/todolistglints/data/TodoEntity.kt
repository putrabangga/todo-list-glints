package com.application.todolistglints.data

data class TodoEntity(
    val id: Int = 0,
    val title: String,
    val description: String,
    val priority: String,
    val dueDate: String,
    val start: String,
    val image: Int
)