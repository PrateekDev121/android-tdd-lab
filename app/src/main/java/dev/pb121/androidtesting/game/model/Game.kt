package dev.pb121.androidtesting.game.model

class Game(
    questions: List<Question>,
    hScore: Int
) {

    val questionList =
        questions.takeIf { it.isNotEmpty() }?.toMutableList() ?: throw IllegalArgumentException("Questions list can not be empty")

    var highestScore: Int = hScore
        private set

    var currentScore = 0
        private set

    fun incrementScore() {
        currentScore++
        if (currentScore > highestScore) {
            highestScore++
        }
    }

    fun nextQuestion(): Question? {
        return questionList.removeFirstOrNull()
    }

    fun answer(question: Question,option:String){
        question.answer(userAnswer = option)
    }
}