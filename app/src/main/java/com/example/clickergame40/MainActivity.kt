package com.example.clickergame40

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.clickergame40.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        binding.button.setOnClickListener {
            if (binding.jmenoEdit.text.isEmpty())
            {
                Toast.makeText(this,"zadej jméno", Toast.LENGTH_SHORT).show()

            }
            else
            {
               val name = binding.jmenoEdit.text.toString()
                Mediator.setName(name)
                val i = Intent(this, GameActivity::class.java)
                startActivity(i)

            }

        }


    }
}