package com.tochanenko.kotlinplayground

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    lateinit var buttonTextTest : Button
    lateinit var buttonViewsActivity: Button
    lateinit var buttonRoarActivity: Button
    lateinit var buttonMathTest : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        connectViews()

        buttonTextTest.setOnClickListener {
            val intent = Intent(this, TextTest::class.java)
            startActivity(intent)
        }

        buttonViewsActivity.setOnClickListener {
            val intent = Intent(this, ViewsActivity::class.java)
            startActivity(intent)
        }

        buttonRoarActivity.setOnClickListener {
            val intent = Intent(this, RoarActivity::class.java)
            startActivity(intent)
        }

        buttonMathTest.setOnClickListener {
            val intent = Intent(this, MathActivity::class.java)
            startActivity(intent)
        }

    }

    //  Connects Kotlin and XML
    private fun connectViews() {
        buttonTextTest = findViewById(R.id.buttonTextTest)
        buttonViewsActivity = findViewById(R.id.buttonViewsActivity)
        buttonRoarActivity = findViewById(R.id.buttonRoarActivity)
        buttonMathTest = findViewById(R.id.buttonMathTest)
    }
}
