package com.sunnyswag.textgan.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import com.sunnyswag.textgan.databinding.FragmentGenerateBinding
import com.sunnyswag.textgan.viewmodel.GenerateViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class GenerateFragment: Fragment() {

    private lateinit var _binding: FragmentGenerateBinding
    private val _viewModel: GenerateViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGenerateBinding.inflate(inflater, container, false)
        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding.top.apply {
            setOnClickListener {
                _viewModel.startFlow()
            }
        }

        lifecycleScope.launch {
            _viewModel.testData
                .flowWithLifecycle(lifecycle)
                .collectLatest {
                    _binding.top.text = it.toString()
                }
        }
    }
}