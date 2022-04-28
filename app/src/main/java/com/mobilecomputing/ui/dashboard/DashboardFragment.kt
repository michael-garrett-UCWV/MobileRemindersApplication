package com.mobilecomputing.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mobilecomputing.Reminder
import com.mobilecomputing.databinding.FragmentDashboardBinding
import kotlinx.android.synthetic.main.fragment_dashboard.*
import kotlinx.android.synthetic.main.layout_custom_dialog.view.*
import java.time.LocalDateTime
import android.R
import android.app.Dialog
import android.widget.ImageView
import androidx.fragment.app.FragmentManager
import com.mobilecomputing.AddDialogFragment


class DashboardFragment : Fragment() {

    private lateinit var dashboardViewModel: DashboardViewModel
    private var _binding: FragmentDashboardBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    public lateinit var reminderAdapter: ReminderAdapter
    private lateinit var rv: RecyclerView

    // Add Reminder Pop Up Variables

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dashboardViewModel =
            ViewModelProvider(this).get(DashboardViewModel::class.java)

        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    override fun onStart() {
        super.onStart()

        reminderAdapter = ReminderAdapter(mutableListOf())

        reminders.adapter = reminderAdapter
        reminders.layoutManager = LinearLayoutManager(this.context, LinearLayoutManager.HORIZONTAL, false)
        reminders.layoutManager

        addReminderBtn.setOnClickListener {
            showDialog(reminderAdapter)
        }
    }

    private fun showDialog(adapter: ReminderAdapter) {
        AddDialogFragment(adapter).show(childFragmentManager, "MyCustomFragment")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}