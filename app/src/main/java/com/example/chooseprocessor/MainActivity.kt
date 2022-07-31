package com.example.chooseprocessor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var flag: String
        val spinnerVal: Spinner = findViewById(R.id.spinnerV)
        var options = arrayOf("Intel", "Amd")
        spinnerVal.adapter =
            ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, options)

        spinnerVal.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                flag = options.get(p2) //p2 is the index of selected item
                if (flag == "Intel") {
                    var dialog_var = IntelFragment()
                    dialog_var.show(supportFragmentManager, "Intel Dialog")

                } else {
                    var dialog_var = RyzenFragment()
                    dialog_var.show(supportFragmentManager, "Amd Dialog")
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_active, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.home -> Toast.makeText(this, "Home page selected", Toast.LENGTH_SHORT).show()
            R.id.contact -> Toast.makeText(this, "Contact page selected", Toast.LENGTH_SHORT).show()
            R.id.info -> Toast.makeText(this, "Info page selected", Toast.LENGTH_SHORT).show()
        }
        return true;
    }

    fun receiveFeedback(feedback: String){
        val ratingTV : TextView = findViewById(R.id.TVrating)
        ratingTV.text = feedback;

    }
}