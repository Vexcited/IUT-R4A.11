package com.vexcited.myhelloworld

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity2 : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContentView(R.layout.activity_main2)
    ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main2)) { v, insets ->
      val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
      v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
      insets
    }

    val intent = intent
    intent.getStringExtra(EXTRA_TEXT)?.let {
      findViewById<TextView>(R.id.textView2).text = it
    }

    val previousButton = findViewById<TextView>(R.id.previousButton)
    previousButton.setOnClickListener {
      finish()
    }
  }
}