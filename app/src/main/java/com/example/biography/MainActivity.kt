package com.example.biography

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.biography.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //initializing binding object in activities : instantiated on onCreate
    private lateinit var binding : ActivityMainBinding

    //creating an instance of the data class and set the name
    private val myName:MyName = MyName("Janet Mutua")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //instantiating the binding variable and setting the content view
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        //setting the value of the myName variable that is declates and used in the layout file
        binding.myName = myName

        binding.doneButton.setOnClickListener{
            addNickname(it)
        }

    }

    private fun addNickname(view:View) {

        //assign the user input for nickname to the nickname text view
        // using Kotlin's .apply to make the code easier to read

        binding.apply {
            //binding.nicknameText.text = binding.nicknameName.text
            myName?.nickname = nicknameName.text.toString()
            //refresh the UI with the new data ; all binding expressions will be recreated with the correct binding data
            invalidateAll()
            //changing visibility by removing the editText view and the done button
            nicknameName.visibility = View.GONE
            doneButton.visibility = View.GONE

            nicknameText.visibility = View.VISIBLE
        }


        //Hiding the keyboard

        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)


    }
}