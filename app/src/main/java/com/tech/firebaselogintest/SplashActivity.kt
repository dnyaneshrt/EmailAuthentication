package com.tech.firebaselogintest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

       var handler=Handler()
        handler.postDelayed(Runnable {
          var intent= Intent(this,LoginActivity::class.java)
            startActivity(intent)
            finish()
        },3000)


    }
}