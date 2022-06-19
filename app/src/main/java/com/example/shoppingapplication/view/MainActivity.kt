package com.example.shoppingapplication.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.shoppingapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
       binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        super.onCreate(savedInstanceState)

    }
}