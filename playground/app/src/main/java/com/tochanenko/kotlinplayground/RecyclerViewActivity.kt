package com.tochanenko.kotlinplayground

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.LinearLayout

class RecyclerViewActivity : AppCompatActivity() {

    lateinit var recyclerViewTest : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)

        connect()

        recyclerViewTest.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)

        val users = ArrayList<UserClass>()
        users.add(UserClass("Serg", "Pidor"))
        users.add(UserClass("Nikita", "TUI lei NIK"))
        users.add(UserClass("Sebeka", "Dostavaka"))
        users.add(UserClass("Zhereb", "Is late angain"))

        var adapter = UserAdapterClass(users)
        recyclerViewTest.adapter = adapter
    }

    //  Connect XML to Kotlin
    fun connect() {
        recyclerViewTest = findViewById(R.id.recyclerViewTest)
    }
}
