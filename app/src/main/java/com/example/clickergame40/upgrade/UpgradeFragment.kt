package com.example.clickergame40.upgrade

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.clickergame40.GameActivity
import com.example.clickergame40.MainActivity
import com.example.clickergame40.databinding.FragmentUpgradeBinding
import com.example.clickergame40.warClicking.ClickingWar

class UpgradeFragment : Fragment() {

    companion object {
        fun newInstance() = UpgradeFragment()
    }

    private lateinit var viewModel: UpgradeViewModel
    private var _binding: FragmentUpgradeBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentUpgradeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        ).get(UpgradeViewModel::class.java)
        // TODO: Use the ViewModel
    }


    override fun onResume() {
        super.onResume()

        binding.clickBonusBtn.setOnClickListener {
            viewModel.buyClickBonus(0,binding.clickBonusBtn,binding.clickBonusTxt)
        }

        binding.modBonusBtn.setOnClickListener {
            viewModel.buyClickBonus(1,binding.modBonusBtn, binding.ModBonusTxt)
        }

        binding.StartWarBtn.setOnClickListener {
           // viewModel.startWar()
            val intent = Intent (getActivity(), ClickingWar::class.java)
            getActivity()?.startActivity(intent)
        }

        binding.resetWorldBtn.setOnClickListener {
            viewModel.resetWorld()
        }


    }




}