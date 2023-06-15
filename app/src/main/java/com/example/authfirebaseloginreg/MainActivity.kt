package com.example.authfirebaseloginreg

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    lateinit var Txt_gotoregister:TextView
    lateinit var edtLoginEmail: EditText
    lateinit var edtLoginPassword: EditText
    lateinit var btnLogin:Button
    lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Txt_gotoregister=findViewById(R.id.TxtLogtoReg)
        edtLoginPassword=findViewById(R.id.edtLoginPassword)
        edtLoginEmail=findViewById(R.id.edtLoginEmail)
        btnLogin=findViewById(R.id.btn_login)
        auth= FirebaseAuth.getInstance()

        Txt_gotoregister.setOnClickListener {
            val intent=Intent(this,Registration::class.java)
            startActivity(intent)
        }
        btnLogin.setOnClickListener {
            Login()
        }

    }
    private fun Login(){
        val email=edtLoginEmail.text.toString()
        val password=edtLoginPassword.text.toString()
        auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this) {
            if (it.isSuccessful){
                Toast.makeText(this,"Successfully Logged in",Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(this,"Login Failed",Toast.LENGTH_LONG).show()
            }
        }

    }
}