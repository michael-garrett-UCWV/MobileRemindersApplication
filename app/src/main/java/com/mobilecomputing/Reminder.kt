package com.mobilecomputing

import java.time.LocalDateTime

data class Reminder constructor(
    val title: String,
    val description: String?,
    val isCompleted: Boolean = false,
    val createdDate: String,
    val remindDate: String,
    val tag: String = "Home"
)
