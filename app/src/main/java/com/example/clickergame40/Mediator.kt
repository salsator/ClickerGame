package com.example.clickergame40

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.clickergame40.backEnd.DaysThread
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

object Mediator: ViewModel() {


    private val daysThread = DaysThread()
    var gold: Long = 10


    private val _golds = MutableLiveData<Long>(0)
    val golds: LiveData<Long> = _golds

    private val _income = MutableLiveData<Long>(0)
    val income: LiveData<Long> = _income

    private val _days = MutableLiveData<Long>(0)
    val days: LiveData<Long> = _days


    fun addGolds(numberGolds: Long)
    {
        var gold = getGolds()
        gold += numberGolds
        _golds.postValue(gold)
        //_golds.value?.plus(numberGolds)
    }




   private fun getGolds() : Long
    {
        var gold = golds.value
        if(gold == null)
        {
            gold = 0
        }
        return gold
    }


    fun buy(price : Long) : Boolean
    {
        return if (getGolds() > price) {
            golds.value?.minus(price)
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

    fun buyHero(cislo:Int,)
    {
        TODO("dořešit kupování hrdinů")
    }

    fun click()
    {
        val gold : Long = 1 + daysThread.heroes.getAllHeroes().toLong()

        //golds.value = gold)
        addGolds(gold)
    }

}