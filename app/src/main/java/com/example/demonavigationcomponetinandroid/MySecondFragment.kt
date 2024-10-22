package com.example.demonavigationcomponetinandroid

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.demonavigationcomponetinandroid.databinding.FragmentMySecondBinding
import kotlin.math.log

class MySecondFragment : Fragment() {
  private var _binding: FragmentMySecondBinding? = null
  private val binding: FragmentMySecondBinding get() = _binding!!
  
  private val args: MySecondFragmentArgs by navArgs()
  
  private var user: User? = null
  
  @RequiresApi(Build.VERSION_CODES.TIRAMISU)
  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
  ): View {
    _binding = FragmentMySecondBinding.inflate(inflater, container, false)
    return binding.root
  }
  
  @SuppressLint("SetTextI18n")
  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    
    binding.apply {
      // safe-args way
      number.text = args.number
      message.text = args.message

      user = args.user
      userId.text = user?.id
      userName.text = user?.name
      userAddress.text = user?.address
      
//      // bundle way
//      number.text = arguments?.getString("number")
//      message.text = arguments?.getString("message")
//
//      user = arguments?.getParcelable("user")
//      userId.text = user?.id
//      userName.text = user?.name
//      userAddress.text = user?.address
      
      button.setOnClickListener {
        findNavController().navigate(R.id.action_mySecondFragment_to_myThirdFragment)
      }
    }
  }
  
  override fun onDestroy() {
    _binding = null
    super.onDestroy()
  }
}