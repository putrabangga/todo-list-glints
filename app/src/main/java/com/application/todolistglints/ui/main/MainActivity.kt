package com.application.todolistglints.ui.main

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.application.todolistglints.data.TodoEntity
import com.application.todolistglints.databinding.ActivityMainBinding
import com.application.todolistglints.ui.add.AddTaskActivity
import com.application.todolistglints.ui.detail.DetailActivity
import kotlinx.android.synthetic.main.activity_main.*

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

        fab.setOnClickListener { view ->
            val addIntent = Intent(this, AddTaskActivity::class.java)
            startActivity(addIntent)
        }
    }

    private fun callRecycler(todo: ArrayList<TodoEntity>) {
        rv_todo.apply {
            val todoAdapter = TodoAdapter(todo)
            adapter = todoAdapter

            todoAdapter.setOnItemClickCallback(object : TodoAdapter.OnItemClickCallback {
                override fun onItemClicked(data: TodoEntity) {
                    val detailIntent = Intent(context, DetailActivity::class.java)
//                        detailIntent.putExtra(extraMovie, data.title)
//                        detailIntent.putExtra(extraType, typeMovie)
                    startActivity(detailIntent)
                }
            })
            layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        }
    }
}