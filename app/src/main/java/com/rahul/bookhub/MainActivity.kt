package com.rahul.bookhub

import android.content.ClipData
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.FrameLayout
import android.widget.Toast
import android.widget.Toolbar
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    lateinit var drawerLayout: DrawerLayout
    lateinit var coordLayout: CoordinatorLayout
    lateinit var toolbar: androidx.appcompat.widget.Toolbar
    lateinit var frameLayout: FrameLayout
    lateinit var navigationView: NavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        drawerLayout = findViewById(R.id.drawerlayout)
        coordLayout = findViewById(R.id.coordlayout)
        toolbar = findViewById(R.id.toolbar)
        frameLayout = findViewById(R.id.framelayout)
        navigationView = findViewById(R.id.navview)
        toolname()
        val actiontoggle = ActionBarDrawerToggle(
            this@MainActivity, drawerLayout,
            R.string.open_drawer, R.string.close_drawer
        )
        drawerLayout.addDrawerListener(actiontoggle)
        actiontoggle.syncState()
        navigationView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.dash ->
                {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.framelayout,DashboardFragment())
                        .commit()
                    drawerLayout.closeDrawers()
                }
                R.id.fav ->
                {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.framelayout,FavouritesFragment())
                        .commit()
                    drawerLayout.closeDrawers()
                }
                R.id.prof ->
                {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.framelayout,ProfileFragment())
                        .commit()
                    drawerLayout.closeDrawers()
                }
                R.id.about ->
                {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.framelayout,AboutFragment())
                        .commit()
                    drawerLayout.closeDrawers()
                }

            }
            return@setNavigationItemSelectedListener true

        }
    }

    fun toolname() {
        setSupportActionBar(toolbar)
        supportActionBar?.title = "Book Hub"
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == android.R.id.home) {
            drawerLayout.openDrawer(GravityCompat.START)
        }
        return super.onOptionsItemSelected(item)
    }
}