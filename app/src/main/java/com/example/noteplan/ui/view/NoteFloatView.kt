package com.example.noteplan.ui.view

import android.content.Context
import android.graphics.Color
import android.graphics.Point
import android.text.Layout
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.ViewConfiguration
import android.view.WindowManager
import android.widget.ImageView
import android.widget.LinearLayout
import com.example.noteplan.R
import com.example.noteplan.manager.FloatWindowManager

/**
 * 编辑笔记的顶部浮窗
 */
class NoteFloatView(context: Context):LinearLayout(context) {


    private val TAG = "SmallFloatView"
    private var statusBarHeight = 0
    //记录前一次的触摸坐标
    private var touchDownPoint:Point = Point()
    //记录前一次的触摸坐标
    private var preTouchPoint:Point = Point()
    //记录当前的触摸坐标
    private var currentTouchPoint:Point = Point()
    //记录当前的触摸坐标
    private var currentScreenPoint:Point = Point()
    private val windowManager by lazy {
         context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
    }
    private var windowLP:WindowManager.LayoutParams? = null
    private val mTouchSlop by lazy{
        ViewConfiguration.get(context).scaledTouchSlop
    }
    init{
        LayoutInflater.from(context).inflate(R.layout.note_float_view, this)
    }



    override fun onTouchEvent(event: MotionEvent?): Boolean {
        if (event != null) {
            preTouchPoint.apply {
                x = currentScreenPoint.x
                y = currentScreenPoint.y
            }
            currentScreenPoint.apply {
                x = event.rawX.toInt()
                y = event.rawY.toInt()-getStatusBarHeight()
            }

            when(event.action){
                MotionEvent.ACTION_DOWN->{
                    currentTouchPoint.apply {
                        x = event.x.toInt()
                        y = event.y.toInt()
                    }
                    touchDownPoint.apply {
                        x = event.rawX.toInt()
                        y = event.rawY.toInt()-getStatusBarHeight()
                    }
                }
                MotionEvent.ACTION_MOVE->{
                    if(Math.abs(currentTouchPoint.x - preTouchPoint.x) > mTouchSlop || Math.abs(currentTouchPoint.y - preTouchPoint.y) > mTouchSlop){
                        updateViewLocal()
                    }
                }
                MotionEvent.ACTION_UP -> {
                    windowLP?.apply {
                        this.x = -400
                        this.y = currentScreenPoint.y - currentTouchPoint.y
                    }
                    windowManager.updateViewLayout(this, windowLP)
                    if (Math.abs(currentScreenPoint.x - touchDownPoint.x) < mTouchSlop &&
                        Math.abs(currentScreenPoint.y - touchDownPoint.y) < mTouchSlop
                    ) {
                        Log.d(TAG, "onTouchEvent: " +"点击了浮窗")
                    }
                }
            }
        }
        return super.onTouchEvent(event)
    }

    private fun updateViewLocal() {
        windowLP?.apply {
            this.x = currentScreenPoint.x - currentTouchPoint.x
            this.y = currentScreenPoint.y - currentTouchPoint.y
            Log.d(TAG, "updateViewLocal: ($x, $y)")
        }
        windowManager.updateViewLayout(this,windowLP )
    }

    fun setParams111(params:WindowManager.LayoutParams){
        windowLP = params
    }

    fun getStatusBarHeight():Int{
        if(statusBarHeight == 0){
            try {
                val c = Class.forName("com.android.internal.R\$dimen")
                val o = c.newInstance()
                val field = c.getField("status_bar_height")
                val x = field.get(o) as Int
                statusBarHeight = resources.getDimensionPixelSize(x)
            }catch (e: Exception){
                e.printStackTrace()
            }
        }
        return statusBarHeight
    }

}