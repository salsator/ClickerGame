package com.example.clickergame40.backEnd

import android.util.Log
import com.example.clickergame40.Mediator
import kotlinx.coroutines.*

class DaysThread() {

    val heroes = Heroes()
    val upgrade = Upgrade()
    val mediator = Mediator

    init {
    GlobalScope.launch {
        try
        {
            coroutineScope {
                repeat(500)
                {
                    launch {
                        delay(3000L)
                        addUpGolds()

                    }
                }
            }

        }
        catch (e: Exception)
        {
            Log.e("coroutines error", "e.message")
        }
    }

    }

    suspend fun doDays() = coroutineScope {
        repeat(500)
        {
            launch {
                delay(3000L)
                addUpGolds()
                TODO("dořešit zpuštění vlákna po spuštění game aktivity")
            }
        }
    }



    private fun getAllIncome() : Long
    {
     return heroes.getAllHeroes() * upgrade.getModIncome().toLong()
    }

    fun addUpGolds()
    {
     mediator.plusGolds(getAllIncome())
    }


}

