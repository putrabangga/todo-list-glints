package com.application.todolistglints.ui.authentication.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.widget.doOnTextChanged
import androidx.lifecycle.ViewModelProvider
import com.application.todolistglints.R
import com.application.todolistglints.databinding.ActivityLoginActivityBinding
import com.application.todolistglints.ui.admin.AdminActivity
import com.application.todolistglints.ui.authentication.forgot_password.ForgotPasswordActivity
import com.application.todolistglints.ui.authentication.register.RegisterActivity
import com.application.todolistglints.ui.main.MainActivity

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginActivityBinding
    private lateinit var loginViewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loginViewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory()).get(LoginViewModel::class.java)

        binding.btnSignIn.setOnClickListener {
            val username = binding.edtUsername.text.toString()
            val password = binding.edtPassword.text.toString()
            binding.progressBar.visibility = View.VISIBLE

            if (loginViewModel.getUsername(username, password).equals("admin")) {
                binding.textInputUsername.error = null
                binding.textInputPassword.error = null

                val intent = Intent(this, AdminActivity::class.java)
                startActivity(intent)
                finishAffinity()
                binding.progressBar.visibility = View.GONE
            } else if(loginViewModel.getUsername(username, password).equals("user")){
                binding.textInputUsername.error = null
                binding.textInputPassword.error = null

                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finishAffinity()
                binding.progressBar.visibility = View.GONE
            }

            else {
                validateUsername(username)
                validatePassword(password)
                binding.progressBar.visibility = View.GONE
            }
        }

        binding.tvForgotPassword.setOnClickListener {
            val intent = Intent(this, ForgotPasswordActivity::class.java)
            startActivity(intent)
        }

        binding.tvSignUp.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }


    }

    private fun validateUsername(username: String): Boolean {
        when {
            username.isEmpty() -> {
                binding.textInputUsername.error = "Please fill this field"
            }
            else -> {
                binding.textInputUsername.error = "Username wrong"
            }
        }
        return false
    }

    private fun validatePassword(password: String): Boolean {
        when {
            password.isEmpty() -> {
                binding.textInputPassword.error = "Please fill this field"
            }
            else -> {
                binding.textInputPassword.error = "Password wrong"
            }
        }
        return false
    }
}