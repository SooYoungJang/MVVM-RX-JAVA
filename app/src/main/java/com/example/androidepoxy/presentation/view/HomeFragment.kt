package com.example.androidepoxy.presentation.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.airbnb.epoxy.Carousel
import com.example.androidepoxy.databinding.FragmentHomeBinding
import com.example.androidepoxy.presentation.epoxy.ProductListController
import com.example.androidepoxy.presentation.model.SearchParams
import com.example.androidepoxy.presentation.utils.GridSpacingItemDecoration
import com.example.androidepoxy.presentation.utils.dp
import com.example.androidepoxy.presentation.viewModel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private val TAG = HomeFragment::class.java.simpleName

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val vm: HomeViewModel by viewModels()
    private val albumListController = ProductListController() //epoxy controller

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater, container, false).apply {
            productRcv.setHasFixedSize(true)
            productRcv.setController(albumListController)
            productRcv.layoutManager = GridLayoutManager(context, 3)
            productRcv.addItemDecoration(GridSpacingItemDecoration(16.dp(), true))
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        Carousel.setDefaultGlobalSnapHelperFactory(null)


        vm.getMovielist(SearchParams("아이언맨","US"))

        vm.productList.observe(viewLifecycleOwner, Observer {
            Log.d(TAG," test 코드 == ${it.movieItem.get(0).title}")
            albumListController.setData(it.movieItem)
        })
    }



    override fun onDestroyView() {
        super.onDestroyView()
        binding.productRcv.adapter = null
        _binding = null
    }
}
