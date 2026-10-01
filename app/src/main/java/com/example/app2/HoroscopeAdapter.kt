package com.example.app2

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class HoroscopeAdapter(val horoscopes: List<Horoscope>): RecyclerView.Adapter<HoroscopeViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HoroscopeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.horoscope, parent, false)
        return HoroscopeViewHolder(view)
    }
    override fun onBindViewHolder(holder: HoroscopeViewHolder, position: Int) {
        val horoscope = horoscopes[position]
        holder.render(horoscope)
    }
    override fun getItemCount(): Int {
        return horoscopes.size
    }
}