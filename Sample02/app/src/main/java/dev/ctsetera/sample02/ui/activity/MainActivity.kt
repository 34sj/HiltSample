package dev.ctsetera.sample02.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import dev.ctsetera.sample02.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val toolbar = binding.toolbar
        val navHostFragment = binding.myNavHostFragment

        val navController = supportFragmentManager.findFragmentById(navHostFragment.id) as Fragment
        toolbar.setupWithNavController(navController.findNavController())
    }
}