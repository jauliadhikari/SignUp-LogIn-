package com.example.loginpractice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth


class LogIn : AppCompatActivity() {

    lateinit var authh: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)

        var em: EditText = findViewById(R.id.EmailAddress1)

        var p : EditText =findViewById(R.id.Password)

        var bb : Button =findViewById(R.id.button3)

        authh = FirebaseAuth.getInstance()

        bb.setOnClickListener {
            val e =em.text.toString()
            val pp = p.text.toString()

            authh.signInWithEmailAndPassword(e,pp).addOnCompleteListener {

                if(it.isSuccessful)
                {
                    val intent = Intent(this,MainActivity ::class.java)
                    startActivity(intent)
                }
                else
                {
                    Toast.makeText(this, "not successful login", Toast.LENGTH_SHORT).show()
                }
            }


        }


    }
}