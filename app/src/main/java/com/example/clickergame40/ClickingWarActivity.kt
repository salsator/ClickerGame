package com.example.clickergame40

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.clickergame40.databinding.ActivityClickingWarBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class ClickingWarActivity : AppCompatActivity() {
    private lateinit var binding: ActivityClickingWarBinding

    val maxprogres =100
    var progres = 50

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityClickingWarBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.progressBar.max = maxprogres

        val clicking = GlobalScope.launch {
            while (progres == 100 || progres == 0)
            {
                progres -= 1
                setProgres()
                delay(300L)
            }
        }


       binding.button2.setOnClickListener {
            progres += 1
            setProgres()
        }


    }

    fun setProgres()
    {
        binding.progressBar.setProgress(progres)
    }
}