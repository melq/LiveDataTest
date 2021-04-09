package com.melq.livedatatest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.melq.livedatatest.databinding.FragmentMainBinding

class FragmentMain : Fragment() {
    private lateinit var binding: FragmentMainBinding

    private val viewModel = MainViewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        binding.vm = viewModel
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.button.setOnClickListener {
            viewModel.submitText(binding.editText.text.toString())
        }

        binding.editText.addTextChangedListener { text ->
            viewModel.updateButton(text.isNullOrBlank())
        }
    }
}