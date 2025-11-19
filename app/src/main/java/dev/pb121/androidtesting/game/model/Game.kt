package dev.pb121.androidtesting.game.model

class Game(hScore: Int = 0) {

    var highestScore: Int = hScore
        private set

    var currentScore = 0
        private set

    fun incrementScore() {
        currentScore++
        if(currentScore > highestScore){
            highestScore++
        }
    }
}