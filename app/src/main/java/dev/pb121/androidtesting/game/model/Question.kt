package dev.pb121.androidtesting.game.model

class Question(
    val correctAnswer: String = "correctAnswer",
    val inCorrectAnswer: String = "inCorrectAnswer"
) {
    var answeredOption: String? = null
        private set
}