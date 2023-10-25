package com.example.uts

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class EditFragment : Fragment(R.layout.fragment_details_edit) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val buttonLogin : Button = view.findViewById(R.id.button_edit)
//        buttonLogin.setOnClickListener(){
//            val action = HomeFragmentDirections.actionHomeFragmentToLoginFragment()
//            findNavController().navigate(action)
//        }
    }
}