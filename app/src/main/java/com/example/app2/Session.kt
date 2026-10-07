package com.example.app2

import android.content.Context

class Session(context: Context) {
    val session = context.getSharedPreferences("session", Context.MODE_PRIVATE)
    fun set(id: String) {
        val edit = session.edit()
        edit.putString("favorite", id)
        edit.apply()
    }
    fun get(): String {
        return session.getString("favorite", "")!!
    }
    fun compare(id: String): Boolean {
        return get() == id
    }
}