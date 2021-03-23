package com.example.demomvvm.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.demomvvm.BR
import com.example.demomvvm.R
import com.example.demomvvm.data.model.Breed
import com.example.demomvvm.databinding.FragmentHomeBinding
import com.example.demomvvm.ui.adapter.BreedAdapter
import com.example.demomvvm.utlis.showToast
import kotlinx.android.synthetic.main.fragment_home.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {
    private val adapter = BreedAdapter(::clickFavorite)
    private val homeViewModel by viewModel<HomeViewModel>()
    private var binding: FragmentHomeBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = DataBindingUtil
        .inflate<FragmentHomeBinding>(inflater, R.layout.fragment_home, container, false)
        .apply { binding = this }
        .root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerBreed.adapter = adapter
        initData()
        observeData()
    }

    private fun initData() {
        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            setVariable(BR.homeVM, homeViewModel)
        }
    }

    private fun observeData() = with(homeViewModel) {
        error.observe(viewLifecycleOwner, Observer {
            context?.showToast(it)
        })
    }

    private fun clickFavorite(breed: Breed) {
        val action =
            HomeFragmentDirections.actionHomeFragmentToDetailFragment(breed.referenceImageId)
        findNavController().navigate(action)
    }
}
