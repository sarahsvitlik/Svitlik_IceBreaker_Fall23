package com.unh.svitlikicebreaker

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.unh.svitlikicebreaker.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val TAG = "IcebreakerAndroidF23Tag"
    private var db = Firebase.firestore
    private var questionBank: MutableList<Questions>? = arrayListOf()  //an empty list of type questions

    override fun onCreate(savedInstanceState: Bundle?) {

        val binding: ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater) //Allows us to grab our files in our view through this binding funnction
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setContentView(binding.root)

        getQuestionsFromFirebase()


        //because of binding, we know have access to all functions related to this button
        binding.ButtonGetQuestion.setOnClickListener {//container for actions when getQuestions is pressed
            Log.d(TAG, "Button GetQuestion was pressed")
            binding.txtQuestion.text = questionBank?.random().toString()
        }

        //linked ui to code
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
    private fun getQuestionsFromFirebase() {
        Log.d(TAG, "Fetching questions from database")

        db.collection("Questions")
            .get()
            .addOnSuccessListener { documents ->      //grab all of documents from database and store them
                questionBank = mutableListOf()
                for (document in documents) {   //document your searching for in documents
                    Log.d(TAG, "${document.id} => ${document.data}")
                    val question = document.toObject(Questions::class.java)  //extract text and save it into a variable ... if this exists it can store in class to be used
                    questionBank?.add(question) ?: "Empty Database"
                }//within the collection class, I have a function get...
            }

            .addOnFailureListener { exception ->
                Log.w(TAG, "Error in getting documents", exception)
            }

    }
}