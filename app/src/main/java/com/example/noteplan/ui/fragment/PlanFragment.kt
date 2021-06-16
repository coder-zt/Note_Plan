package com.example.noteplan.ui.fragment

import androidx.recyclerview.widget.GridLayoutManager
import com.example.noteplan.R
import com.example.noteplan.base.BaseFragment
import com.example.noteplan.databinding.FragmentPlanBinding
import com.example.noteplan.ui.adapter.RVPlanAdapter

class PlanFragment:BaseFragment<FragmentPlanBinding>() {

        override fun getSubLayoutId(): Int {
            return R.layout.fragment_plan
        }

    override fun onResume() {
        super.onResume()
        getDataBinding()?.rvPlan?.layoutManager = GridLayoutManager(activity, 2)
        getDataBinding()?.rvPlan?.adapter = RVPlanAdapter()
    }
}