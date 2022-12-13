package com.example.clickergame40.backEnd

import com.example.clickergame40.Mediator
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class DaysThread() {

    val heroes = Heroes()
    val upgrade = Upgrade()
    val mediator = Mediator



    suspend fun doDays() = runBlocking {
        repeat(500)
        {
            launch {
                delay(3000L)
                addUpGolds()
            }
        }
    }




    fun addUpGolds()
    {
       val gold = 10
           //heroes.getAllIncome() * upgrade.getModIncome()
        mediator.golds.value?.plus(gold)
    }


}