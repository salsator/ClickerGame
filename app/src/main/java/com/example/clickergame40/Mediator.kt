package com.example.clickergame40

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.clickergame40.backEnd.DaysThread

object Mediator {


    private val daysThread = DaysThread()


    private val _golds = MutableLiveData<Long>(0)
    val golds: LiveData<Long> = _golds

    private val _income = MutableLiveData<Long>(0)
    val income: LiveData<Long> = _income

    private val _days = MutableLiveData<Long>(0)
    val days: LiveData<Long> = _days


    private fun getGolds() : Long
    {
        var gold = golds.value
        if(gold == null)
        {
            gold = 0
        }
        return gold
    }

    fun plusGolds(numberGolds: Long)
    {
        var gold = getGolds()
        gold += numberGolds
        _golds.postValue(gold)
        //_golds.value?.plus(numberGolds)
    }

    fun minusGolds(numberGolds: Long)
    {
        var gold = getGolds()
        gold -= numberGolds
        _golds.postValue(gold)
    }


    fun buy(price : Long) : Boolean
    {
        return if (getGolds() > price) {
           minusGolds(price)
            true
        } else {
            false
        }
    }

  /*  fun start()
    {
        runBlocking { // this: CoroutineScope
            launch { daysThread.doDays() }
        }
    }*/

    fun buyHero(cislo:Int)
    {
       val price  = daysThread.heroes.getHeroCost(cislo)

        if (buy(price))
        {
            daysThread.heroes.buyHero(cislo)
        }

    }

    fun click()
    {
        val gold : Long = 1 + daysThread.heroes.getAllHeroes().toLong()
        plusGolds(gold)
    }

    fun start()
    {
        daysThread.heroes.fillArray()
    }
}