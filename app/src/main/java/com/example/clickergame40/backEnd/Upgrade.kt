package com.example.clickergame40.backEnd

import kotlin.math.pow

class Upgrade {

   // incrementation modifier
    private var modifierIncome = 1.0F
    private var priceMod :Long = 2000
    private var basePriceMod:Long = 2000
    private var countMod  = 0

    // inceremntation click bonus
    private var bonusClick = 1
    private var priceBonusClick : Long = 1000
    private var basePriceBonusClick : Long = 1000
    private var countBonusClick =0




    // methods Modifier

    fun getModIncome() : Float
    {
        return modifierIncome
    }

    fun increaseMod()
    {
        modifierIncome += 0.1F
        priceMod = (priceMod * 2.0F.pow(1+countMod)).toLong()
        countMod++
    }


    // methods click bonus

    fun getBonusClick() : Int
    {
        return bonusClick
    }

    fun increaseBonusClick()
    {
        bonusClick++
        priceBonusClick = (priceBonusClick * 2.0F.pow(1+countBonusClick)).toLong()
        countBonusClick++
    }


    fun resetUpgrade()
    {
        modifierIncome = 1.0F
        countMod =0
        priceMod = basePriceMod

        bonusClick =1
        countBonusClick =0
        priceBonusClick = basePriceBonusClick
    }

}