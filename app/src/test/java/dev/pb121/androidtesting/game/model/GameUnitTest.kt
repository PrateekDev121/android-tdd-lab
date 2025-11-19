package dev.pb121.androidtesting.game.model

import org.junit.Assert
import org.junit.Test

class GameUnitTest {

    @Test
    fun whenIncrement_scoreShouldIncreasedBy1(){

        val game = Game()
        game.incrementScore()
        Assert.assertEquals("current score should be 1",1,game.currentScore)
    }

    @Test
    fun wheIncrementScore_aboveHighScore_highScoreShouldIncrement(){
        val game = Game()
        game.incrementScore()
        Assert.assertEquals("high score should be 1",1,game.highestScore)
    }

    @Test
    fun wheIncrementScore_belowHighScore_highScoreShouldIncrement(){
        val game = Game(10)
        game.incrementScore()
        Assert.assertEquals(10,game.highestScore)
    }
}