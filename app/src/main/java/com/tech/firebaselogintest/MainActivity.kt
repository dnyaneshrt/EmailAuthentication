package com.tech.firebaselogintest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var text= findViewById<TextView>(R.id.my_text)

        var username=intent.getStringExtra("user")
        text.text="welcome $username"
    }
}