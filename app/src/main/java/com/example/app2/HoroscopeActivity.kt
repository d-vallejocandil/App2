package com.example.app2

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class HoroscopeActivity : AppCompatActivity() {
    lateinit var name: TextView
    lateinit var dates: TextView
    lateinit var icon: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_horoscope)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val id = intent.getStringExtra("HOROSCOPE")!!
        val horoscope = Horoscope.getById(id)
        name = findViewById(R.id.name)
        dates = findViewById(R.id.dates)
        icon = findViewById(R.id.icon)
        name.setText(horoscope.name)
        dates.setText(horoscope.dates)
        icon.setImageResource(horoscope.icon)
        supportActionBar?.title = getString(horoscope.name)
        supportActionBar?.setDefaultDisplayHomeAsUpEnabled(true)
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.activity_horoscope, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if (item.itemId == R.id.favorite) {

            return true
        } else if (item.itemId == R.id.share) {

            return true
        } else if (item.itemId == android.R.id.home) {
            finish()
            return true
        } else {
            return super.onOptionsItemSelected(item)
        }
    }
}