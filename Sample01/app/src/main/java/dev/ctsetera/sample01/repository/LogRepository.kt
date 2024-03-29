package dev.ctsetera.sample01.repository

import android.os.Handler
import android.os.Looper
import dev.ctsetera.sample01.model.Log
import dev.ctsetera.sample01.model.LogDao
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

/**
 * Data manager class that handles data manipulation between the database and the UI.
 */
class LogRepository(private val logDao: LogDao) {

    private val executorService: ExecutorService = Executors.newFixedThreadPool(4)
    private val mainThreadHandler by lazy {
        Handler(Looper.getMainLooper())
    }

    fun addLog(msg: String) {
        executorService.execute {
            logDao.insertAll(
                Log(
                    msg,
                    System.currentTimeMillis()
                )
            )
        }
    }

    fun getAllLogs(callback: (List<Log>) -> Unit) {
        executorService.execute {
            val logs = logDao.getAll()
            mainThreadHandler.post { callback(logs) }
        }
    }

    fun removeLogs() {
        executorService.execute {
            logDao.nukeTable()
        }
    }
}
