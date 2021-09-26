package com.example.recyclerviewapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    lateinit var clMain: ConstraintLayout
    lateinit var editText : EditText
    lateinit var my_rv: RecyclerView
    lateinit var texts: ArrayList<String>
    lateinit var myButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        texts = ArrayList()
        clMain = findViewById(R.id.clMain)
        my_rv = findViewById(R.id.rvMain)
        my_rv.adapter = RecyclerViewAdapter(this,texts)
        my_rv.layoutManager = LinearLayoutManager(this)

        editText = findViewById(R.id.editText)

        myButton = findViewById<Button>(R.id.button)
        myButton.setOnClickListener { myFuction() }
    }

    fun myFuction(){
        if(editText.text.toString() == "")
            Snackbar.make(clMain,"You should Enter data", Snackbar.LENGTH_LONG).show()
        else{
            texts.add(editText.text.toString())
            editText.text.clear()
        }
    }
}