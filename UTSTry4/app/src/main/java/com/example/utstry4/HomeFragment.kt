package com.example.utstry4

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class HomeFragment : Fragment(R.layout.fragment_home) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val buttonLogin : Button = view.findViewById(R.id.view_profile_button)



        buttonLogin.setOnClickListener(){
            val action = HomeFragmentDirections.actionHomeFragmentToLoginFragment("","","")
            findNavController().navigate(action)
        }
    }
}