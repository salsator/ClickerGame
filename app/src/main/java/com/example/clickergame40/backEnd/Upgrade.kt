package com.example.clickergame40.backEnd

import kotlin.math.pow

class Upgrade {

   // incrementation modifier
    private var modifierIncome = 1.0F
    private var priceMod :Long = 2000
    private var basePriceMod:Long = 2000
    private var countMod  = 0

    // inceremntation click bonus
    private var bonusClick = 0
    private var priceBonusClick : Long = 1000
    private var basePriceBonusClick : Long = 1000
    private var countBonusClick =0

    //inrementation reset bonus
    private var resetBonus = 0
    private var priceResetBonus: Long = 10000
    private var countResetBonus = 0


    // methods Modifier

        fun getModIncome(): Float {
            return modifierIncome
        }

        fun increaseMod() {
            modifierIncome += 0.1F
            priceMod = (priceMod * 2.0F.pow(1 + countMod)).toLong()
            countMod++
        }

        fun getPriceMod(): Long {
            return priceMod
        }

    // methods click bonus

    fun getBonusClick() : Int
    {
        return bonusClick
    }

    fun increaseBonusClick()
    {
        bonusClick+= 10
        priceBonusClick = (priceBonusClick * 2.0F.pow(1+countBonusClick)).toLong()
        countBonusClick++
    }

    fun getPriceClick() : Long
    {
        return priceBonusClick
    }

    fun getPriceResetBonus(): Long
    {
        return priceResetBonus
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