package com.example.noteplan.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.noteplan.R
import com.example.noteplan.databinding.RvPlanLayoutBinding
import java.util.zip.Inflater

class RVPlanAdapter:RecyclerView.Adapter<RVPlanAdapter.ItemView>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemView {
        return ItemView(LayoutInflater.from(parent.context).inflate(R.layout.rv_plan_layout, parent, false))
    }

    override fun onBindViewHolder(holder:ItemView, position: Int) {
        val bind: RvPlanLayoutBinding? = DataBindingUtil.bind<RvPlanLayoutBinding>(holder.itemView)
        bind?.tvYear?.text = "201" + position + "计划"
    }

    override fun getItemCount(): Int {
        return 10
    }

    class ItemView(itemView: View) :RecyclerView.ViewHolder(itemView){


    }


}