package com.example.noteplan.ui.activity

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.Gravity
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.setupWithNavController
import com.example.noteplan.R
import com.example.noteplan.databinding.ActivityMainBinding
import com.example.noteplan.service.FloatWindowService
import com.google.android.material.navigation.NavigationView


class MainActivity : AppCompatActivity(){

    private val TAG = "MainActivity"
    private val binding:ActivityMainBinding by lazy {
        DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
    }
    private val navController:NavController by lazy{
        Navigation.findNavController(this, R.id.fragment_home)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (Build.VERSION.SDK_INT >= 21) {
            val decorView: View = window.decorView
            decorView.systemUiVisibility  = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
            window.statusBarColor = Color.TRANSPARENT
        }
        binding.lifecycleOwner = this
        initListener()
    }

//    @SuppressLint("WrongConstant")
//    override fun onBackPressed() {
//        if(binding.dlLayout.isOpen){
//            binding.dlLayout.closeDrawer(Gravity.START)
//        }else{
//            super.onBackPressed()
//        }
//    }

    private fun initListener() {
        binding.bnvBottomBar.setupWithNavController(navController)
        binding.btnStart.setOnClickListener(){
            val intent = Intent(applicationContext, FloatWindowService::class.java)
            startService(intent)
        }
    }

}