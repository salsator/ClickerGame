package com.example.clickergame40.backEnd

import kotlin.math.pow

class Hero( priceHero: Long, modificatorCost: Float, incomeHero: Long) {

    private var heroCount : Int =0
    private var _priceHero = priceHero
    private var _heroIncome = incomeHero
    private val _modifikatorCeny = modificatorCost
    private val _basicCost = priceHero


    fun getPriceForHero(): Long {
        return _priceHero
    }

    fun getHeroCount(): Int {
        return heroCount
    }


    fun getHeroIncome() :Long
    {
        return (_heroIncome* heroCount)
    }

    private fun changePrice()
    {
        _priceHero += ((_basicCost *(_modifikatorCeny.pow(heroCount)))-_basicCost).toInt()
    }

    fun buyHero()
    {
        heroCount += 1
        changePrice()
    }


    fun resetHero()
    {
        heroCount = 0
        changePrice()
    }


}