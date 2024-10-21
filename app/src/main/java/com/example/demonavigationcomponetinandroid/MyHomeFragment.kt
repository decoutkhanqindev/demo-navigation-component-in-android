package com.example.demonavigationcomponetinandroid

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.demonavigationcomponetinandroid.databinding.FragmentMyHomeBinding

class MyHomeFragment: Fragment() {
  private var _binding: FragmentMyHomeBinding? = null
  private val binding: FragmentMyHomeBinding get() = _binding!!
  
  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    _binding = FragmentMyHomeBinding.inflate(inflater, container, false)
    return binding.root
  }
  
  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    
    binding.button.setOnClickListener {
      findNavController().navigate(R.id.action_myHomeFragment_to_mySecondFragment)
    }
  }
  
  override fun onDestroy() {
    _binding = null
    super.onDestroy()
  }
}