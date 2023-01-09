package com.example.clickergame40


import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.clickergame40.databinding.ActivityGameBinding
import com.google.android.material.tabs.TabLayoutMediator


class GameActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGameBinding

    val tabTitle = arrayOf("Výprava","Obchod","Vylepšeni")
    lateinit var viewModel: GameActivityViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityGameBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)



        binding.vyhraSilaBar.max = 99

        /// TabLayout deklarace a propojení
        val pager = binding.viewPager
        val tl = binding.tabLayout
        pager.adapter = ViewPagerAdapter(supportFragmentManager, lifecycle)

        TabLayoutMediator(tl, pager)
        { tab, position ->
            tab.text = tabTitle[position]
        }.attach()

        // ViewModel deklarace
        viewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        ).get(GameActivityViewModel::class.java)


      viewModel.mediator.golds.observe(this) {
           binding.goldsTxt.text = it.toString()
       }
        viewModel.mediator.income.observe(this, Observer {
            binding.IncomeTxt.text = it.toString()
        })
        viewModel.mediator.days.observe(this, Observer {
            binding.dayTxt.text = it.toString()
        })

        viewModel.mediator.cycle.observe(this, Observer {
            binding.vyhraSilaBar.progress = it
        })
    }

    override fun onResume() {
        super.onResume()




    }


}

