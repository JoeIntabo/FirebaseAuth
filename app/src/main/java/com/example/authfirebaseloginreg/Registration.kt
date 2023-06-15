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

class Registration : AppCompatActivity() {
    lateinit var Txtgotologin:TextView
    lateinit var edtRegEmail:EditText
    lateinit var edtRegPassword:EditText
    lateinit var edtRegConfirmPassword:EditText
    lateinit var btnReg:Button
    lateinit var auth:FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)
        Txtgotologin=findViewById(R.id.TxtRegtoLog)
        edtRegEmail=findViewById(R.id.edtRegEmail)
        edtRegPassword=findViewById(R.id.edtRegPassword)
        edtRegConfirmPassword=findViewById(R.id.edtRegConfirmPassword)
        btnReg=findViewById(R.id.btn_Reg)
        auth=Firebase.auth

        Txtgotologin.setOnClickListener {
            val intentention=Intent(this,MainActivity::class.java)
            startActivity(intentention)

        }
        btnReg.setOnClickListener {
            Signupuser()


        }
    }
    private fun Signupuser(){
        val email=edtRegEmail.text.toString()
        val password=edtRegPassword.text.toString()
        val confirmpassword=edtRegConfirmPassword.text.toString()

        if (email.isBlank()||password.isBlank()||confirmpassword.isBlank()){
            Toast.makeText(this,"Password and Email can't be blank",Toast.LENGTH_LONG)
            return
        }else if (password!=confirmpassword){
            Toast.makeText(this,"Password do not match",Toast.LENGTH_LONG).show()
        }
        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this) {
            if (it.isSuccessful){
                Toast.makeText(this,"Signed up successfully",Toast.LENGTH_LONG).show()
                finish()
            }else{
                Toast.makeText(this,"Failed to create user",Toast.LENGTH_LONG).show()
            }

        }



    }
}