package com.aston_lesson1.data


import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Task(
    var title: String = "",
    var description: String = ""
): Parcelable
