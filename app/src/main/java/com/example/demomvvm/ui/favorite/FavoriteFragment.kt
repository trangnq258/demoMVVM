package com.example.demomvvm.ui.favorite

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
import com.example.demomvvm.data.model.Detail
import com.example.demomvvm.databinding.FragmentFavoriteBinding
import com.example.demomvvm.ui.adapter.FavoriteAdapter
import com.example.demomvvm.utlis.showToast
import kotlinx.android.synthetic.main.fragment_favorite.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class FavoriteFragment : Fragment() {
    private val adapter = FavoriteAdapter(::clickFavorite)
    private val favoriteViewModel by viewModel<FavoriteViewModel>()
    private var binding: FragmentFavoriteBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = DataBindingUtil
        .inflate<FragmentFavoriteBinding>(inflater, R.layout.fragment_favorite, container, false)
        .apply { binding = this }
        .root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerFavorite.adapter = adapter
        initData()
        observeData()
    }

    private fun initData() {
        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            setVariable(BR.favoriteVM, favoriteViewModel)
        }
    }

    private fun observeData() = with(favoriteViewModel) {
        error.observe(viewLifecycleOwner, Observer {
            context?.showToast(it)
        })
    }

    private fun clickFavorite(breed: Detail) {
        val action = FavoriteFragmentDirections.actionFavoriteFragmentToDetailFragment(breed.id)
        findNavController().navigate(action)
    }
}
