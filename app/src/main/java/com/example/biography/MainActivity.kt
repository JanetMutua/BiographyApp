package com.example.biography

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.done_button).setOnClickListener{
            addNickname(it)
        }

    }

    private fun addNickname(view:View) {
        //input text that prompts user to enter their nickname
        val editText = findViewById<EditText>(R.id.nickname_name)
        // display text view for the nickname
        val nicknameTextView = findViewById<TextView>(R.id.nickname_text)

        //assign the user input for nickname to the nickname text view
        nicknameTextView.text = editText.text

        //changing visibility by removing the editText view and the done button
        editText.visibility = View.GONE
        view.visibility = View.GONE

        nicknameTextView.visibility = View.VISIBLE

        //Hiding the keyboard

        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)


    }
}