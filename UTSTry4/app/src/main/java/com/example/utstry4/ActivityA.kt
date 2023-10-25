package com.example.utstry4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class ActivityA : AppCompatActivity(), View.OnClickListener {

    lateinit var result: TextView

    //Data of each users

    val userList = mutableListOf<String>("ABC", "DEF", "GHI", "JKL", "Jesus")

    val passList = mutableListOf<String>("abc", "def", "ghi", "jkl", "rampen")

    val picList = mutableListOf<String>("", "", "", "", "jesus")

    var addressList = mutableListOf<String>("", "", "", "", "")

    var genderList = mutableListOf<String>("", "", "", "", "")

    var sexList = mutableListOf<String>("", "", "", "", "")


    lateinit var loggedInUserName : String
    lateinit var loggedInUserPic : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_activity)

        val response : TextView = findViewById(R.id.response)
        val intentResponse = intent.getStringExtra("responseText")
        response.text = intentResponse


        val button: Button = findViewById(R.id.supabutton)
        button.setOnClickListener {
            var match: Boolean = false
            val usernameInput : EditText = findViewById(R.id.usernameInput)
            val user = usernameInput.text.toString()
            val passwordInput : EditText = findViewById(R.id.passwordInput)
            val pass = passwordInput.text.toString()
            val notificationText : TextView = findViewById(R.id.notificationText)
            for(i in userList)
            {
                if (i == user)
                {
                    match = true
                    loggedInUserName = i
                    break
                }
            }
            var found = false
            if(match) {
                for (i in 0..passList.size-1) {
                    if (passList[i] == pass) {
                        loggedInUserPic = picList[i]
                        openLoginPage()
                        found = true
                        break
                    }
                }
                if(!found)
                    match = false

            }
            if(!match) {
                Toast.makeText(this, "The user and password is not right", Toast.LENGTH_SHORT).show()
            }
        }

        val clearButton : Button = findViewById(R.id.clear_button)
        clearButton.setOnClickListener{
            val usernameInput : EditText = findViewById(R.id.usernameInput)
            usernameInput.text.clear()
            val passwordInput : EditText = findViewById(R.id.passwordInput)
            passwordInput.text.clear()
        }


    }

    private fun openLoginPage() {
        val intent = Intent(this, ActivityB::class.java)
        intent.putExtra("userName", loggedInUserName)
        intent.putExtra("userPicture", loggedInUserPic)
        startActivity(intent)
    }

    override fun onClick(p0: View?) {
        TODO("Not yet implemented")
    }
}

class Student(val id: String)
{
    lateinit var records: HashSet<Any>
    init {
        //retrieve records given an id
    }
}