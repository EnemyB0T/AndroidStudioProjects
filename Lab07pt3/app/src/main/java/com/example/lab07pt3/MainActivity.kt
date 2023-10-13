package com.example.lab07pt3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val textView : TextView = findViewById(R.id.maintext)
        registerForContextMenu(textView)
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)

        menuInflater.inflate(R.menu.example_menu, menu)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.item1 -> {
                Toast.makeText(this, "Item 1 selected", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.item2 -> {
                Toast.makeText(this, "Item 2 selected", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.item3 -> {
                Toast.makeText(this, "Item 3 selected", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.item4 -> {
                Toast.makeText(this, "Item 4 selected", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.item5 -> {
                Toast.makeText(this, "Item 5 selected", Toast.LENGTH_SHORT).show()
                return true
            }
            else -> { return super.onContextItemSelected(item) }
        }

    }
}