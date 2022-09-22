package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.asLiveData
import com.example.myapplication.data.UserPreferences
import com.example.myapplication.ui.auth.AuthActivity
import com.example.myapplication.ui.base.dashboard.DashboardActivity
import com.example.myapplication.ui.startNewActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val userPreferences = UserPreferences(this)

        userPreferences.authToken.asLiveData().observe(this, Observer {

            val activity = if (it == null) AuthActivity::class.java else DashboardActivity::class.java
            startNewActivity(activity)

        })


    }
}