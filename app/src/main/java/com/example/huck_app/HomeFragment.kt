package com.example.huck_app

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.fragment.app.Fragment

// ホーム用のフラグメント
class HomeFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.activity_home_fragment, container, false)

        val childButton = view.findViewById<ImageButton>(R.id.ditector_button)
        childButton?.setOnClickListener {
            val intent = Intent(activity, Detector_Page::class.java)
            intent.putExtra("BUTTON_ID", R.id.ditector_button)
            startActivity(intent)
        }

        val settingButton = view.findViewById<ImageButton>(R.id.setting_button)
        settingButton?.setOnClickListener {
            val intent = Intent(activity, Setting::class.java)
            startActivity(intent)
        }
        return view
    }
}
