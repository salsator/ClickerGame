package com.example.clickergame40

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.clickergame40.backEnd.DaysThread

class Mediator {

    companion object {
        fun newInstance() = Mediator()
    }

    private val daysThread = DaysThread()

    private val _golds = MutableLiveData<Long>(0)
    val golds: LiveData<Long> = _golds

    private val _income = MutableLiveData<Long>(0)
    val income: LiveData<Long> = _income

    private val _days = MutableLiveData<Long>(0)
    val days: LiveData<Long> = _days


    fun addGolds(numberGolds: Long)
    {
        _golds.value?.plus(numberGolds)
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

}