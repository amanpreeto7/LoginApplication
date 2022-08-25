package com.o7services.loginapplication.room

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.o7services.loginapplication.R

class RoomRecycler(var arrayList: ArrayList<Notes>, var clickInterface: clickInterface) : RecyclerView.Adapter<RoomRecycler.ViewHolder>() {
    class ViewHolder(var view: View): RecyclerView.ViewHolder(view) {
        var tvDate = view.findViewById<TextView>(R.id.tvDate)
        var tvTitle = view.findViewById<TextView>(R.id.tvTitle)
        var tvDescription = view.findViewById<TextView>(R.id.tvDescription)
        var tvDelete = view.findViewById<TextView>(R.id.tvDelete)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.layout_room_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvDate.setText(arrayList[position].date)
        holder.tvTitle.setText(arrayList[position].title)
        holder.tvDescription.setText(arrayList[position].description)
        holder.tvDelete.setOnClickListener {
            clickInterface.ClickInterface(arrayList[position])
        }
    }

    override fun getItemCount(): Int {
return arrayList.size    }
}