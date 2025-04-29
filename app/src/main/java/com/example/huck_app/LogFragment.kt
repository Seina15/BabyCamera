package com.example.huck_app

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageButton
import androidx.fragment.app.Fragment

// ログのふらぐめんと
class LogFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        val view = inflater.inflate(R.layout.activity_log_fragment, container, false)

        val logStartButton: AppCompatImageButton = view.findViewById(R.id.log_start)

        logStartButton.setOnClickListener {
            val intent = Intent(activity, LogMode::class.java)
            startActivity(intent)
        }

        return view
    }
}
