package com.example.androidepoxy.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.androidepoxy.R
import com.example.androidepoxy.databinding.ActivityMainBinding

class HomeFragment : Fragment() {

    private var _binding: FragmenHo? = null
    private val binding get() = _binding!!
    private val TAG = HomeFragment::class.java.simpleName

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

}
