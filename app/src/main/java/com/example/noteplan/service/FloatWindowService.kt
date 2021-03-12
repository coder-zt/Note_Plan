package com.example.noteplan.service

import android.app.Service
import android.content.Intent
import android.os.Build
import android.os.IBinder
import android.provider.Settings
import android.util.Log
import com.example.noteplan.manager.FloatWindowManager

class FloatWindowService:Service() {

    private val TAG = "FloatWindowService"

    override fun onBind(intent: Intent?): IBinder?{
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.e("startService", "onStartCommand")
        return START_STICKY
    }

    override fun onCreate() {
        super.onCreate()
        Log.d(TAG, "onCreate: ")
        if(Build.VERSION.SDK_INT >23){
            if(!Settings.canDrawOverlays(applicationContext)) run {
                val intent: Intent = Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION)
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                startActivity(intent)
            }
        }
        FloatWindowManager.createSmallFloatView(applicationContext)
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}