package dev.pb121.androidtesting.game.model

import android.content.SharedPreferences

const val HIGH_SCORE_KEY = "HIGH_SCORE_KEY"

class GameRepoImpl(
    private val gameApi: GameApi,
    private val sharedPreferences: SharedPreferences,
) : GameRepo {
    override fun saveHighScore(highScore: Int) {
        sharedPreferences.edit().apply {
            putInt(HIGH_SCORE_KEY, highScore)
            apply()
        }
    }
}