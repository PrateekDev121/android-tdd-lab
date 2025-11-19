package dev.pb121.androidtesting.game.model

import org.junit.Assert
import org.junit.Before
import org.junit.Test


class QuestionUnitTest {

    val correctAnswer = "correctAnswer"
    val inCorrectAnswer = "inCorrectAnswer"

    lateinit var question: Question

    @Before
    fun setup() {
        question = Question(correctAnswer, inCorrectAnswer)
    }

    @Test
    fun whenCreatingQuestion_shouldNotHaveAnsweredOption() {
        Assert.assertNull(question.answeredOption)
    }


    @Test
    fun whenAnsweringQuestion_shouldHaveTheSameAnswer() {
        question.answer(correctAnswer)
        Assert.assertEquals(correctAnswer, question.answeredOption)
    }

    @Test
    fun whenAnsweringCorrect_shouldGiveTrueResult() {
        val result = question.answer(correctAnswer)
        Assert.assertTrue(result)
    }


    @Test
    fun whenAnswerIncorrect_shouldGiveFalseResult() {
        val result = question.answer(userAnswer = inCorrectAnswer)
        Assert.assertFalse(result)
    }


    @Test(expected = IllegalArgumentException::class)
    fun whenAnswering_shouldAcceptOnlyValidQuestion() {
        val invalidAnswer = "invalidAnswer"
        question.answer(invalidAnswer)
    }




}