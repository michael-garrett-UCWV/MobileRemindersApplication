package com.mobilecomputing

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.transaction
import com.mobilecomputing.ui.dashboard.ReminderAdapter
import kotlinx.android.synthetic.main.fragment_dashboard.*
import kotlinx.android.synthetic.main.layout_custom_dialog.*

class AddDialogFragment constructor(
    var adapter: ReminderAdapter
): DialogFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        getDialog()!!.getWindow()?.setBackgroundDrawableResource(R.drawable.round_corner);
        return inflater.inflate(R.layout.layout_custom_dialog, container, false)
    }

    override fun onStart() {
        super.onStart()
        val width = (resources.displayMetrics.widthPixels * 0.85).toInt()
        val height = (resources.displayMetrics.heightPixels * 0.40).toInt()
        dialog!!.window?.setLayout(width, ViewGroup.LayoutParams.WRAP_CONTENT)

        btn_add.setOnClickListener {
            adapter.addReminder(
                Reminder(et_title.text.toString(), et_description.text.toString(), false, "", "", "Home")
            )

            fragmentManager?.beginTransaction()?.remove(this)?.commitAllowingStateLoss()
        }
    }

}