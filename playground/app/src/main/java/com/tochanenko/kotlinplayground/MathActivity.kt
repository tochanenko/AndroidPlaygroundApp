package com.tochanenko.kotlinplayground

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlin.random.Random
import android.view.KeyEvent.KEYCODE_ENTER
import android.view.View
import android.view.inputmethod.EditorInfo


class MathActivity : AppCompatActivity() {

    lateinit var mathActivityInputField : EditText
    lateinit var mathActivityPrimeNumber : Button
    lateinit var mathActivityNumber : TextView
    lateinit var mathActivitySubmit : Button

    var number : Long = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_math)

        connectViews()
        generateNumber()
        updateViews()

        mathActivityPrimeNumber.setOnClickListener {
            if (testForPrime(number)) {
                val intent = Intent(this, WellDoneActivity::class.java)
                startActivity(intent)
            }
            else {
                Toast.makeText(this, "Try more!", Toast.LENGTH_SHORT).show()
                updateViews()
            }
        }

        mathActivitySubmit.setOnClickListener {
            handleNumber()
        }

        mathActivityInputField.setOnEditorActionListener() { v, actionId, event ->
            if(actionId == EditorInfo.IME_ACTION_DONE){
                handleNumber()
                true
            } else {
                false
            }
        }
    }

    private fun handleNumber() {
        val str : String = mathActivityInputField.text.toString()
        val selectedNumber : Long
        var wrongNumber = false
        if (str == "")
            wrongNumber = true
        else {
            selectedNumber = str.toLong()
            if ((selectedNumber == 1.toLong()) || (selectedNumber == number)) {
                Toast.makeText(this, "LOL! You can't fool me!", Toast.LENGTH_SHORT).show()
                wrongNumber = true
            }
            else if ((selectedNumber in 2..(number - 1)) && (number % selectedNumber == 0.toLong()))
                number /= selectedNumber
            else
                wrongNumber = true
        }
        if (wrongNumber)
            Toast.makeText(this, "Wrong number!", Toast.LENGTH_SHORT).show()
        updateViews()
    }

    private fun generateNumber() {
        val random = Random(System.currentTimeMillis())
        val numberOfDividers : Int = random.nextInt(3, 10)
        for (i in 1..numberOfDividers) {
            var randomNumber = random.nextInt(2, 20).toLong()
            while (!testForPrime(randomNumber))
                randomNumber = random.nextInt(2, 20).toLong()
            number *= randomNumber
        }
    }

    //  Update all existing views to math content
    private fun updateViews() {
        mathActivityNumber.text = number.toString()
        mathActivityInputField.setText("")
    }

    //  Check if number is prime
    private fun testForPrime(num : Long) : Boolean {
        for (i in 2..(Math.sqrt(num.toDouble()).toInt())) {
            if (num % i == 0.toLong())
                return false
        }
        return true
    }

    //  Connects Kotlin and XML
    private fun connectViews() {
        mathActivityInputField = findViewById(R.id.mathActivityInputField)
        mathActivityNumber = findViewById(R.id.mathActivityNumber)
        mathActivityPrimeNumber = findViewById(R.id.mathActivityPrimeNumber)
        mathActivitySubmit = findViewById(R.id.mathActivitySubmit)
    }

}
