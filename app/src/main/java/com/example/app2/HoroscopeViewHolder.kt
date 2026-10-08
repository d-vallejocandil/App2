package com.example.app2

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView

class HoroscopeViewHolder(val view: View): RecyclerView.ViewHolder(view) {
    val name: TextView = view.findViewById(R.id.name)
    val dates: TextView = view.findViewById(R.id.dates)
    val icon: ImageView = view.findViewById(R.id.icon)
    val favorite: ImageView = view.findViewById(R.id.favorite)
    fun render(horoscope: Horoscope) {
        name.setText(horoscope.name)
        dates.setText(horoscope.dates)
        icon.setImageResource(horoscope.icon)
        favorite.isVisible = Session(view.context).compare(horoscope.id)
    }
}