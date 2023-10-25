package com.example.utstry4

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs

class ViewFragment : Fragment(R.layout.fragment_view) {

    private val args: ViewFragmentArgs by navArgs()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //from edit
        val genderText : TextView = view.findViewById(R.id.gender_text_editted)
        genderText.text = args.gender
        val addressText : TextView = view.findViewById(R.id.address_text_editted)
        addressText.text = args.address
        val sexText : TextView = view.findViewById(R.id.sex_text_editted)
        sexText.text = args.sex

        val editButton : Button = view.findViewById(R.id.edit_profile_button)
        editButton.setOnClickListener() {

            val sendTextGender = genderText.text.toString()
            val sendTextAddress = addressText.text.toString()
            val sendTextSex = sexText.text.toString()

            val action = ViewFragmentDirections.actionLoginFragmentToWelcomeFragment()
            findNavController().navigate(action)
        }
    }
}