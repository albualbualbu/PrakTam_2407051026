package com.example.praktam_2407051026.model
import com.example.praktam_2407051026.R

data class Hero(
    val nama: String,
    val role: String,
    val imageRes: Int
)

object MLBB {
    val HeroTierA = listOf(
        Hero("Fanny",    "Assasin",  R.drawable.hero_fanny),
        Hero("Chou",      "Fighter",  R.drawable.hero_chou),
        Hero("Pharsa", "Mage",     R.drawable.hero_pharsa),
        Hero("Claude",     "Marksman", R.drawable.hero_claude),
        Hero("Kalea",    "Tank",     R.drawable.hero_kalea)
    )
}