package com.example.clickergame40.shop


import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModel
import com.example.clickergame40.Mediator

class ShopViewModel : ViewModel() {


    fun buyHeroes(numberHero: Int,button: Button,textView: TextView )
    {
        Mediator.buyHero(numberHero)
        TODO("dodělej vykreslování textu na tlačítku ")
    }


}