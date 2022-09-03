package com.sunnyswag.textgan.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class GenerateViewModel: ViewModel() {

    private val _testData: MutableStateFlow<Int> = MutableStateFlow(0)
    val testData: StateFlow<Int>
        get() = _testData

    fun startFlow() {
        viewModelScope.launch {
            _testData.apply {
                repeat(5) {
                    emit(it)
                    delay(500)
                }
            }
        }
    }
}