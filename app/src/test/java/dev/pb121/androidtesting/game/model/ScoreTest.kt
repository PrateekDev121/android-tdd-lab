package dev.pb121.androidtesting.game.model

import org.junit.Assert
import org.junit.Test

class ScoreTest {


    @Test
    fun `whenIncrement_scoreShouldBeIncrementedBy1`(){
        val score = Score(hScore = 0)
        score.increment()
        Assert.assertEquals(1,score.currentScore)
    }

    @Test
    fun `when incrementing score more than high score, high score should be increased`(){
        val score = Score(hScore = 0)
        score.increment()
        Assert.assertEquals(1,score.highestScore)
    }

    @Test
    fun `when incrementing score less than high score, high score should not be increased`(){
        val score = Score(hScore = 10)
        score.increment()
        Assert.assertEquals(10,score.highestScore)
    }

}