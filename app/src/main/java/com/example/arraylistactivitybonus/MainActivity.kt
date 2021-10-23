package com.example.arraylistactivitybonus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    lateinit var et1: EditText
    lateinit var et2: EditText
    lateinit var button: Button
    lateinit var button2: Button
    lateinit var tv: TextView
    lateinit var names: ArrayList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        names = arrayListOf()
        et1 = findViewById(R.id.et1)
        et2 = findViewById(R.id.et2)
        button = findViewById(R.id.button)
        button2 = findViewById(R.id.button2)
        tv = findViewById(R.id.tv)

        button.setOnClickListener { // Hide Keyboard
            val imm = ContextCompat.getSystemService(this, InputMethodManager::class.java)
            imm?.hideSoftInputFromWindow(this.currentFocus?.windowToken, 0)
            names.add(et1.text.toString())
            Toast.makeText(this@MainActivity, "${et1.text} added", Toast.LENGTH_SHORT).show()
            et1.text.clear()
        }

        button2.setOnClickListener{// Hide Keyboard
            val imm = ContextCompat.getSystemService(this, InputMethodManager::class.java)
            imm?.hideSoftInputFromWindow(this.currentFocus?.windowToken, 0)
            tv.setText("")
            if (et2.text.toString().toInt() <= names.size)
             {if (et2.text.toString().toInt() == 0){}
             else
             tv.text = """${et2.text}: ${names[(et2.text.toString().toInt())-1]}"""}
            else
                Toast.makeText(this@MainActivity, "the position (${et2.text}) you entered is out of range", Toast.LENGTH_LONG).show()
            et2.text.clear()
        }

    }
}