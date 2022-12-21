package com.example.clickergame40.shop

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.clickergame40.Mediator
import com.example.clickergame40.adventure.AdventureViewModel
import com.example.clickergame40.databinding.FragmentShopBinding

class ShopFragment : Fragment() {

    companion object {
        fun newInstance() = ShopFragment()
    }

    private lateinit var viewModel: ShopViewModel
    private var _binding: FragmentShopBinding? = null
    private val binding get() = _binding!!





    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentShopBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this)[ShopViewModel::class.java]
        // TODO: Use the ViewModel
    }



    override fun onResume() {
        super.onResume()

        binding.buyFarmerBtn.setOnClickListener {
            viewModel.buyHeroes(0, binding.buyFarmerBtn, binding.priceFarmerTxt)
        }
       binding.buyFighterBtn.setOnClickListener {
            viewModel.buyHeroes(1, binding.buyFighterBtn, binding.priceFighterTxt)
        }
        binding.buyRogueBtn.setOnClickListener {
            viewModel.buyHeroes(2,binding.buyRogueBtn,binding.priceRogueTxt)
        }
        binding.buyWizardBtn.setOnClickListener {
            viewModel.buyHeroes(3,binding.buyWizardBtn,binding.priceWizardTxt)
        }
        binding.buyChampionBtn.setOnClickListener {
            viewModel.buyHeroes(4,binding.buyChampionBtn,binding.priceChampionTxt)
        }
        binding.buyGodBtn.setOnClickListener {
            viewModel.buyHeroes(5,binding.buyGodBtn,binding.priceGodTxt)
        }

    }


}