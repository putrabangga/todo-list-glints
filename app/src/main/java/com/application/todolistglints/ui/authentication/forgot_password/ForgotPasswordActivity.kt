package com.application.todolistglints.ui.authentication.forgot_password

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.application.todolistglints.R
import com.application.todolistglints.databinding.ActivityAdminBinding
import com.application.todolistglints.databinding.ActivityForgotPasswordBinding
import com.application.todolistglints.ui.admin.AdminViewModel
import com.application.todolistglints.ui.authentication.login.LoginActivity
import com.google.android.material.snackbar.Snackbar




class ForgotPasswordActivity : AppCompatActivity() {
    private lateinit var binding: ActivityForgotPasswordBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityForgotPasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModel = ViewModelProvider(this,
            ViewModelProvider.NewInstanceFactory())[ForgotPasswordViewModel::class.java]

        binding.btnSend.setOnClickListener {
            binding.progress.visibility = View.VISIBLE
            val email = binding.etEmail.text.toString()

            if(viewModel.sendEmail(email)){
                binding.progress.visibility = View.GONE
                onSnack(it)
            }else{
                binding.progress.visibility = View.GONE
                errorForgotPassword(email)
            }
        }

        binding.btnBack.setOnClickListener {
            onBackPressed()
        }
    }

    fun onSnack(view: View){
        val snackbar = Snackbar.make(view, "Email has been sent. Please check your email.",
            Snackbar.LENGTH_LONG).setAction("Close"){
                startActivity(Intent(this, LoginActivity::class.java))
                finish()
        }
        snackbar.setActionTextColor(resources.getColor(R.color.white))
        val snackbarView = snackbar.view
        snackbarView.setBackgroundColor(resources.getColor(R.color.green))
        val textView =
            snackbarView.findViewById(com.google.android.material.R.id.snackbar_text) as TextView
        textView.setTextColor(resources.getColor(R.color.white))
        textView.textSize = 13f
        snackbar.show()
    }

    private fun errorForgotPassword(email: String): Boolean {
        val empty = "Please fill this field"
        val invalid = "Invalid email address"
        val notRegistered = "Email not registered"

        return when {
            email.isEmpty() -> {
                binding.tilEmail.error = empty
                false
            }
            !Patterns.EMAIL_ADDRESS.matcher(email).matches() -> {
                binding.tilEmail.error = invalid
                false
            }
            else -> {
                binding.tilEmail.error = notRegistered
                false
            }
        }
    }
}