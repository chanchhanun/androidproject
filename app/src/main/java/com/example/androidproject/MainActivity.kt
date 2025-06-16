package com.example.androidproject

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.androidproject.databinding.ActivityWelcomeScreenBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityWelcomeScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityWelcomeScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.apply {
            binding.btnCreateAccount.setOnClickListener{
                val goToSignIn = Intent(this@MainActivity, SignInScreen::class.java)
                startActivity(goToSignIn)
            }
            binding.btnLogin.setOnClickListener{
                val goToLogin = Intent(this@MainActivity, LoginScreen::class.java)
                startActivity(goToLogin)
            }
        }
    }
}