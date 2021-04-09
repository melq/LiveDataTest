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
                mutableLiveData.value = "ここに出力されます" // ほんとはgetStringしたい
            }
    val submittedText: LiveData<String> get() = _submittedText

    private val _buttonTextSub: MutableLiveData<String> =
            MutableLiveData<String>().also { mutableLiveData ->
                mutableLiveData.value = "OK!!"
            }
    val buttonTextSub: LiveData<String> get() = _buttonTextSub

    private val _isEnabledSub: MutableLiveData<Boolean> =
            MutableLiveData<Boolean>().also { mutableLiveData ->
                mutableLiveData.value = false
            }
    val isEnabledSub: LiveData<Boolean> get() = _isEnabledSub

    private val _submittedTextSub: MutableLiveData<String> =
            MutableLiveData<String>().also { mutableLiveData ->
                mutableLiveData.value = "ここに出力されます"
            }
    val submittedTextSub: LiveData<String> = _submittedTextSub



    fun updateButton(isBlank: Boolean) {
        _isEnabled.value = !isBlank

        _buttonText.value =
                if (isBlank) "NO!!"
                else "OK!!"
    }
    fun updateButtonSub(isBlank: Boolean) {
        _isEnabledSub.value = !isBlank

        _buttonTextSub.value =
                if (isBlank) "NO!!"
                else "OK!!"
    }

    fun submitText(text: String) {
        _submittedText.value = text
//        _submittedTextSub.value = text + text
    }
    fun submitTextSub(text: String) {
        _submittedTextSub.value = text
    }
}