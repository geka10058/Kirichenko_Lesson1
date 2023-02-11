package com.aston_lesson1.data


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "task_table")
data class Task(
    @PrimaryKey @ColumnInfo(name = "title") var title: String,
    @ColumnInfo(name = "description") var description: String
)
