package com.example.lab05

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button: Button = findViewById(R.id.apply1)
        button.setOnClickListener(){
            var i = Intent(this, MainActivity2::class.java)
            startActivity(i)
        }

    }
}