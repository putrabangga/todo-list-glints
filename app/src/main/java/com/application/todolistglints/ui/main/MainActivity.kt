package com.application.todolistglints.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.application.todolistglints.R
import com.application.todolistglints.data.TodoEntity
import com.application.todolistglints.databinding.ActivityMainBinding
import com.application.todolistglints.ui.add.AddTaskActivity
import com.application.todolistglints.ui.detail.DetailActivity
import com.application.todolistglints.ui.detail.DetailActivity.Companion.extraTask

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainViewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        ).get(MainViewModel::class.java)
        mainViewModel.callData()
        mainViewModel.takeData().observe(this, {
            binding.movProgressbar.visibility = View.GONE
            callRecycler(it)
        })

        binding.fab.setOnClickListener { view ->
            val addIntent = Intent(this, AddTaskActivity::class.java)
            startActivity(addIntent)
        }
    }

    private fun callRecycler(todo: ArrayList<TodoEntity>) {
        binding.rvTodo.apply {
            val todoAdapter = TodoAdapter(todo)
            adapter = todoAdapter

            todoAdapter.setOnItemClickCallback(object : TodoAdapter.OnItemClickCallback {
                override fun onItemClicked(data: TodoEntity) {
                    val detailIntent = Intent(this@MainActivity, DetailActivity::class.java)
                    detailIntent.putExtra(extraTask, data.title)
                    startActivity(detailIntent)
                }
            })
            layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        }
    }
}