package com.o7services.loginapplication.recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.o7services.loginapplication.R
import com.o7services.loginapplication.list.BaseAdapterDataClass

class RecyclerAdapterClass(var array: ArrayList<BaseAdapterDataClass> ) :RecyclerView.Adapter<RecyclerAdapterClass.ViewHolder>()   {
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
        holder.tvId.setText(array.get(position).id.toString())
        holder.tvName.setText(array.get(position).name.toString())
        holder.tvRollNno.setText(array.get(position).rollNo.toString())
        System.out.println("in bind view holder $position")

    }

    override fun getItemCount(): Int {
        return array.size
    }
}