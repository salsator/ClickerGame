package com.example.clickergame40


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
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



        /// TabLayout deklarace a propojení
        val pager = binding.viewPager
        val tl = binding.tabLayout
        pager.adapter = ViewPagerAdapter(supportFragmentManager, lifecycle)

        TabLayoutMediator(tl, pager)
        { tab, position ->
            tab.text = tabTitle[position]
        }.attach()


    }
}