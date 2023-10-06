package com.example.lab05

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val button: Button = findViewById(R.id.apply2)
        button.setOnClickListener(){
            var i = Intent(this, MainActivity3::class.java)
            startActivity(i)
        }
    }
}