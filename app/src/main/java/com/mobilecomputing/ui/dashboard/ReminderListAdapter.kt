package com.mobilecomputing.ui.dashboard

import android.provider.CalendarContract
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.children
import androidx.recyclerview.widget.RecyclerView
import com.mobilecomputing.R
import com.mobilecomputing.Reminder
import kotlinx.android.synthetic.main.reminder_list_item.view.*

class ReminderListAdapter(
    private val reminderLists: MutableMap<String, MutableList<Reminder>>,
    private val reminderTypes: MutableList<String>
) : RecyclerView.Adapter<ReminderListAdapter.ReminderListViewHolder>() {

    init {
        reminderTypes.add("Home")

        for (title in reminderTypes) {
            addReminderList(title, mutableListOf())
        }
    }

    class ReminderListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    fun addReminderList(title: String, reminders: MutableList<Reminder>) {
        reminderLists[title] = reminders
        notifyItemInserted(reminderLists.size - 1)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReminderListViewHolder {
        return ReminderListViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.reminder_list_item,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ReminderListViewHolder, position: Int) {
        holder.itemView.apply {
            listTitle.text = reminderTypes[position]
            }
        }

    override fun getItemCount(): Int {
        return reminderTypes.size
    }
}