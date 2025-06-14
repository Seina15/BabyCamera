package com.example.huck_app

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.fragment.app.Fragment

// 見守りモードのフラグめんと
// ボタン押して、Modeを開始する
class VideoFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.activity_video_fragment, container, false)

        val videoStartButton = view.findViewById<ImageButton>(R.id.video_start) // ImageButton にキャスト

        videoStartButton.setOnClickListener {
            val intent = Intent(activity, VideoMode::class.java)
            startActivity(intent)
        }

        return view
    }
}
