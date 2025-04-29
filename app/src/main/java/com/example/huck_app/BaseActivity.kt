package com.example.huck_app

import android.content.Context
import android.content.SharedPreferences
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView


// ホーム画面
open class BaseActivity : AppCompatActivity() {
    private lateinit var preferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        // ThemePrefsを初期化し、選択されたテーマを適用
        preferences = getSharedPreferences("ThemePrefs", Context.MODE_PRIVATE)
        applyTheme()

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)

        // ナビゲーションコントローラーとボトム?ナビゲーションビューを設定
        val navController = findNavController(R.id.nav_main_fragment)
        val bNavView = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        setupWithNavController(bNavView, navController)

        // テーマに基づいてアイコンを設定
        setBottomNavBarIcon(bNavView)
    }

    // アプリのテーマ変更（切り替え） 
    //setTheme : 背景・色
    //setBarColor : ナビゲーションバーの色 
    private fun applyTheme() {
        val selectedTheme = preferences.getString("selectedTheme", "YellowTheme")
        when (selectedTheme) {
            "YellowTheme" -> {
                setTheme(R.style.Yellow_Theme)
                setBarColor(R.color.yellow_primary_dark, R.color.yellow_primary)
            }
            "BlueTheme" -> {
                setTheme(R.style.Blue_Theme)
                setBarColor(R.color.blue_primary_dark, R.color.blue_primary)
            }
            "PurpleTheme" -> {
                setTheme(R.style.Purple_Theme)
                setBarColor(R.color.purple_primary_dark, R.color.purple_primary)
            }
        }
    }


    // barColor：ステータスバー（画面上の）
    // navBarColor：ナビゲーションバー（画面下部の） 
    private fun setBarColor(barColor: Int, navBarColor: Int) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.statusBarColor = ContextCompat.getColor(this, barColor)
            window.navigationBarColor = ContextCompat.getColor(this, navBarColor)
        }
    }

    // ボトムバー（下のナビゲーションバー）のアイコンを変更
    //後で修正します、、
    private fun setBottomNavBarIcon(bNavView: BottomNavigationView) {
        val selectedTheme = preferences.getString("selectedTheme", "YellowTheme")
        when (selectedTheme) {
            "YellowTheme" -> {
                bNavView.menu.findItem(R.id.navi_home).icon = ContextCompat.getDrawable(this, R.drawable.yellow_home)
                bNavView.menu.findItem(R.id.navi_log).icon = ContextCompat.getDrawable(this, R.drawable.yellow_alart)
                bNavView.menu.findItem(R.id.navi_video).icon = ContextCompat.getDrawable(this, R.drawable.yellow_video)
            }
            "BlueTheme" -> {
                bNavView.menu.findItem(R.id.navi_home).icon = ContextCompat.getDrawable(this, R.drawable.blue_home)
                bNavView.menu.findItem(R.id.navi_log).icon = ContextCompat.getDrawable(this, R.drawable.blue_alart)
                bNavView.menu.findItem(R.id.navi_video).icon = ContextCompat.getDrawable(this, R.drawable.blue_video)
            }
            "PurpleTheme" -> {
                bNavView.menu.findItem(R.id.navi_home).icon = ContextCompat.getDrawable(this, R.drawable.purple_home)
                bNavView.menu.findItem(R.id.navi_log).icon = ContextCompat.getDrawable(this, R.drawable.purple_alart)
                bNavView.menu.findItem(R.id.navi_video).icon = ContextCompat.getDrawable(this, R.drawable.purple_video)
            }
        }
    }
}
