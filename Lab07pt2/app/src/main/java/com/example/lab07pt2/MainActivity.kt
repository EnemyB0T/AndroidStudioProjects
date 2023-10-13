package com.example.lab07pt2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.PopupMenu
import android.widget.PopupMenu.OnMenuItemClickListener
import android.widget.Toast

class MainActivity : AppCompatActivity(), OnMenuItemClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun showPopup(v : View){
        val popup : PopupMenu = PopupMenu(this, v)
        popup.setOnMenuItemClickListener(this)
        popup.inflate(R.menu.menu)
        popup.show()
    }

    override fun onMenuItemClick(p0: MenuItem): Boolean {
        when (p0.itemId) {
            R.id.item1 -> {
                Toast.makeText(this, "Item 1 Clicked", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.item2 -> {
                Toast.makeText(this, "Item 2 Clicked", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.item3 -> {
                Toast.makeText(this, "Item 3 Clicked", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.item4 -> {
                Toast.makeText(this, "Item 4 Clicked", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.item5 -> {
                Toast.makeText(this, "Item 5 Clicked", Toast.LENGTH_SHORT).show()
                return true
            }
            else -> {return false}
        }
    }
}