package com.application.todolistglints.ui.detail

import androidx.lifecycle.ViewModel
import com.application.todolistglints.data.TodoEntity
import com.application.todolistglints.utils.DataDummy

class DetailViewModel : ViewModel() {

    fun selectedItem(title: String): TodoEntity? {
        for (item in DataDummy.listTodo()) {
            if (title.equals(item.title)) {
                return item
            }
        }
        return null
    }
}