package com.example.clickergame40.backEnd

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class DaysThread {

    val heroes = Heroes()
    val upgrade = Upgrade()





    suspend fun doDays() = runBlocking {
        repeat(500)
        {
            launch {
                delay(3000L)
                TODO("dodělat aktualizaci denní doby v UI, progress bar")
            }
        }
    }



}