package com.example.clickergame40.adventure


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.clickergame40.Mediator
import com.example.clickergame40.R
import com.example.clickergame40.databinding.FragmentAdventureBinding

class AdventureFragment : Fragment() {

    companion object {
        fun newInstance() = AdventureFragment()
    }


    private var _binding: FragmentAdventureBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAdventureBinding.inflate(inflater, container, false)
        return binding.root
    }




    override fun onResume() {
        super.onResume()

        binding.clickBtn.setOnClickListener {
           Mediator.click()
        }

        }

}