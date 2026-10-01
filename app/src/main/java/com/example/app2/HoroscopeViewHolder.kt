package com.example.app2

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class HoroscopeViewHolder(view: View): RecyclerView.ViewHolder(view) {
    val name: TextView = view.findViewById(R.id.name)
    val dates: TextView = view.findViewById(R.id.dates)
    val icon: ImageView = view.findViewById(R.id.icon)

    fun render(horoscope: Horoscope) {
        name.setText(horoscope.name)
        dates.setText(horoscope.dates)
        icon.setImageResource(horoscope.icon)
    }
}