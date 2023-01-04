package com.example.clickergame40.upgrade


import android.content.Intent
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.ViewModel
import com.example.clickergame40.GameActivity
import com.example.clickergame40.Mediator
import kotlinx.coroutines.flow.combine

class UpgradeViewModel : ViewModel() {


    fun buyClickBonus(number : Int,button: Button,textView: TextView)
    {
       if (number == 0)
       {
           Mediator.buyClickBonus()
           getBtnString(number,button)
           getTxtString(number,textView)
       }
       else if (number == 1) {
           Mediator.buyModBonus()
           getBtnString(number, button)
           getTxtString(number, textView)
       }

    }


    fun getBtnString(number: Int,button: Button)
    {
      var price =""
       if (number == 0)
       {
            price = Mediator.getPriceForBonusClick()
       }
       else if (number == 1)
       {
            price = Mediator.getPriceForModBonus()
       }

        button.text = "Cena: ${System.lineSeparator()} $price"
    }

    fun getTxtString(number: Int,textView: TextView)
    {
         var text = ""
        var value =""
        if (number == 0)
        {
           value = Mediator.getClickBonus()
            text = "Bonus kliku:${System.lineSeparator()}$value"
        }
        else if (number == 1)
        {
            value = Mediator.getModBonus()
            text = "bonus k výdělku:${System.lineSeparator()}$value"
        }
        textView.text = text
    }


    fun resetWorld()
    {

    }

}