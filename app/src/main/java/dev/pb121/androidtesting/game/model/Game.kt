package dev.pb121.androidtesting.game.model

class Game(
    questions: List<Question>,
    hScore: Int
) {

    val questionList =
        questions.takeIf { it.isNotEmpty() }?.toMutableList() ?: throw IllegalArgumentException("Questions list can not be empty")

    val score = Score(hScore = hScore)

    val highestScore:Int
        get() = score.highestScore

    val currentScore:Int
        get() = score.currentScore

    fun incrementScore() {
       score.increment()
    }

    fun nextQuestion(): Question? {
        return questionList.removeFirstOrNull()
    }

    fun answer(question: Question,option:String){
       val result =  question.answer(userAnswer = option)
        if(result){
            incrementScore()
        }
    }
}