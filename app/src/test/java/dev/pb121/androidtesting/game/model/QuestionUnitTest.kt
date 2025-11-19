package dev.pb121.androidtesting.game.model

import org.junit.Assert
import org.junit.Test


class QuestionUnitTest {


    @Test
    fun whenCreatingQuestion_shouldNotHaveAnsweredOption() {
        val question = Question()
        Assert.assertNull(question.answeredOption)
    }


    @Test
    fun whenAnsweringQuestion_shouldHaveTheSameAnswer() {
        val question = Question()
        val myAnswer = "myAnswer"
        question.answer(myAnswer)
        Assert.assertEquals(myAnswer, question.answeredOption)
    }

    @Test
    fun whenAnsweringCorrect_shouldGiveTrueResult() {
        val correctAnswer = "correctAnswer"
        val inCorrectAnswer = "inCorrectAnswer"
        val question = Question(
            correctAnswer,
            inCorrectAnswer,
        )

        val result = question.answer(correctAnswer)
        Assert.assertTrue(result)
    }


}