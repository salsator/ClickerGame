package com.example.clickergame40.backEnd



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
            if(Mediator.getDays()<=1)
            {
            Mediator.endTrue()
            }
            Mediator.changeCycle(0)
        }

    }

    suspend fun cycle()
    {
        var value =0
        for (i in 0..99)
        {delay(30L)
            value++
        mediator.changeCycle(value)
        }
    }





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

