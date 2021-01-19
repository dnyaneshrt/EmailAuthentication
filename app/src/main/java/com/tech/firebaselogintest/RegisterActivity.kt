package com.tech.firebaselogintest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class RegisterActivity : AppCompatActivity() {

  private  var et_email:EditText?=null
  private  var et_password:EditText?=null

   private var btn_register: Button?=null
   private var txt_login: TextView?=null

    //step 1:get the instance of Firebase authentication
  private lateinit var firebaseAuth:FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        //step 2:initialize the firebase instance.

        firebaseAuth= FirebaseAuth.getInstance()
        init()

        btn_register?.setOnClickListener {
            var email=et_email?.text.toString()
            var password=et_password?.text.toString()

            firebaseAuth.createUserWithEmailAndPassword(email,password)
                .addOnSuccessListener {
                    showToast("user registered successfully")
                    moveToLoginActivity()

                }.addOnFailureListener{
                    showToast(it.message.toString())
                }

        }

        txt_login?.setOnClickListener {
            moveToLoginActivity()
        }
    }

    private fun moveToLoginActivity() {
       startActivity(Intent(this,LoginActivity::class.java))
    }

    private fun init() {
       et_email=findViewById(R.id.editTextTextEmailAddress_register)
        et_password=findViewById(R.id.editTextTextPassword_register)
        btn_register=findViewById(R.id.btn_register)
        txt_login=findViewById(R.id.txt_login)
    }

  private fun showToast(message:String)
    {
       Toast.makeText(this,message,Toast.LENGTH_SHORT).show()
    }
}