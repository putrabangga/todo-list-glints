package com.application.todolistglints.ui.admin

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.application.todolistglints.R
import com.application.todolistglints.databinding.ActivityAdminBinding
import com.application.todolistglints.ui.authentication.login.LoginActivity
import com.application.todolistglints.utils.DataDummy

class AdminActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAdminBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAdminBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModel = ViewModelProvider(this,ViewModelProvider.NewInstanceFactory())[AdminViewModel::class.java]
        val user = viewModel.getUser()
        val adminAdapter = AdminAdapter()
        adminAdapter.setUser(user)

        with(binding.rvUser){
            layoutManager = LinearLayoutManager(this@AdminActivity)
            setHasFixedSize(true)
            adapter = adminAdapter
        }

        binding.tvTotalUser.text = user.size.toString()
        binding.btnLogout.setOnClickListener {
            val dialogBuilder = AlertDialog.Builder(this)
            dialogBuilder.setMessage("Are you sure you want to log out of your account?")
                .setCancelable(false)
                .setPositiveButton("Yes", DialogInterface.OnClickListener {
                    dialog, id ->  finish()
                    startActivity(Intent(this, LoginActivity::class.java))
                })
                .setNegativeButton("Cancel", DialogInterface.OnClickListener { dialog, id -> dialog.cancel()  })

            val alert = dialogBuilder.create()
            alert.setTitle("Log out")
            alert.show()
        }
    }
}