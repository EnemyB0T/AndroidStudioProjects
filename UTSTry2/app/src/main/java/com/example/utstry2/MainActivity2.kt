package com.example.utstry2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.onNavDestinationSelected
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

class MainActivity2 : AppCompatActivity() {

//    lateinit var responseText : String

    private lateinit var navController : NavController
    private lateinit var appBarConfiguration: AppBarConfiguration
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val username = intent.getStringExtra("userName")
        val userPicture = intent.getStringExtra("userPicture")
//        val usernameNotification : TextView = findViewById(R.id.usernameNotification)
//        if(userPicture != "") {
//            val pp : ImageView = findViewById(R.id.profilePicture)
//            val resourcePath = resources.getIdentifier(userPicture, "drawable", this.packageName)
//            pp.setImageResource(resourcePath)
//        }

//        usernameNotification.text = "Welcome, $username!

//        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
//        navController = navHostFragment.findNavController()
//
//        appBarConfiguration = AppBarConfiguration(
//            setOf(R.id.homeFragment, R.id.editFragment),
//            findViewById(R.id.drawer_layout)
//        )

//        setSupportActionBar(findViewById(R.id.toolbar))
//        setupActionBarWithNavController(navController, appBarConfiguration)

//        val bottomNav : BottomNavigationView = findViewById(R.id.bottom_nav)
//        bottomNav.setupWithNavController(navController)

//        val navView : NavigationView = findViewById(R.id.nav_view)
//        navView.setupWithNavController(navController)
    }
//    private fun openFrontPage() {
//        val intent = Intent(this, MainActivity::class.java)
//        intent.putExtra("responseText", responseText)
//        startActivity(intent)
//    }

//    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//        menuInflater.inflate(R.menu.options_menu, menu)
//        return true
//    }
//
//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        return if (item.itemId == R.id.termsAndConditions) {
//            val action = NavGraphDirections.actionGlobalTermsFragment()
//            navController.navigate(action)
//            true
//        } else {
//            item.onNavDestinationSelected(navController) || super.onOptionsItemSelected(item)
//        }
//    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}

