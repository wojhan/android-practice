package com.github.wojhan.ex1

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.widget.TextView

class SummaryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_summary)

        val details = intent.getStringArrayExtra(EXTRA_MESSAGE)

        val meal_textView = findViewById<TextView>(R.id.summary_meal_textView).apply {
            text = "Burger: " + details[0]
        }

        val sauce_textView = findViewById<TextView>(R.id.summary_sauce_textView).apply {
            text = "Sos: " + details[1]
        }

        val additionanal_TextView = findViewById<TextView>(R.id.summary_additionalInfo).apply{
            text = details[2]
        }
    }
}
