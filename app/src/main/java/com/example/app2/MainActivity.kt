package com.example.app2

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    val horoscopes: List<Horoscope> = Horoscope.getAll()
    lateinit var recyclerView: RecyclerView
    lateinit var horoscopeAdapter: HoroscopeAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        recyclerView = findViewById(R.id.recyclerView)
        horoscopeAdapter = HoroscopeAdapter(horoscopes) {
            val horoscope = horoscopes[it]
            val intent = Intent(this, HoroscopeActivity::class.java)
            intent.putExtra("HOROSCOPE", horoscope.id)
            startActivity(intent)
        }
        recyclerView.adapter = horoscopeAdapter
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }
}