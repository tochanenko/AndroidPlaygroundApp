package com.tochanenko.kotlinplayground

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    lateinit var textTestButton : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        connectViews()

        textTestButton.setOnClickListener {
            val intent = Intent(this, TextTest::class.java)
            startActivity(intent)
        }

    }

    //  Connects Kotlin and XML
    private fun connectViews() {
        textTestButton = findViewById(R.id.textTestButton)
    }
}
