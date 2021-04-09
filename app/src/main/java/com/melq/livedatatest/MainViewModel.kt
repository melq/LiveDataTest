package com.melq.livedatatest

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class MainViewModel {
    private val _buttonText: MutableLiveData<String> =
            MutableLiveData<String>().also { mutableLiveData ->
                mutableLiveData.value = "OK!!"
            }
    val buttonText: LiveData<String> get() = _buttonText

    private val _isEnabled: MutableLiveData<Boolean> =
            MutableLiveData<Boolean>().also { mutableLiveData ->
                mutableLiveData.value = false
            }
    val isEnabled: LiveData<Boolean> get() = _isEnabled

    private val _submittedText: MutableLiveData<String> =
            MutableLiveData<String>().also { mutableLiveData ->
                mutableLiveData.value = R.string.output_here.toString()
            }
    val submittedText: LiveData<String> get() = _submittedText

    fun updateButton(isBlank: Boolean) {
        _isEnabled.value = !isBlank

        _buttonText.value =
                if (isBlank) "NO!!"
                else "OK!!"
    }

    fun submitText(text: String) {
        _submittedText.value = text
    }
}