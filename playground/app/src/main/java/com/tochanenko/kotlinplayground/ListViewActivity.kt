package com.tochanenko.kotlinplayground

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class ListViewActivity : AppCompatActivity() {

    private lateinit var listView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)

        connectViews()

        val array: Array<LinkClass> = arrayOf(
                LinkClass("Github", "GitHub is a web-based hosting service for version control using Git. It is mostly used for computer code. It offers all of the distributed version control and source code management (SCM) functionality of Git as well as adding its own features.","https://github.com/"),
                LinkClass("Visual Studio Code", "Visual Studio Code is a source code editor developed by Microsoft for Windows, Linux and macOS. It includes support for debugging, embedded Git control, syntax highlighting, intelligent code completion, snippets, and code refactoring. It is also customizable, so users can change the editor's theme, keyboard shortcuts, and preferences. The source code is free and open source and released under the permissive MIT License. The compiled binaries are freeware and free for private or commercial use","https://code.visualstudio.com/"),
                LinkClass("Kotlin", "Kotlin is a cross-platform, statically typed, general-purpose programming language with type inference. Kotlin is designed to interoperate fully with Java, and the JVM version of its standard library depends on the Java Class Library, but type inference allows its syntax to be more concise. Kotlin mainly targets the JVM, but also compiles to JavaScript or native code (via LLVM). Kotlin is sponsored by JetBrains and Google through the Kotlin Foundation","https://kotlinlang.org/"),
                LinkClass("Android", "Android is a mobile operating system developed by Google. It is based on a modified version of the Linux kernel and other open source software, and is designed primarily for touchscreen mobile devices such as smartphones and tablets. In addition, Google has further developed Android TV for televisions, Android Auto for cars, and Wear OS for wrist watches, each with a specialized user interface. Variants of Android are also used on game consoles, digital cameras, PCs and other electronics","https://www.android.com/"),
                LinkClass("Android Developers", "The official site for Android app developers. Provides the Android SDK tools and API documentation","https://developer.android.com/"),
                LinkClass("Google Codelabs", "Google Developers Codelabs provide a guided, tutorial, hands-on coding experience. Most codelabs will step you through the process of building a small application, or adding a new feature to an existing application. They cover a wide range of topics such as Android Wear, Google Compute Engine, Project Tango, and Google APIs on iOS","https://codelabs.developers.google.com/?cat=Android"),
                LinkClass("Android NANODEGREE PROGRAM", "Start your career as an Android developer. Learn best practices for mobile development, build a portfolio of apps, and publish your own app to Google Play","https://www.udacity.com/course/android-developer-nanodegree-by-google--nd801"),
                LinkClass("Material.io Design", "Create intuitive and beautiful products with Material Design","https://material.io/design/"))

        val listItems = arrayOfNulls<LinkClass>(array.size)

        for (i in 0 until array.size)
            listItems[i] = array[i]

        val adapter = ListActivityAdapter(this, listItems)
        listView.adapter = adapter
    }

    //  Connects Kotlin and XML
    private fun connectViews() {
        listView = findViewById(R.id.list_view)
    }
}
