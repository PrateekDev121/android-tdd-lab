package dev.pb121.androidtesting.game.model

import org.junit.Assert
import org.junit.Test


class QuestionUnitTest{


    @Test
    fun whenCreatingQuestion_shouldNotHaveAnsweredOption(){
        val question = Question()
        Assert.assertNull(question.answeredOption)
    }

}