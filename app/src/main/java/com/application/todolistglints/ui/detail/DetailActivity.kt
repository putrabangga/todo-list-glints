package com.application.todolistglints.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.application.todolistglints.R
import com.application.todolistglints.data.TodoEntity
import com.application.todolistglints.databinding.ActivityDetailBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class DetailActivity : AppCompatActivity() {

    companion object {
        const val extraTask = "extra_task"
    }

    private lateinit var binding: ActivityDetailBinding
    private lateinit var detailViewModel: DetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        detailViewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        ).get(DetailViewModel::class.java)

        val call = intent.extras
        if (call != null) {
            val todo = call.getString(extraTask)
            if (todo != null) {
                detailViewModel.selectedItem(todo)
                callDetailTodo(detailViewModel.selectedItem(todo)!!)
            }
        }
    }

    private fun callDetailTodo(todo: TodoEntity) {
        Glide.with(this@DetailActivity).load(todo.image).apply(RequestOptions().override(0, 300))
            .into(binding.photoDetail)
        binding.titleDetail.text = todo.title
        binding.priorityDetail.text = todo.priority
        binding.dateDetail.text = todo.dueDate
        binding.timeDetail.text = todo.start
        binding.descriptionDetail.text = todo.description
    }
}