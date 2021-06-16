package com.example.noteplan.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.example.noteplan.R
import com.example.noteplan.databinding.ActivityNoteEditBinding

abstract class BaseFragment<T:ViewDataBinding>: Fragment() {

    var mView: View? = null
    private val binding: T? by lazy {
        mView?.let { DataBindingUtil.bind<T>(it) }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view:View = inflater.inflate(getSubLayoutId(), container, false)
        mView = view
        return view
    }

    /**
     * 获取子类的layoutID
     */
    abstract fun getSubLayoutId(): Int

    protected fun getDataBinding(): T? {
        return binding
    }
}