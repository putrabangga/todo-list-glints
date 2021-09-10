package com.application.todolistglints.ui.authentication.register

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.application.todolistglints.databinding.ActivityRegisterBinding
import com.application.todolistglints.ui.authentication.login.LoginActivity
import com.application.todolistglints.ui.main.MainActivity

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    private lateinit var registerViewModel: RegisterViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        registerViewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory()).get(RegisterViewModel::class.java)

        binding.btnSignUp.setOnClickListener {
            val username = binding.edtUsername.text.toString()
            val email = binding.edtUsername.text.toString()
            val password = binding.edtPassword.text.toString()
            val confirmPassword = binding.edtConfirmPassword.text.toString()
            binding.progressBar.visibility = View.VISIBLE

            if (registerViewModel.checkUsername(username)) {
                binding.progressBar.visibility = View.GONE
                binding.textInputUsername.error = "Username not valid"
            } else if (username.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty() && confirmPassword.isNotEmpty()) {
                binding.progressBar.visibility = View.GONE
                binding.textInputUsername.error = null
                binding.textInputEmail.error = null
                binding.textInputPassword.error = null
                binding.textInputConfirmPassword.error = null
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            } else if (password != confirmPassword){
                binding.progressBar.visibility = View.GONE
                binding.textInputConfirmPassword.error = "Password not matching"
            } else {
                binding.progressBar.visibility = View.GONE
                validateUsername(username)
                validateEmail(email)
                validatePassword(password)
                validateConfirmPassword(confirmPassword)
            }
        }
        binding.tvSignin.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
            finishAffinity()
        }
    }

    private fun validateUsername(username: String): Boolean {
        if (username.isEmpty()) {
            binding.textInputUsername.error = "Please fill this field"
        } else if (username.isNotEmpty()) {
            binding.textInputUsername.error = null
        }
        return false
    }

    private fun validateEmail(email: String): Boolean {
        if (email.isEmpty()) {
            binding.textInputEmail.error = "Please fill this field"
        } else if (email.isEmpty() && !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            binding.textInputEmail.error = "Invalid email address"
        } else if (email.isNotEmpty()) {
            binding.textInputEmail.error = null
        }
        return false
    }

    private fun validatePassword(password: String): Boolean {
        if (password.isEmpty()) {
            binding.textInputPassword.error = "Please fill this field"
        } else if (password.isNotEmpty()) {
            binding.textInputPassword.error = null
        }
        return false
    }

    private fun validateConfirmPassword(confirmPassword: String): Boolean {
        if (confirmPassword.isEmpty()) {
            binding.textInputConfirmPassword.error = "Please fill this field"
        } else if (confirmPassword.isNotEmpty()) {
            binding.textInputConfirmPassword.error = null
        }
        return false
    }
}