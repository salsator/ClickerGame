package com.example.clickergame40.backEnd

class Heroes {

    private  val farmer = Hero(10, 1.07F, 1)
    private  val fighter = Hero(300, 1.15F, 25)
    private  val rogue = Hero(2200, 1.14F, 100)
    private  val wizard = Hero(20000, 1.13F, 450)
    private  val champion = Hero(100000, 1.12F, 5000)
    private  val god = Hero(999999999, 100.0F, 50000)

    var arrayOfHero = listOf<Hero>()


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


    fun buyHero(cislo:Int) {
     /*
        if (mainViewModel.buy(arrayOfHero[cislo].getPriceForHero())) {
            arrayOfHero[cislo].buyHero()
        }*/

    }




}