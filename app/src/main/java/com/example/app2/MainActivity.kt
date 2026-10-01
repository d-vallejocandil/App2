package com.example.app2

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    val horoscopes: List<Horoscope> = listOf(
        Horoscope("aquarius", R.string.aquarius, R.string.aquarius_date, R.drawable.aquarius_svgrepo_com),
        Horoscope("aries", R.string.aries, R.string.aries_date, R.drawable.aries_svgrepo_com),
        Horoscope("cancer", R.string.cancer, R.string.cancer_date, R.drawable.cancer_svgrepo_com),
        Horoscope("capricorn", R.string.capricorn, R.string.capricorn_date, R.drawable.capricorn_svgrepo_com),
        Horoscope("gemini", R.string.gemini, R.string.gemini_date, R.drawable.gemini_svgrepo_com),
        Horoscope("leo", R.string.leo, R.string.leo_date, R.drawable.leo_svgrepo_com),
        Horoscope("libra", R.string.libra, R.string.libra_date, R.drawable.libra_svgrepo_com),
        Horoscope("pisces", R.string.pisces, R.string.pisces_date, R.drawable.pisces_svgrepo_com),
        Horoscope("sagittarius", R.string.sagittarius, R.string.sagittarius_date, R.drawable.sagittarius_svgrepo_com),
        Horoscope("scorpio", R.string.scorpio, R.string.scorpio_date, R.drawable.scorpio_svgrepo_com),
        Horoscope("taurus", R.string.taurus, R.string.taurus_date, R.drawable.taurus_svgrepo_com),
        Horoscope("virgo", R.string.virgo, R.string.virgo_date, R.drawable.virgo_svgrepo_com)
    )
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
        horoscopeAdapter = HoroscopeAdapter(horoscopes)
        recyclerView.adapter = horoscopeAdapter
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }
}