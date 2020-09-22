package ru.skillbranch.gameofthrones

import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import java.lang.IllegalStateException

enum class HouseType(
    val title: String,
    @DrawableRes
    val icon: Int,
    @DrawableRes
    val coastOfArms: Int,
    @ColorRes
    val primaryColor: Int,
    @ColorRes
    val accentColor: Int,
    @ColorRes
    val darkColor: Int
) {
    STARK("Stark", R.drawable.stark_icon, R.drawable.stark, R.color.stark_primary, R.color.stark_accent, R.color.stark_dark),
    LANNISTER("Lannister", R.drawable.lannister_icon, R.drawable.lannister, R.color.lannister_primary, R.color.lannister_accent, R.color.lannister_dark),
    TARGARYEN("Targaryen", R.drawable.targaryen_icon, R.drawable.targaryen, R.color.targaryen_primary, R.color.targaryen_accent, R.color.targaryen_dark),
    BARATHEON("Baratheon", R.drawable.baratheon_icon, R.drawable.baratheon, R.color.baratheon_primary, R.color.baratheon_accent, R.color.baratheon_dark),
    GREYJOY("Greyjoy", R.drawable.greyjoy_icon, R.drawable.greyjoy, R.color.greyjoy_primary, R.color.greyjoy_accent, R.color.greyjoy_dark),
    MARTELL("Martell", R.drawable.martel_icon, R.drawable.martel, R.color.martel_primary, R.color.martel_accent, R.color.martel_dark),
    TYRELL("Tyrell", R.drawable.tyrel_icon, R.drawable.tyrel, R.color.tyrel_primary, R.color.tyrel_accent, R.color.tyrel_dark);

    companion object {
        fun fromString(title: String) = when (title) {
            STARK.title -> STARK
            LANNISTER.title -> LANNISTER
            TARGARYEN.title -> TARGARYEN
            BARATHEON.title -> BARATHEON
            GREYJOY.title -> GREYJOY
            MARTELL.title -> MARTELL
            TYRELL.title -> TYRELL
            else -> throw IllegalStateException("Unknown house: $title")
        }
    }
}