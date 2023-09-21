package com.unh.svitlikicebreaker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.unh.svitlikicebreaker.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater) //Allows us to grab our files in our view through this binding funnction
    private val TAG = "IcebreakerAndroidF23Tag"

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(TAG, "Entered into OnCreate") //start all your code
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setContentView(binding.root)

        //because of binding, we know have access to all functions related to this button
        binding.ButtonGetQuestion.setOnClickListener {//container for actions when getQuestions is pressed
            Log.d(TAG, "Button GetQuestion was pressed")
            binding.txtAnswer.setText("Button was clicked")
            getQuestionsfromFirebase()
        }

        //links value
        binding.ButtonSubmit.setOnClickListener {//container for actions when submit is pressed
         Log.d(TAG, "Submit button was pressed.")
            val lastname = binding.txtLastName
            val pname = binding.preferredName
            val answer = binding.txtAnswer
            val firstName = binding.txtFirstName

            Log.d(TAG, "First name is ${firstName.text}, ${pname.text}, ${answer.text}")
            binding.txtAnswer.setText("${firstName.text}!")
            firstName.setText("")
        }
    }
        override fun onDestroy() {
            super.onDestroy()
        }

    //make private to protect the firebase questions
    private fun getQuestionsfromFirebase() {
        Log.d(TAG, "Fetching questions from databse")
        binding.txtAnswer.setText("Doing Database stuff")
    }

}