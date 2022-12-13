package com.example.clickergame40.backEnd

import kotlin.math.pow

class Hero( priceHero: Long, modificatorCost: Float, incomeHero: Long) {

    private var _heroCount : Int =0
    private var _priceHero = priceHero
    private var _heroIncome = incomeHero
    private val _modifikatorCeny = modificatorCost
    private val _basicCost = priceHero


    fun getPriceForHero(): Long {
        return _priceHero
    }

    fun getHeroCount(): Int {
        return _heroCount
    }


    fun getHeroIncome() :Long
    {
        return (_heroIncome* _heroCount)
    }

    private fun changePrice()
    {
        _priceHero += ((_basicCost *(_modifikatorCeny.pow(_heroCount)))-_basicCost).toInt()
    }

    fun buyHero()
    {
        _heroCount += 1
        changePrice()
    }


    fun resetHero()
    {
        _heroCount = 0
        changePrice()
    }


}