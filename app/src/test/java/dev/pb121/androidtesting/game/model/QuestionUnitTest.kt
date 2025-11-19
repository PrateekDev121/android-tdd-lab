package dev.pb121.androidtesting.game.model

import org.junit.Assert
import org.junit.Test


class QuestionUnitTest {

    val correctAnswer = "correctAnswer"
    val inCorrectAnswer = "inCorrectAnswer"

    @Test
    fun whenCreatingQuestion_shouldNotHaveAnsweredOption() {
        val question = Question(correctAnswer,inCorrectAnswer)
        Assert.assertNull(question.answeredOption)
    }


    @Test
    fun whenAnsweringQuestion_shouldHaveTheSameAnswer() {
        val question = Question(
            correctAnswer,
            inCorrectAnswer,
        )
        question.answer(correctAnswer)
        Assert.assertEquals(correctAnswer, question.answeredOption)
    }

    @Test
    fun whenAnsweringCorrect_shouldGiveTrueResult() {

        val question = Question(
            correctAnswer,
            inCorrectAnswer,
        )

        val result = question.answer(correctAnswer)
        Assert.assertTrue(result)
    }


    @Test
    fun whenAnswerIncorrect_shouldGiveFalseResult() {

        val question = Question(
            correctAnswer,
            inCorrectAnswer,
        )

        val result = question.answer(userAnswer = inCorrectAnswer)
        Assert.assertFalse(result)
    }


    @Test(expected = IllegalArgumentException::class)
    fun whenAnswering_shouldAcceptOnlyValidQuestion() {
        val question = Question(
            correctAnswer,
            inCorrectAnswer,
        )

        val invalidAnswer = "invalidAnswer"
        question.answer(invalidAnswer)
    }


}