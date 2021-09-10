package com.application.todolistglints.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.application.todolistglints.R
import com.application.todolistglints.data.TodoEntity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class TodoAdapter(private val todo: ArrayList<TodoEntity>) :
    RecyclerView.Adapter<TodoAdapter.ViewHolder>() {

    private var onItemClickCallback: OnItemClickCallback? = null

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: TodoEntity)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.findViewById(R.id.photo)
        val priority: TextView = itemView.findViewById(R.id.priority)
        val date: TextView = itemView.findViewById(R.id.date)
        val time: TextView = itemView.findViewById(R.id.time)
        val title: TextView = itemView.findViewById(R.id.title)
        val description: TextView = itemView.findViewById(R.id.description)

        fun bind(todo: TodoEntity) {
            Glide.with(itemView.context)
                .load(todo.image)
                .apply(RequestOptions().override(0, 400))
                .into(image)

            priority.text = todo.priority
            date.text = todo.dueDate
            time.text = todo.start
            title.text = todo.title
            description.text = todo.description

            itemView.setOnClickListener {
                onItemClickCallback?.onItemClicked(todo)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoAdapter.ViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_task, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: TodoAdapter.ViewHolder, position: Int) {
        holder.bind(todo[position])
    }

    override fun getItemCount(): Int = todo.size

}