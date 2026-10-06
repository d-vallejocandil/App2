package com.example.app2

data class Horoscope(
    val id: String,
    val name: Int,
    val dates: Int,
    val icon: Int
) {
    companion object {
        private val horoscopes: List<Horoscope> = listOf(
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
        fun getAll(): List<Horoscope> {
            return horoscopes
        }
        fun getById(id: String): Horoscope {
            return horoscopes.find { it.id == id }!!
        }
    }
}