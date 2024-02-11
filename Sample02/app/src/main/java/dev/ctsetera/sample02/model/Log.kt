package dev.ctsetera.sample02.model

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Data class that represent the a table in the database.
 */
@Entity(tableName = "logs")
data class Log(val msg: String, val timestamp: Long) {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}