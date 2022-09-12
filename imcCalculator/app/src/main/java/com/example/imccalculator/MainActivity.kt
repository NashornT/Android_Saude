package com.example.imccalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val button = findViewById<Button>(R.id.btn_entrar)

        button.setOnClickListener {
            val intent = Intent(this, imcActivity::class.java)
            startActivity(intent)
        }
    }
}