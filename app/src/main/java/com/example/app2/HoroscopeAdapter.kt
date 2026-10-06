package com.example.app2

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class HoroscopeAdapter(var horoscopes: List<Horoscope>, val listener: (Int) -> Unit): RecyclerView.Adapter<HoroscopeViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HoroscopeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.horoscopes, parent, false)
        return HoroscopeViewHolder(view)
    }
    override fun onBindViewHolder(holder: HoroscopeViewHolder, position: Int) {
        val horoscope = horoscopes[position]
        holder.render(horoscope)
        holder.itemView.setOnClickListener {
            listener(position)
        }
    }
    override fun getItemCount(): Int {
        return horoscopes.size
    }
    fun update(items: List<Horoscope>) {
        horoscopes = items
        notifyDataSetChanged()
    }
}