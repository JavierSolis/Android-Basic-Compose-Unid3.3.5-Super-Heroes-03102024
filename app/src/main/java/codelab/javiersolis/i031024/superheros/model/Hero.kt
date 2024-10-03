package codelab.javiersolis.i031024.superheros.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import codelab.javiersolis.i031024.superheros.R

/**
 * Created by Javier J. Solis Flores on 3/10/24.
 * @email solis.unmsm@gmail.com
 * @github https://github.com/JavierSolis
 */
data class Hero(
    @StringRes val nameRes:Int,
    @StringRes val descriptionRes:Int,
    @DrawableRes val imageRes:Int
)

object HeroesRepository {
    val heroes = listOf(
        Hero(
            nameRes = R.string.hero1,
            descriptionRes = R.string.description1,
            imageRes = R.drawable.android_superhero1
        ),
        Hero(
            nameRes = R.string.hero2,
            descriptionRes = R.string.description2,
            imageRes = R.drawable.android_superhero2
        ),
        Hero(
            nameRes = R.string.hero3,
            descriptionRes = R.string.description3,
            imageRes = R.drawable.android_superhero3
        ),
        Hero(
            nameRes = R.string.hero4,
            descriptionRes = R.string.description4,
            imageRes = R.drawable.android_superhero4
        ),
        Hero(
            nameRes = R.string.hero5,
            descriptionRes = R.string.description5,
            imageRes = R.drawable.android_superhero5
        ),
        Hero(
            nameRes = R.string.hero6,
            descriptionRes = R.string.description6,
            imageRes = R.drawable.android_superhero6
        )
    )
}