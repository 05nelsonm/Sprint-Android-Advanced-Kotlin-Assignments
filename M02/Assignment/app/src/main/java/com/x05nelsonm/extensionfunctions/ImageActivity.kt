package com.x05nelsonm.extensionfunctions

import androidx.appcompat.app.AppCompatActivity

import android.os.Bundle
import kotlinx.android.synthetic.main.activity_image.*

class ImageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image)

        val imageUrl = "https://own-your-data.us.to/index.php/s/2CWPznwJNroTnEm/download"
        image_view.loadImageFromUrl(imageUrl)
    }
}
