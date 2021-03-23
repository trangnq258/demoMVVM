package com.example.demomvvm.ui.detail

import android.graphics.text.LineBreaker
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.example.demomvvm.R
import com.example.demomvvm.databinding.FragmentDetailBinding
import com.example.demomvvm.utlis.showToast
import kotlinx.android.synthetic.main.fragment_detail.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import com.example.demomvvm.BR

class DetailFragment : Fragment() {

    private val detailViewModel by viewModel<DetailViewModel>()
    private val args: DetailFragmentArgs by navArgs()
    private var binding: FragmentDetailBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = DataBindingUtil
        .inflate<FragmentDetailBinding>(inflater, R.layout.fragment_detail, container, false)
        .apply { binding = this }
        .root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initData()
        observeData()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            textDescription.justificationMode = LineBreaker.JUSTIFICATION_MODE_INTER_WORD
        }
        imageFavorite.setOnClickListener {
            detailViewModel.updateFavorite()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }

    private fun initData() {
        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            setVariable(BR.detailVM, detailViewModel)
            detailViewModel.loadDetail(args.idImage)
        }
    }

    private fun observeData() =
        detailViewModel.error.observe(viewLifecycleOwner, Observer {
            context?.showToast(it)
        })
}
