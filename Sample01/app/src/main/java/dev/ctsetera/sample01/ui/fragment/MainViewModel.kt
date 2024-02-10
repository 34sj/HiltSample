package dev.ctsetera.sample01.ui.fragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import dev.ctsetera.sample01.LogApplication
import dev.ctsetera.sample01.repository.LogRepository

class MainViewModel(private val logRepository: LogRepository) : ViewModel() {

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                MainViewModel(
                    logRepository = (this[APPLICATION_KEY] as LogApplication).serviceLocator.logRepository,
                )
            }
        }
    }

    fun addLog(msg: String) {
        logRepository.addLog(msg)
    }

    fun deleteLogs() {
        logRepository.removeLogs()
    }
}