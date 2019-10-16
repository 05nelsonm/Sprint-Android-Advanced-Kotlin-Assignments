package com.x05nelsonm.extensionfunctions

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.widget.ImageView
import androidx.core.app.NotificationCompat
import com.bumptech.glide.Glide

fun Context.showNotification(
    notificationId: Int,
    channelId: String,
    contentTitle: String,
    contentText: String,
    notificationManagerImportance: Int,
    colorized: Boolean,
    resourceColor: Int
    ) {
    
    
    val channelId = "${this.packageName}.$channelId"
    val notificationManager = this.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        val name = channelId
        val description = "Notification channel"

        val channel = NotificationChannel(channelId, name, notificationManagerImportance)
        channel.description = description

        notificationManager.createNotificationChannel(channel)
    }

    val notificationBuilder = NotificationCompat.Builder(this, channelId)
        .setPriority(notificationManagerImportance)
        .setSmallIcon(android.R.drawable.alert_dark_frame)
        .setContentTitle(contentTitle)
        .setContentText(contentText)
        .setAutoCancel(true)
    
    if (colorized) {
        notificationBuilder
            .setColorized(true)
            .setColor(resourceColor)
    }
    notificationManager.notify(notificationId, notificationBuilder.build())
}

fun ImageView.loadImageFromUrl(url: String) {
    Glide.with(this).load(url).into(this)
}