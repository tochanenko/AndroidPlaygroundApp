package com.tochanenko.kotlinplayground

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar

class ViewsActivity : AppCompatActivity() {

    lateinit var seekBar : SeekBar
    lateinit var seekBarDiscrete : SeekBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_views)

        connectViews()
    }

    //  Connects Kotlin and XML
    private fun connectViews() {
        seekBar = findViewById(R.id.seekBar)
        seekBarDiscrete = findViewById(R.id.seekBarDiscrete)
    }
}
