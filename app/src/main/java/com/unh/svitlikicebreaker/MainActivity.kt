package com.unh.svitlikicebreaker

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.unh.svitlikicebreaker.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater) //Allows us to grab our files in our view through this binding funnction
    private val TAG = "IcebreakerAndroidF23Tag"
    private var db = Firebase.firestore
    private var questionBank: MutableList<Questions> = arrayListOf()  //an empty list of type questions

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(TAG, "Entered into OnCreate") //start all your code
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setContentView(binding.root)

        //because of binding, we know have access to all functions related to this button
        binding.ButtonGetQuestion.setOnClickListener {//container for actions when getQuestions is pressed
            Log.d(TAG, "Button GetQuestion was pressed")
            binding.txtAnswer.setText("Button was clicked")
            `getQuestions-fromFirebase`()
        }

        //linked ui to code
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
    @SuppressLint("SetTextI18n")
    private fun getQuestionsfromFirebase() {
        Log.d(TAG, "Fetching questions from database")

        db.collection("questions")
            .get()
            .addOnSuccessListener {documents ->      //grab all of documents from database and store them
            questionBank = mutableListOf()
            for(document in documents)  {   //document your searching for in documents
                Log.d(TAG "$(document.id"} =>     ${document.data"})
            }//within the collection class, I have a function get...
    }

}