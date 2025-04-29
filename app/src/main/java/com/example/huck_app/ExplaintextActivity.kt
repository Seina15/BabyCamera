package com.example.huck_app

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ExplaintextActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_explaintext)

        // 戻るボタン
        val childButton = findViewById<Button>(R.id.return_home)
        childButton.setOnClickListener {
            val intent = Intent(this, BaseActivity::class.java)
            startActivity(intent)
        }

        // WindowInsets
        //https://developer.android.com/develop/ui/compose/system/insets?hl=ja
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val label = intent.getStringExtra("label")

        val textView = findViewById<TextView>(R.id.label_text_view)
        textView.text = label ?: "ラベルが見つかりません"

        val ExplainTextView = findViewById<TextView>(R.id.explain_text)
        ExplainTextView.text = getExplainText(label)

        val adviceTextView = findViewById<TextView>(R.id.advice_text)
        adviceTextView.text = getAdviceText(label)

        val imageView = findViewById<ImageView>(R.id.denger_image)
        setLabelsImage(label, imageView)

        val imagView = findViewById<ImageView>(R.id.advice_image)
        setLabelsImage2(label, imagView)
    }
    // ラベルに応じた注意点
    private fun getExplainText(label: String?): String {
        return when (label) {
            "コード" -> "コンセントや延長コードを口にくわえると、口や唇をやけどする可能性があり非常に危険です。\n" +
                    "濡れた手でコンセントやプラグに触れると、電気が体に通りやすくなり感電のリスクが高まります。\n" +
                    "プラグが完全に差し込まれていなかったり、隙間に金属製の物を入れたりすると、感電する危険性があります。"
            "角" -> "活発に動き回る子供が思わぬ場所で転んだりぶつかったりすることがあります。\n" +
                    "これにより頭部や顔、眼球に重度の傷を負う可能性があります。\n特にローテーブルなどは、子供の目線や頭の高さに来ることが多いため対策が必要です。"
            else -> "特定のアドバイスはありません。"
        }
    }

    // ラベルに応じたアドバイス
    private fun getAdviceText(label: String?): String {
        return when (label) {
            "コード" -> "使用していないコンセントには、いたずら防止用のコンセントキャップを取り付けましょう。\n" +
                    "コンセント全体を覆い、より安全なコンセントカバーの使用も検討しましょう。\n" +
                    "子供の興味を引かないシンプルな形状や色のものを選びましょう。"
            "角" -> "家具の角に柔らかい素材のクッションを取り付けることで、衝撃を吸収し、ケガを防止します。\n" +
                    "木製の家具は、プラスチック製の家具に比べて、衝撃を吸収しやすいため、安全です。"

            else -> "特定のアドバイスはありません。"
        }
    }

    // ラベルに応じた画像
    private fun setLabelsImage(label: String?, imageView: ImageView) {
        val imageResId = when (label) {
            "角" -> R.drawable.kado
            "コード" -> R.drawable.code
            else -> R.drawable.kado 
        }

        imageView.setImageResource(imageResId)
    }

    // ラベルに応じたアドバイス画像
    private fun setLabelsImage2(label: String?, imageView: ImageView) {
        val imageResId = when (label) {
            "角" -> R.drawable.kado2 
            "コード" -> R.drawable.code2
            else -> R.drawable.kado
        }

        imageView.setImageResource(imageResId)
    }
}