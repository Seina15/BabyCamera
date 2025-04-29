package com.example.huck_app

import android.animation.Animator
import android.animation.AnimatorInflater
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.huck_app.databinding.ActivityMainBinding


// ホーム画面
// タップでホーム画面に繊維
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var set: Animator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).apply {
            setContentView(this.root)
        }

        // アニメーションの読み込み（点滅アニメーション:blink_animation） 
        set = AnimatorInflater.loadAnimator(this, R.animator.blink_animation).apply {
            setTarget(binding.TapText)
        }

        // タップイベント
        binding.root.setOnClickListener {
            val intent = Intent(this, BaseActivity::class.java)
            startActivity(intent)
        }
    }

    //すたーと
    override fun onStart() {
        super.onStart()
        set.start()
    }
}
