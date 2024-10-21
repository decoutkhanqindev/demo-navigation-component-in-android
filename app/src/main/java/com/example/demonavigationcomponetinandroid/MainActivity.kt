package com.example.demonavigationcomponetinandroid

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.NavGraph
import androidx.navigation.fragment.NavHostFragment
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class MainActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    
    val navHostFragment: NavHostFragment =
      supportFragmentManager.findFragmentById(R.id.myNavHostFragment) as NavHostFragment
    val navController: NavController = navHostFragment.navController
    val navGraph: NavGraph = navController.navInflater.inflate(R.navigation.app_navigation_graph)
    navController.graph = navGraph
    
    navController.currentBackStack
      .onEach {
        it.map {
          Log.d("MainActivity", "currentBackStack: $it")
        }
      }
      .launchIn(lifecycleScope)
  }
}