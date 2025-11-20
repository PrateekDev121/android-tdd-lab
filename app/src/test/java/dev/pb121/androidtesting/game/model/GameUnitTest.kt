package dev.pb121.androidtesting.game.model

import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers.anyString
import org.mockito.kotlin.eq
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever

class GameUnitTest {

    val q1 = Question(correctAnswer = "q1Correct", inCorrectAnswer = "q1Incorrect")
    val q2 = Question(correctAnswer = "q2Correct", inCorrectAnswer = "q2Incorrect")
    lateinit var questionList: List<Question>

    @Before
    fun setup() {
        questionList = listOf(q1, q2)
    }


    @Test
    fun `game should have a list of questions and return first if have question`() {
        val game = Game(
            questions = questionList,
            hScore = 0,
        )
        val nextQuestion = game.nextQuestion()
        Assert.assertEquals(q1, nextQuestion)

    }

    //game cannot be initialized with empty list of questions

    @Test(expected = IllegalArgumentException::class)
    fun `game should not init with empty list of question`() {
        Game(
            questions = emptyList(),
            hScore = 0
        )
    }

    @Test
    fun `game should return null when question list is empty`() {
        val maxSize = 1
        val game = Game(
            questions = questionList.take(n = maxSize).takeIf { it.size == maxSize }!!,
            hScore = 0,
        )

        game.nextQuestion()

        val question = game.nextQuestion()

        Assert.assertNull(question)
    }


    @Test
    fun `whenAnswering_shouldDelegateToQuestion`() {
        val question = mock<Question>()
        val game = Game(questions = listOf(question), hScore = 0)
        game.answer(question, "OPTION")
        verify(question).answer(eq("OPTION"))
    }

    @Test
    fun `whenAnswering_scoreShouldBeIncrementBy1`() {
        val question = mock<Question>()
        whenever(question.answer(anyString())).thenReturn(true)


        val game = Game(questions = listOf(question), hScore = 0)
        game.answer(question, "MyOption")

        Assert.assertEquals(1, game.currentScore)
    }

    @Test
    fun `whenAnswering_scoreShouldNotIncrement`() {
        val question = mock<Question>()
        whenever(question.answer(anyString())).thenReturn(false)


        val game = Game(questions = listOf(question), hScore = 0)
        game.answer(question, "MyOption")

        Assert.assertEquals(0, game.currentScore)
    }
}