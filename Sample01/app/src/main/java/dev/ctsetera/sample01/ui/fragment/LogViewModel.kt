package dev.ctsetera.sample01.ui.fragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import dev.ctsetera.sample01.LogApplication
import dev.ctsetera.sample01.model.Log
import dev.ctsetera.sample01.repository.LogRepository
import dev.ctsetera.sample01.util.DateFormatter

class LogViewModel(
    private val logRepository: LogRepository,
    private val dateFormatter: DateFormatter
) : ViewModel() {
    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val serviceLocator =
                    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as LogApplication).serviceLocator
                LogViewModel(
                    logRepository = serviceLocator.logRepository,
                    dateFormatter = serviceLocator.provideDateFormatter(),
                )
            }
        }
    }

    private val mLogList = MutableLiveData<List<String>>()
    val logList: LiveData<List<String>> = mLogList

    fun getAllLogs() {
        logRepository.getAllLogs { logs ->
            mLogList.value = formatLogs(logs)
        }
    }

    private fun formatLogs(logs: List<Log>): List<String> {
        return logs.map { log ->
            "${log.msg}\n\t${dateFormatter.formatDate(log.timestamp)}"
        }
    }
}
