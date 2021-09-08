package com.application.todolistglints.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.application.todolistglints.data.TodoEntity
import com.application.todolistglints.utils.DataDummy

class MainViewModel : ViewModel() {

    private val listTodo = MutableLiveData<ArrayList<TodoEntity>>()

    fun callData() {
        listTodo.postValue(DataDummy.listTodo())
    }

    fun takeData(): LiveData<ArrayList<TodoEntity>> {
        return listTodo
    }
}