package com.application.todolistglints.ui.add

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.application.todolistglints.DatePickerFragment
import com.application.todolistglints.R

class AddTaskActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_task)
    }

    fun showDatePicker(view: View) {
        val dialogFragment = DatePickerFragment()
        dialogFragment.show(supportFragmentManager, "datePicker")
    }
}