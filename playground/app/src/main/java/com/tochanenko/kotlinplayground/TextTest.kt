package com.tochanenko.kotlinplayground

import android.annotation.SuppressLint
import android.graphics.Typeface
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.text.Html
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView

class TextTest : AppCompatActivity() {

    lateinit var tv : TextView
    lateinit var strangeText : TextView
    lateinit var button : Button
    lateinit var checkBox : CheckBox
    var boldText : Boolean = false


    @RequiresApi(Build.VERSION_CODES.N)
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_text_test)

        connectViews()

        tv.text = getString(R.string.hello)
        button.setOnClickListener {
            tv.text = "Oh hello There!"
        }

        checkBox.setOnCheckedChangeListener { _, _ ->
            if (boldText) {
                boldText = false
                tv.setTypeface(null, Typeface.NORMAL)
            }
            else {
                boldText = true
                tv.setTypeface(null, Typeface.BOLD)
            }
        }

        strangeText.text = Html.fromHtml("<b>Hello</b> <i>it's me</i>", Html.FROM_HTML_MODE_COMPACT)
    }

    //  Connects Kotlin and XML
    private fun connectViews() {
        tv = findViewById(R.id.helloTextView)
        strangeText = findViewById(R.id.strangeText)
        button = findViewById(R.id.button)
        checkBox = findViewById(R.id.checkBox)
    }
}
