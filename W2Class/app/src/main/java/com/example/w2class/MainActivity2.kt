package com.example.w2class

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {

    lateinit var responseText : String

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val username = intent.getStringExtra("userName")
        val userPicture = intent.getStringExtra("userPicture")
        val usernameNotification : TextView = findViewById(R.id.usernameNotification)
        if(userPicture != "") {
            val pp : ImageView = findViewById(R.id.profilePicture)
            val resourcePath = resources.getIdentifier(userPicture, "drawable", this.packageName)
            pp.setImageResource(resourcePath)
        }


        usernameNotification.text = "Welcome, $username!"
        val backButton : Button = findViewById(R.id.backButton)
        backButton.setOnClickListener{
            val response : EditText = findViewById(R.id.responseText)
            responseText = response.text.toString()
            openFrontPage()
        }
    }
    private fun openFrontPage() {
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra("responseText", responseText)
        startActivity(intent)
    }
}

