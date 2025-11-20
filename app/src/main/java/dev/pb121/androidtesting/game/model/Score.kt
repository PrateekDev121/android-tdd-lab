package dev.pb121.androidtesting.game.model

class Score(hScore: Int) {

    var currentScore: Int = 0
        private set

    var highestScore = hScore
        private set

    fun increment() {
        currentScore++
        if (currentScore > highestScore) {
            highestScore = currentScore
        }
    }
}