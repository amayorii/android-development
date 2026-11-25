package com.example.lab1

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class MainViewModel : ViewModel() {
    private val repository = TransportRepository()

    private val _items = MutableStateFlow<List<TransportItem>>(emptyList())
    val items: StateFlow<List<TransportItem>> = _items.asStateFlow()

    init {
        loadData()
    }

    private fun loadData() {
        _items.value = repository.getTransportList()
    }
}