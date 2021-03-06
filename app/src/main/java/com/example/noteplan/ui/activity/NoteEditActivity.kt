package com.example.noteplan.ui.activity

import android.app.Activity
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.noteplan.R
import com.example.noteplan.databinding.ActivityNoteEditBinding

class NoteEditActivity: AppCompatActivity(){

    private val binding: ActivityNoteEditBinding by lazy {
        DataBindingUtil.setContentView<ActivityNoteEditBinding>(this, R.layout.activity_note_edit)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (Build.VERSION.SDK_INT >= 21) {
            val decorView: View = window.decorView
            decorView.systemUiVisibility  = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
            window.statusBarColor = Color.TRANSPARENT
        }
        binding.lifecycleOwner = this
//        binding.lifecycleOwner = this
    }
}