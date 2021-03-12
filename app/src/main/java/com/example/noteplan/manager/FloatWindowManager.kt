package com.example.noteplan.manager

import android.content.Context
import android.content.Intent
import android.graphics.PixelFormat
import android.os.Build
import android.view.Gravity
import android.view.WindowManager
import com.example.noteplan.ui.view.NoteFloatView
import com.example.noteplan.ui.view.SmallFloatView

class FloatWindowManager {



companion object{
    private var windowManager:WindowManager? = null

    private val smallWindowParams: WindowManager.LayoutParams by lazy {
        WindowManager.LayoutParams()
    }

    fun createSmallFloatView(context: Context){
        val manager = getWindowManager(context)
        val windowWidth: Int? = manager?.defaultDisplay?.width
        val windowHeight:Int? = manager?.defaultDisplay?.height

        val smallWindow = SmallFloatView(context)
        // 设置窗体显示类型
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            smallWindowParams.type = WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY;
        } else {
            smallWindowParams.type = WindowManager.LayoutParams.TYPE_PHONE;
        }
        smallWindowParams.format = PixelFormat.TRANSPARENT
        smallWindowParams.flags =  WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE or WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL // 不阻塞事件传递到后面的窗口
        smallWindowParams.gravity = Gravity.LEFT or Gravity.TOP
        smallWindowParams.width = WindowManager.LayoutParams.WRAP_CONTENT;
        smallWindowParams.height = WindowManager.LayoutParams.WRAP_CONTENT;
        smallWindowParams.x = 100
        smallWindowParams.y = 100
        smallWindow.setParams111(smallWindowParams)
        manager?.addView(
            smallWindow,
            smallWindowParams
        )
    }

    /**
     * 创建编辑笔记的浮窗
     */
    fun createNoteFloatView(context: Context){
        val intent: Intent = Intent();
    }


    fun getWindowManager(context: Context):WindowManager?{
        if (windowManager == null) {
            windowManager = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        }
        return windowManager
    }
}


}
