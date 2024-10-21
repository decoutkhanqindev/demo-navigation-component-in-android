package com.example.demonavigationcomponetinandroid

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.demonavigationcomponetinandroid.databinding.FragmentMyThirdBinding

class MyThirdFragment: Fragment() {
  private var _binding: FragmentMyThirdBinding? = null
  private val binding: FragmentMyThirdBinding get() = _binding!!
  
  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    _binding = FragmentMyThirdBinding.inflate(inflater, container, false)
    return binding.root
  }
  
  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    
    binding.button1.setOnClickListener {
      findNavController().navigate(R.id.action_myThirdFragment_to_mySecondFragment)
    }
    
    binding.button2.setOnClickListener {
      findNavController().navigate(R.id.action_myThirdFragment_to_myHomeFragment)
    }
  }
  
  override fun onDestroy() {
    _binding = null
    super.onDestroy()
  }
}