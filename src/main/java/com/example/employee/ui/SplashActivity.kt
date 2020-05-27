package com.example.employee.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.employee.R

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Handler().postDelayed({
            navigateToHomePage()},3000)
    }

    private fun navigateToHomePage() {
        var intent=Intent(this,HomeActivity()::class.java)
        startActivity(intent)
        finish()
    }
}
