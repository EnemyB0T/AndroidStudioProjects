package com.example.lab07pt4

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs

class LoginFragment : Fragment(R.layout.fragment_login) {

    private val args: LoginFragmentArgs by navArgs()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val usernameDeepLink = args.username
        val usernameVal : EditText = view.findViewById(R.id.edit_text_username)
        usernameVal.setText(usernameDeepLink) //use setText because it supports null

        val loginButton : Button = view.findViewById(R.id.button_confirm)
        loginButton.setOnClickListener() {

            val passwordVal : EditText = view.findViewById(R.id.edit_text_password)
            val username = usernameVal.text.toString()
            val password = passwordVal.text.toString()

            val action = LoginFragmentDirections.actionLoginFragmentToWelcomeFragment(username, password)
            findNavController().navigate(action)
        }
    }
}