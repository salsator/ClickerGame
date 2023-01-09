package com.example.clickergame40.backEnd

import com.example.clickergame40.Mediator

class Heroes {

    private  val farmer = Hero(10, 1.07F, 2, "Farmář")
    private  val fighter = Hero(300, 1.15F, 50, "Bojovník")
    private  val rogue = Hero(2200, 1.14F, 200, "Zloděj")
    private  val wizard = Hero(20000, 1.13F, 850, "Kouzelnik")
    private  val champion = Hero(100000, 1.12F, 10000, "Paladin")
    private  val god = Hero(9999999, 100.0F, 100000, "Božstvo")

    var arrayOfHero = listOf<Hero>()

    init {
        fillArray()
    }

    fun fillArray()
    {
        arrayOfHero = arrayOfHero + farmer + fighter+ rogue+ wizard+ champion+ god
    }



    fun getAllHeroes() : Int
    {
        var total =0
        for (i in arrayOfHero)
        {
            total += i.getHeroCount()
        }
        return total
    }

    fun getAllIncome() : Long
    {
        var total : Long = 0
        for (i in arrayOfHero)
        {
            total += i.getHeroIncome()
        }
        return total
    }



    fun resetHeroes()
    {
        for (i in arrayOfHero)
        {
            i.resetHero()
        }
    }


    fun buyHero(number:Int)
    {
            arrayOfHero[number].buyHero()
    }

    fun getHeroCost(number:Int) : Long
    {
       return arrayOfHero[number].getPriceForHero()
    }

    fun getHeroIncome(number: Int) : String
    {
        val income : Long = arrayOfHero[number].getHeroIncome()

        return income.toString()
    }

    fun getHeroCount(number: Int) : String
    {
        val count : Int = arrayOfHero[number].getHeroCount()
        return count.toString()
    }

    fun getNameHero(number: Int) : String
    {
        return arrayOfHero[number].getName()
    }

}