package com.tochanenko.kotlinplayground

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var tv : TextView
    lateinit var button : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tv = findViewById(R.id.helloTextView)
        button = findViewById(R.id.button)

        tv.text = getString(R.string.hello)
        button.setOnClickListener {
            tv.text = "Oh hello There!"
        }
    }
}
