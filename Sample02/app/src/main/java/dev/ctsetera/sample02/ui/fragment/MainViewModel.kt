package dev.ctsetera.sample02.ui.fragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.ctsetera.sample02.application.LogApplication
import dev.ctsetera.sample02.repository.LogRepository
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val logRepository: LogRepository
) : ViewModel() {
    fun addLog(msg: String) {
        logRepository.addLog(msg)
    }

    fun deleteLogs() {
        logRepository.removeLogs()
    }
}