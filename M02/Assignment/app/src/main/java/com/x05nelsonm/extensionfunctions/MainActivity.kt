package com.x05nelsonm.extensionfunctions

import android.app.NotificationManager
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_notification.setOnClickListener {
            showNotification(
                0,
                "",
                "",
                "This is my Notification",
                NotificationManager.IMPORTANCE_HIGH,
                true,
                ContextCompat.getColor(this, R.color.colorPrimary)
            )
        }
        
        button_download.setOnClickListener {
            val intent = Intent(this, ImageActivity::class.java)
            startActivity(intent)
        }
    }
}
