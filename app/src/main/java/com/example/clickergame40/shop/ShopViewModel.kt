package com.example.clickergame40.shop


import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.ViewModel
import com.example.clickergame40.Mediator

class ShopViewModel : ViewModel() {


    fun buyHeroes(numberHero: Int, button: Button,textView: TextView )
    {
        Mediator.buyHero(numberHero)
         button.text = getBtnString(numberHero)
        textView.text = getTxtString(numberHero)

    }

    private fun getBtnString(number: Int) : String
    {
        val priceHero = Mediator.getPriceForHero(number)

        return "Cena: ${System.lineSeparator()}$priceHero"

    }

    private fun getTxtString(number: Int) : String
    {
        val incomeHero: String = Mediator.getIncomeHero(number)
        val countHero: String = Mediator.getCountHero(number).toString()
        val name: String = Mediator.getHeroName(number)

        return "$name${System.lineSeparator()}výdělek: $incomeHero ${System.lineSeparator()}úroveň hrdiny: $countHero"

    }
     fun changeVisibility(number: Int, button: Button, textView: TextView, image : ImageView)
    {
        if((Mediator.getCountHero(number) >0) && button.visibility == View.INVISIBLE)
        {
            button.visibility = View.VISIBLE
            textView.visibility = View.VISIBLE
            image.visibility = View.VISIBLE
        }
    }


}