package com.zicen.jetpackdemo

import android.os.Bundle
import android.text.TextUtils
import android.view.MenuItem

import com.google.android.material.bottomnavigation.BottomNavigationView

import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import com.zicen.jetpackdemo.utils.NavGraphBuilder

class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {
    private lateinit var  navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView = findViewById<BottomNavigationView>(R.id.nav_view)
        navView.setOnNavigationItemSelectedListener(this)

        val fragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment)
        fragment?.let {
            navController = NavHostFragment.findNavController(it)
            NavGraphBuilder.build(this, it.childFragmentManager, navController, fragment.id)
        }
    }

    override fun onNavigationItemSelected(menuItem: MenuItem): Boolean {
        navController.navigate(menuItem.itemId)
        return !TextUtils.isEmpty(menuItem.title)
    }

}
