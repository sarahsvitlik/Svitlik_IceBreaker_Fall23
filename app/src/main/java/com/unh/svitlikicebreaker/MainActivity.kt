package com.unh.svitlikicebreaker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.unh.svitlikicebreaker.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)
    private val TAG = "IcebreakerAndroidF23Tag"

    
    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(TAG, msg:"Entered into OnCreate"
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setContentView(binding.root)

        binding.ButtonGetQuestion.setOnClickListener {
            Log.d(TAG, msg:"Button GetQuestion was pressed")
        }
    }

    override


}

