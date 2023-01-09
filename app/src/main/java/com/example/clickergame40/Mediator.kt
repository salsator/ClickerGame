package com.example.clickergame40


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.clickergame40.backEnd.DaysThread


object Mediator {


    private val daysThread = DaysThread()

    private var names : String = ""

    private val _golds = MutableLiveData<Long>(0)
    val golds: LiveData<Long> = _golds

    private val _income = MutableLiveData<Long>(0)
    val income: LiveData<Long> = _income

    private val _days = MutableLiveData<Int>(100)
    val days: LiveData<Int> = _days

    private val _cycle = MutableLiveData<Int>(0)
    val cycle: LiveData<Int> = _cycle

    fun setName(name: String)
    {
        names = name
    }
    fun getName() : String
    {
        return names
    }

    fun changeCycle(value: Int)
    {
        _cycle.postValue(value)
    }

    fun minusDays()
    {
        var days = getDays()
        days--
        _days.postValue(days)

    }
    fun getDays() : Int
    {
        var days = days.value
        if(days == null)
        {
            days = 0
        }
        return days
    }
    fun addIncome()
    {
        _income.postValue(daysThread.getAllIncome())
    }

    private fun getGolds() : Long
    {
        return golds.value ?:  0
    }
    fun getIncome(): Long
    {
        return income.value ?: 0
    }


    fun plusGolds(numberGolds: Long)
    {
        var gold = getGolds()
        gold += numberGolds
        _golds.postValue(gold)
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




    fun buyHero(cislo:Int)
    {
       val price  = daysThread.heroes.getHeroCost(cislo)

        if (buy(price))
        {
            daysThread.heroes.buyHero(cislo)
            addIncome()
        }

    }

    fun click()
    {
        val gold : Long = 1 + daysThread.heroes.getAllHeroes().toLong() + daysThread.upgrade.getBonusClick()
        plusGolds(gold)
    }



    fun getIncomeHero(numberHero: Int): String {

        return daysThread.heroes.getHeroIncome(numberHero)
    }

    fun getCountHero(numberHero: Int): String {
        return daysThread.heroes.getHeroCount(numberHero)
    }

    fun getPriceForHero(numberHero: Int) : String
    {
        return daysThread.heroes.getHeroCost(numberHero).toString()
    }

    fun getPriceForModBonus() : String
    {
        return daysThread.upgrade.getPriceMod().toString()
    }
    fun getPriceForBonusClick() : String
    {
        return daysThread.upgrade.getPriceClick().toString()
    }

    fun getModBonus() : String
    {
        return daysThread.upgrade.getModIncome().toString()
    }
    fun getClickBonus(): String
    {
        return daysThread.upgrade.getBonusClick().toString()
    }


    fun buyClickBonus()
    {
        if (buy(daysThread.upgrade.getPriceClick()))
        {
            daysThread.upgrade.increaseBonusClick()
        }
    }

    fun buyModBonus()
    {
        if (buy(daysThread.upgrade.getPriceMod()))
        {
            daysThread.upgrade.increaseMod()
        }
    }

    fun resetWorld()
    {
       if (buy(daysThread.upgrade.getPriceResetBonus()))
       {
        daysThread.upgrade.resetUpgrade()
        daysThread.heroes.resetHeroes()
        _income.postValue(0)
        _golds.postValue(0)
        _days.postValue(0)
       }
    }

    fun getHeroName(number: Int) : String
    {
        return daysThread.heroes.getNameHero(number)
    }
}

