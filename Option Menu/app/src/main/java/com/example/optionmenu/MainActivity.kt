package com.example.optionmenu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.example_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.item1 -> Toast.makeText(this, "Item 1 Selected", Toast.LENGTH_SHORT).show()
            R.id.item2 -> Toast.makeText(this, "Item 2 Selected", Toast.LENGTH_SHORT).show()
            R.id.item3 -> Toast.makeText(this, "Item 3 Selected", Toast.LENGTH_SHORT).show()
            R.id.subitem1 -> Toast.makeText(this, "Sub Item 1 Selected", Toast.LENGTH_SHORT).show()
            R.id.subitem2 -> Toast.makeText(this, "Sub Item 2 Selected", Toast.LENGTH_SHORT).show()
        }
        return super.onOptionsItemSelected(item)
    }
}