package com.mobilecomputing.ui.dashboard

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mobilecomputing.R
import com.mobilecomputing.Reminder
import kotlinx.android.synthetic.main.reminder_item.view.*

class ReminderAdapter (
    private val reminderList: MutableList<Reminder>
    ) : RecyclerView.Adapter<ReminderAdapter.ReminderViewHolder>() {

    class ReminderViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    fun addReminder(reminder: Reminder) {
        reminderList.add(reminder)
        notifyItemInserted(reminderList.size - 1)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReminderViewHolder {
        return ReminderAdapter.ReminderViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.reminder_item,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ReminderViewHolder, position: Int) {
        val curReminder = reminderList[position]
        holder.itemView.apply {
            reminderTitle.text = curReminder.title
            reminderDate.text = curReminder.remindDate.toString()
            cBox.isChecked = curReminder.isCompleted
        }
    }

    override fun getItemCount(): Int {
        return reminderList.size
    }


}