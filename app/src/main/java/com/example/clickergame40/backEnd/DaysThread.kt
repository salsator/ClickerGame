package com.example.clickergame40.backEnd

import android.util.Log
import com.example.clickergame40.Mediator
import kotlinx.coroutines.*


class DaysThread() : Thread() {

    val heroes = Heroes()
    val upgrade = Upgrade()
    val mediator = Mediator



    override fun run() {
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
        }



     fun getAllIncome() : Long
    {
     return heroes.getAllHeroes() * upgrade.getModIncome().toLong()
    }

    fun addUpGolds()
    {
     mediator.plusGolds(getAllIncome())
    }


}

