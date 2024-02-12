package dev.ctsetera.sample02.ui.fragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.ctsetera.sample02.application.LogApplication
import dev.ctsetera.sample02.model.Log
import dev.ctsetera.sample02.repository.LogRepository
import dev.ctsetera.sample02.util.DateFormatter
import javax.inject.Inject

@HiltViewModel
class LogViewModel @Inject constructor(
    private val logRepository: LogRepository,
    private val dateFormatter: DateFormatter
) : ViewModel() {

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
