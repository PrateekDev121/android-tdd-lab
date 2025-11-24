package dev.pb121.androidtesting.game.model

import android.content.SharedPreferences
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.kotlin.any
import org.mockito.kotlin.eq
import org.mockito.kotlin.inOrder
import org.mockito.kotlin.whenever

class SaveScoreRepositoryUnitTest {

    @Test
    fun saveScore_shouldSaveToSharedPreferences() {

        val gameApi: GameApi  = mock()
        val sharedPref = mock<SharedPreferences>()
        val sharedPrefEditor = mock<SharedPreferences.Editor>()

        whenever(sharedPref.edit()).thenReturn(sharedPrefEditor)


        val repository = GameRepoImpl(
            gameApi,
            sharedPref
        )

        val highScore = 100
        repository.saveHighScore(highScore)

        inOrder(sharedPrefEditor) {
            verify(sharedPrefEditor).putInt(any(), eq(highScore))
            verify(sharedPrefEditor).apply()
        }
    }

}