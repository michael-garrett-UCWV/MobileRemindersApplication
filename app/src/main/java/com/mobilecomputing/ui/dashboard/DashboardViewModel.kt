package com.mobilecomputing.ui.dashboard

import android.provider.CalendarContract
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mobilecomputing.Reminder

class DashboardViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is dashboard Fragment"
    }
    val text: LiveData<String> = _text

    private val _reminders = MutableLiveData<MutableList<Reminder>>()
    val reminders: LiveData<MutableList<Reminder>>? = null

}