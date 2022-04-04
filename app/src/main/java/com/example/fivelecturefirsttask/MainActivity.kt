package com.example.fivelecturefirsttask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        title = "Five Lecture Task 1"

        if (savedInstanceState == null) {
            addFragmentSender()
        }

    }

    private fun addFragmentSender() {
        supportFragmentManager.beginTransaction().add(R.id.fragment_container, SenderFragment()).commit()
    }
}