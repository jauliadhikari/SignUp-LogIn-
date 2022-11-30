package com.example.loginpractice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import android.widget.Toast.*
import com.google.firebase.auth.FirebaseAuth

lateinit var  auth: FirebaseAuth

class SignUp : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        var email: EditText = findViewById(R.id.email)

        var pass1: EditText = findViewById(R.id.pass1)

        var pass2: EditText = findViewById(R.id.pass2)

        var but1: Button = findViewById(R.id.button)

        var but2: Button = findViewById(R.id.button2)

        auth = FirebaseAuth.getInstance()

        but1.setOnClickListener{

            val e  = email.text.toString()
            val p1 = pass1.text.toString()
            val p2 = pass2.text.toString()
            if(e.isNotEmpty() && p1.isNotEmpty() && p2.isNotEmpty())
            {
                 if(p1==p2)
                 {

                     auth.createUserWithEmailAndPassword(e,p1).addOnCompleteListener {

                         if(it.isSuccessful)
                         {
                             val intent = Intent(this,LogIn ::class.java)
                             startActivity(intent)
                         }else
                         {
                             Toast.makeText(this, "not successful", Toast.LENGTH_SHORT).show()
                         }
                     }
                 }
                else
                 {
                     Toast.makeText(this, "different pass", Toast.LENGTH_SHORT).show()
                 }
            }
            else
            {
                Toast.makeText(this, "Bhai kuch to Bhar", LENGTH_SHORT).show()
            }

        }
    }
}