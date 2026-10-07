package com.example.app2

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.bottomnavigation.BottomNavigationView

class HoroscopeActivity : AppCompatActivity() {
    lateinit var name: TextView
    lateinit var dates: TextView
    lateinit var icon: ImageView
    lateinit var session: Session
    var compare: Boolean = false
    lateinit var horoscope: Horoscope
    lateinit var favorite: MenuItem
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_horoscope)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        session = Session(this)
        val id = intent.getStringExtra("HOROSCOPE")!!
        compare = session.compare(id)
        horoscope = Horoscope.getById(id)
        name = findViewById(R.id.name)
        dates = findViewById(R.id.dates)
        icon = findViewById(R.id.icon)
        name.setText(horoscope.name)
        dates.setText(horoscope.dates)
        icon.setImageResource(horoscope.icon)
        supportActionBar?.title = getString(horoscope.name)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.activity_horoscope, menu)
        favorite = menu.findItem(R.id.favorite)
        set(favorite)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.favorite -> {
                if (compare) {
                    session.set("")
                } else {
                    session.set(horoscope.id)
                }
                compare = !compare
                set(favorite)
                return true
            }
            R.id.share -> {
                // TODO
                val text = "Hola"
                val intent = Intent()
                intent.setAction(Intent.ACTION_SEND)
                intent.putExtra(Intent.EXTRA_TEXT, text)
                intent.setType("text/plain")
                val activity = Intent.createChooser(intent, null)
                startActivity(activity)
                return true
            }
            android.R.id.home -> {
                finish()
                return true
            }
            else -> {
                return super.onOptionsItemSelected(item)
            }
        }
    }
    fun set(favorite: MenuItem) {
        if (compare) {
            favorite.setIcon(R.drawable.favorite_24px_2)
        } else {
            favorite.setIcon(R.drawable.favorite_24px)
        }
    }
}