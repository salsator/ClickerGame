package com.example.clickergame40


import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.clickergame40.adventure.AdventureFragment
import com.example.clickergame40.shop.ShopFragment
import com.example.clickergame40.upgrade.UpgradeFragment

class ViewPagerAdapter(activity: FragmentManager, lifecycle: Lifecycle): FragmentStateAdapter(activity, lifecycle  ) {


    override fun getItemCount(): Int {
        return 3
    }


    override fun createFragment(position: Int): Fragment {
        when (position) {
            0 -> return AdventureFragment()
            1 -> return ShopFragment()
            2 -> return UpgradeFragment()
            else -> return AdventureFragment()
        }
    }
}