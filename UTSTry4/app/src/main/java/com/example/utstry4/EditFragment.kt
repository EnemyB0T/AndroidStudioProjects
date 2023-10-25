package com.example.utstry4

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs

class EditFragment : Fragment(R.layout.fragment_edit) {

    private val args: EditFragmentArgs by navArgs()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //from view
        val genderText : EditText = view.findViewById(R.id.gender_text_edit)
        genderText.setText(args.gender)
        val addressText : EditText = view.findViewById(R.id.address_text_edit)
        addressText.setText(args.address)
        val sexText : EditText = view.findViewById(R.id.sex_text_edit)
        sexText.setText(args.sex)


        val buttonOk : Button = view.findViewById(R.id.edit_profile_button)
        buttonOk.setOnClickListener {
            val sendTextGender = genderText.text.toString()
            val sendTextAddress = addressText.text.toString()
            val sendSexText = sexText.text.toString()


            val action = EditFragmentDirections.actionWelcomeFragmentToLoginFragment(sendTextAddress, sendTextGender, sendSexText)
            findNavController().navigate(action)
        }
    }

}