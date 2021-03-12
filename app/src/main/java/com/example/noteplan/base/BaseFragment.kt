package com.example.noteplan.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

abstract class BaseFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(getSubLayoutId(), container, false)
    }

    /**
     * 获取子类的layoutID
     */
    abstract fun getSubLayoutId(): Int
}