package dev.pb121.androidtesting.game.model

class Question(
    val correctAnswer: String,
    val inCorrectAnswer: String,
) {
    var answeredOption: String? = null
        private set

    fun answer(userAnswer: String): Boolean {

        if (userAnswer !in listOf(correctAnswer, inCorrectAnswer)) {
            throw IllegalArgumentException("invalid answer:$userAnswer")
        }

        answeredOption = userAnswer
        return answeredOption == correctAnswer
    }
}