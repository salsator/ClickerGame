package com.example.clickergame40.backEnd

import android.provider.Settings.Global
import android.util.Log
import com.example.clickergame40.Mediator
import kotlinx.coroutines.*


class DaysThread() : Thread() {

    val heroes = Heroes()
    val upgrade = Upgrade()
    val mediator = Mediator



    val job = GlobalScope.launch {
        while (Mediator.getDays()>1) {


           cycle()
            addUpGolds()
            Mediator.minusDays()
            Mediator.changeCycle(0)

        }

    }

    suspend fun cycle()
    {
        var value =0
        for (i in 0..99)
        {delay(90L)
            value++
        mediator.changeCycle(value)
        }
    }

   /* override fun run() {
            while (Mediator.getDays()>1) {
               sleep(800)
                Mediator.changeCycle(33)
                sleep(800)
                Mediator.changeCycle(66)
                sleep(800)
                Mediator.changeCycle(99)
                sleep(800)
                addUpGolds()
                Mediator.minusDays()
                Mediator.changeCycle(0)

            }
        }*/



     fun getAllIncome() : Long
    {
     return heroes.getAllIncome() * upgrade.getModIncome().toLong()
    }

    fun addUpGolds()
    {
     mediator.plusGolds(getAllIncome())
    }

    fun cancelThread()
    {
        job.cancel()
    }

}

