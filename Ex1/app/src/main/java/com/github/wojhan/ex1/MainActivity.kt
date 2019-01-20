package com.github.wojhan.ex1

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {

    var sauce : String = "Bez sosu"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val spinner: Spinner = findViewById(R.id.meal_spinner)
        ArrayAdapter.createFromResource(
                this,
                R.array.meal_choice_array,
                android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }
    }

    fun order(view : View){
        val mealDetails = arrayOf(
                findViewById<Spinner>(R.id.meal_spinner).selectedItem.toString(),
                sauce,
                findViewById<EditText>(R.id.additionalInfo).text.toString())
        val intent = Intent(this, SummaryActivity::class.java).apply{
            putExtra(EXTRA_MESSAGE, mealDetails)
        }
        startActivity(intent)
    }

    fun sauceClicked(view: View){
        if(view is RadioButton) {
            val checked = view.isChecked

            sauce = view.text.toString()
        }
    }
}
