package com.example.clickergame40


import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.clickergame40.databinding.ActivityGameBinding
import com.google.android.material.tabs.TabLayoutMediator


class GameActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGameBinding

    val tabTitle = arrayOf("Výprava","Obchod","Vylepšeni")



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityGameBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)


        binding.vyhraSilaBar.max = 99

        /// TabLayout deklarace a propojení
        val pager = binding.viewPager
        val tl = binding.tabLayout
        pager.adapter = ViewPagerAdapter(supportFragmentManager, lifecycle)

        TabLayoutMediator(tl, pager)
        { tab, position ->
            tab.text = tabTitle[position]
        }.attach()



      Mediator.golds.observe(this) {
           binding.goldsTxt.text = it.toString()
       }
        Mediator.income.observe(this, Observer {
            binding.IncomeTxt.text = it.toString()
        })
        Mediator.days.observe(this, Observer {
            binding.dayTxt.text = it.toString()
        })

        Mediator.cycle.observe(this, Observer {
            binding.vyhraSilaBar.progress = it
        })

        Mediator.end.observe(this, Observer {
            if (Mediator.end.value == true)
            {
                nextActivity()
            }
        })
    }


    fun nextActivity()
    {
        val intent = Intent (this, ScoreActivity::class.java)
        this.startActivity(intent)
    }



}

