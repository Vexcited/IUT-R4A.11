package com.vexcited.myhelloworld

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

const val EXTRA_TEXT = "text_to_display"

class MainActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContentView(R.layout.activity_main)
    ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
      val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
      v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
      insets
    }

    val premierBouton: Button = findViewById(R.id.validateButton)
    val saisie: EditText = findViewById(R.id.editText)
    var textView: TextView = findViewById(R.id.textView)

    premierBouton.setOnClickListener {
      if (saisie.text.contains("afficher nouveau textView")) {
        val layoutPrincipal: ConstraintLayout = findViewById(R.id.main)
        textView = TextView(this)
        layoutPrincipal.addView(textView)
      }

      textView.text = saisie.text
    }

    val prochainBouton: Button = findViewById(R.id.nextButton)
    prochainBouton.setOnClickListener {
      val intent = Intent(this@MainActivity, MainActivity2::class.java)
      intent.putExtra(EXTRA_TEXT, textView.text.toString())
      startActivity(intent)
    }
  }
}