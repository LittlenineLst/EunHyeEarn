package kim.juche.eunhyeearn

import android.net.Uri
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.VideoView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var x = 0
    private lateinit var thankfulnessTextView: TextView
    private var kim4ClickCount = 0
    private lateinit var videoView: VideoView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        thankfulnessTextView = findViewById(R.id.thankfulnessTextView)
        val kim1Button: ImageView = findViewById(R.id.kim1Button)
        val kim2Button: ImageView = findViewById(R.id.kim2Button)
        val kim3Button: ImageView = findViewById(R.id.kim3Button)
        val kim4Button: ImageView = findViewById(R.id.kim4Button)
        val aboutButton: ImageButton = findViewById(R.id.aboutButton)
        videoView = findViewById(R.id.backgroundVideo)

        val videoUri = Uri.parse("android.resource://" + packageName + "/" + R.raw.kim)
        videoView.setVideoURI(videoUri)
        videoView.setOnPreparedListener {
            it.isLooping = true
            videoView.start()
        }

        kim1Button.setOnClickListener {
            x += 1
            updateThankfulnessText()
            checkFor19()
        }

        kim2Button.setOnClickListener {
            x += 2
            updateThankfulnessText()
            checkFor19()
        }

        kim3Button.setOnClickListener {
            x += 3
            updateThankfulnessText()
            checkFor19()
        }

        kim4Button.setOnClickListener {
            if (x == 0) {
                kim4ClickCount += 1
                if (kim4ClickCount >= 3) {
                    showCustomWarningDialog("你在触碰美帝国主义和他的傀儡走狗伪南朝鲜政权的万恶旗帜，多次触碰将会下放劳改")
                }
            }
            x = 0
            updateThankfulnessText()
        }

        aboutButton.setOnClickListener {
            showAboutDialog()
        }
    }

    private fun updateThankfulnessText() {
        thankfulnessTextView.text = "恩情已还：$x"
    }

    private fun checkFor19() {
        if (x == 19) {
            showCustomWarningDialog("伟大的将军不是男同，禁止还19次恩情")
        }
    }

    private fun showCustomWarningDialog(message: String) {
        val builder = AlertDialog.Builder(this)
        val dialogView = layoutInflater.inflate(R.layout.dialog_warning, null)
        builder.setView(dialogView)
        val imageView: ImageView = dialogView.findViewById(R.id.dialogImage)
        val textView: TextView = dialogView.findViewById(R.id.dialogMessage)
        imageView.setImageResource(R.drawable.dprk)
        textView.text = message
        builder.setPositiveButton("确认") { dialog, _ ->
            dialog.dismiss()
        }
        builder.setCancelable(false)
        builder.show()
    }

    private fun showAboutDialog() {
        val builder = AlertDialog.Builder(this)
        val dialogView = layoutInflater.inflate(R.layout.dialog_warning, null)
        builder.setView(dialogView)
        val imageView: ImageView = dialogView.findViewById(R.id.dialogImage)
        val textView: TextView = dialogView.findViewById(R.id.dialogMessage)
        imageView.setImageResource(R.drawable.dprk)
        textView.text = "Made By Littlenine For General Kim At 주체 120년 11월 16일 16:01:43"
        builder.setPositiveButton("确认") { dialog, _ ->
            dialog.dismiss()
        }
        builder.setCancelable(true)
        builder.show()
    }
}
