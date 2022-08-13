package com.o7services.loginapplication.recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.o7services.loginapplication.R

class RecyclerAdapterClass:RecyclerView.Adapter<RecyclerAdapterClass.ViewHolder>()   {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerAdapterClass.ViewHolder {

        var initView = LayoutInflater.from(parent.context).inflate(
            R.layout.layout_adapter, parent, false)
        return ViewHolder(initView)

    }

    class ViewHolder(view: View):RecyclerView.ViewHolder(view) {
        var tvId = view.findViewById<TextView>(R.id.tvId)
        var tvName = view.findViewById<TextView>(R.id.tvName)
        var tvRollNno = view.findViewById<TextView>(R.id.tvRollno)
    }

    override fun onBindViewHolder(holder: RecyclerAdapterClass.ViewHolder, position: Int) {
    }

    override fun getItemCount(): Int {

        return 5
    }
}