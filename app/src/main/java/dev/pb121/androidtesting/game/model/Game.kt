package dev.pb121.androidtesting.game.model

class Game {

    var currentScore = 0
        private set

    fun incrementScore() {
        currentScore++
    }
}