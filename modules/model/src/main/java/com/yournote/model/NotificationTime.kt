package com.yournote.model

import kotlinx.datetime.LocalTime

sealed class NotificationTime {
    data class Time(val localTime: LocalTime) : NotificationTime()
    data object PickTime : NotificationTime()
}
