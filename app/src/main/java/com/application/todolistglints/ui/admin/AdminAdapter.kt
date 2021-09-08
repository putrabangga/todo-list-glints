package com.application.todolistglints.ui.admin

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.application.todolistglints.data.UserEntity
import com.application.todolistglints.databinding.ItemAllUserBinding

class AdminAdapter: RecyclerView.Adapter<AdminAdapter.UserViewHolder>() {
    class UserViewHolder(private val binding: ItemAllUserBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(user: UserEntity){
            with(binding){
                tvUsername.text = user.username
                tvEmail.text = user.email
            }
        }

    }

    private var listUser = ArrayList<UserEntity>()

    fun setUser(user: List<UserEntity>?){
        if(user == null) return
        this.listUser.clear()
        this.listUser.addAll(user)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdminAdapter.UserViewHolder {
        val itemsUserBinding = ItemAllUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UserViewHolder(itemsUserBinding)
    }

    override fun onBindViewHolder(holder: AdminAdapter.UserViewHolder, position: Int) {
        val user = listUser[position]
        holder.bind(user)
    }

    override fun getItemCount(): Int = listUser.size


}