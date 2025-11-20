package dev.pb121.androidtesting.game.model

class Game(
    questions: List<Question>,
    val score: Score
) {

    val questionList =
        questions.takeIf { it.isNotEmpty() }?.toMutableList()
            ?: throw IllegalArgumentException("Questions list can not be empty")

    val highestScore: Int
        get() = score.highestScore

    val currentScore: Int
        get() = score.currentScore

    fun nextQuestion(): Question? {
        return questionList.removeFirstOrNull()
    }

    fun answer(question: Question, option: String) {
        val result = question.answer(userAnswer = option)
        if (result) {
            score.increment()
        }
    }
}