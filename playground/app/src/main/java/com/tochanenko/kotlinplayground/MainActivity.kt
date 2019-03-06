package com.tochanenko.kotlinplayground

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.content.pm.PackageManager



class MainActivity : AppCompatActivity() {

    private lateinit var list : ListView

    private lateinit var activitiesClass : Array<MainMenuClass>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        connectViews()

        val listItems = arrayOfNulls<MainMenuClass>(activitiesClass.size)

        for (i in 0 until activitiesClass.size)
            listItems[i] = activitiesClass[i]

        val adapter = MainMenuAdapter(this, listItems)
        list.adapter = adapter

        list.setOnItemClickListener { _, _, position, _ ->
            val selectedActivity = activitiesClass[position]

            when (selectedActivity.activityCont) {
                0 -> {
                    val intent = Intent(this, TextTest::class.java)
                    startActivity(intent)
                }
                1 -> {
                    val intent = Intent(this, ViewsActivity::class.java)
                    startActivity(intent)
                }
                2 -> {
                    val intent = Intent(this, RoarActivity::class.java)
                    startActivity(intent)
                }
                3 -> {
                    val intent = Intent(this, MathActivity::class.java)
                    startActivity(intent)
                }
                4 -> {
                    val intent = Intent(this, ListViewActivity::class.java)
                    startActivity(intent)
                }
                5 -> {
                    val uri = Uri.parse("https://github.com/tochanenko/AndroidPlayground/releases")
                    val intent = Intent(Intent.ACTION_VIEW, uri)
                    startActivity(intent)
                }
            }

        }
    }

    //  Connects Kotlin and XML
    private fun connectViews() {
        //  Get current app version:
        var version = ""
        try {
            val pInfo = packageManager.getPackageInfo(packageName, 0)
            version = pInfo.versionName
        } catch (e: PackageManager.NameNotFoundException) {
            e.printStackTrace()
        }


        //  A list of all "buttons" in MainActivity
        list = findViewById(R.id.main_list_view)
        activitiesClass = arrayOf(
            MainMenuClass(0, resources.getString(R.string.text_test),"Tested lots of text"),
            MainMenuClass(1, resources.getString(R.string.views_activity), "A list of different views"),
            MainMenuClass(2, resources.getString(R.string.road_tiger_danger), "ROAR!!! Very dangerous tiger!"),
            MainMenuClass(3, resources.getString(R.string.math_test), "A simple math game:\n${resources.getString(R.string.can_you)}"),
            MainMenuClass(4, resources.getString(R.string.list_view), "My first ever ListView with custom BaseAdapter"),
            MainMenuClass(5, resources.getString(R.string.check_for_updates), "Current version : $version")
        )
    }
}
