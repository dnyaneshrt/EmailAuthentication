package com.tech.firebaselogintest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {

    private var et_email: EditText? = null
    private var et_password: EditText? = null

    private var btn_login: Button? = null
    private var txt_register: TextView? = null

    //step 1:get the instance of Firebase authentication
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        firebaseAuth = FirebaseAuth.getInstance()
        init()

        btn_login?.setOnClickListener {

            var email_entered_by_user = et_email?.text.toString()
            var password_entered_by_user = et_password?.text.toString()
            firebaseAuth.signInWithEmailAndPassword(
                email_entered_by_user,
                password_entered_by_user
            ).addOnSuccessListener {
             showToast("user loggedin successfully ")

           et_email?.setText("")
                et_password?.setText("")


                var intent = Intent(this, MainActivity::class.java)
                intent.putExtra("user", email_entered_by_user)
                startActivity(intent)

            }.addOnFailureListener {
              showToast("unable to login ${it.message}")
            }

        }
        txt_register?.setOnClickListener {
            var intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

    }

    private fun init() {
        et_email = findViewById(R.id.editTextTextEmailAddress)
        et_password = findViewById(R.id.editTextTextPassword)
        btn_login = findViewById(R.id.btn_login)
        txt_register = findViewById(R.id.txt_register)
    }
    private fun showToast(message:String)
    {
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show()
    }
}