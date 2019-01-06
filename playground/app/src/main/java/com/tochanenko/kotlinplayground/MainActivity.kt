package com.tochanenko.kotlinplayground

import android.graphics.Typeface
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var tv : TextView
    lateinit var button : Button
    lateinit var checkBox : CheckBox
    var boldText : Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tv = findViewById(R.id.helloTextView)
        button = findViewById(R.id.button)
        checkBox = findViewById(R.id.checkBox)

        tv.text = getString(R.string.hello)
        button.setOnClickListener {
            tv.text = "Oh hello There!"
        }

        checkBox.setOnCheckedChangeListener { buttonView, isChecked ->
            if (boldText) {
                boldText = false
                tv.setTypeface(null, Typeface.NORMAL)
            }
            else {
                boldText = true
                tv.setTypeface(null, Typeface.BOLD)
            }
        }
    }
}
