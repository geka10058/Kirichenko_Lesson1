package com.aston_lesson1.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertTask(task:Task)

    @Query("SELECT * FROM task_table ORDER BY title ASC")
    fun getTaskList(): Flow<List<Task>>
}