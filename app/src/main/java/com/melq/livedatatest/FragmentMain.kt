package com.melq.livedatatest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import com.melq.livedatatest.databinding.FragmentMainBinding

class FragmentMain : Fragment() {
    private lateinit var binding: FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonText = "OK!!"
        binding.frameLayoutSub.buttonText = "OK!!!!"

        binding.editText.addTextChangedListener {
            binding.frameLayoutSub.textView.text = it
        }
        binding.frameLayoutSub.editText.addTextChangedListener {
            binding.textView.text = it
        }

    }
}