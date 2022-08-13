package com.o7services.loginapplication.recycler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.o7services.loginapplication.R
import com.o7services.loginapplication.databinding.ActivityRecyclerBinding
import com.o7services.loginapplication.list.BaseAdapterDataClass

class RecyclerActivity : AppCompatActivity() {
    lateinit var binding: ActivityRecyclerBinding
    lateinit var adapter:RecyclerAdapterClass
    lateinit var linearLayoutManager: LinearLayoutManager
    lateinit  var gridLayoutManager : GridLayoutManager
    var array : ArrayList<BaseAdapterDataClass> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecyclerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        array.add(BaseAdapterDataClass(1,1,"Varun"))
        array.add(BaseAdapterDataClass(2,1,"Arsh"))
        array.add(BaseAdapterDataClass(3,1,"Harman"))
        array.add(BaseAdapterDataClass(4,1,"Suprit"))
        array.add(BaseAdapterDataClass(5,1,"Reetika"))
        array.add(BaseAdapterDataClass(6,1,"Harsh"))
        array.add(BaseAdapterDataClass(7,1,"Nandini"))
        array.add(BaseAdapterDataClass(8,1,"Jaspreet"))
        array.add(BaseAdapterDataClass(9,1,"Sukhpreet"))
        array.add(BaseAdapterDataClass(10,1,"Suman"))
        adapter = RecyclerAdapterClass(array)
//        gridLayoutManager = GridLayoutManager(this,3)
        linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = linearLayoutManager
        binding.recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener(){})

        binding.recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                    if (linearLayoutManager.findLastCompletelyVisibleItemPosition() == array.size - 1 ) {
                        binding.progressBar.visibility = View.VISIBLE

                        Handler(Looper.getMainLooper()).postDelayed({
                            array.add(BaseAdapterDataClass(11,1,"Varun"))
                            array.add(BaseAdapterDataClass(12,1,"Arsh"))
                            array.add(BaseAdapterDataClass(13,1,"Harman"))
                            array.add(BaseAdapterDataClass(114,1,"Suprit"))
                            array.add(BaseAdapterDataClass(15,1,"Reetika"))
                            array.add(BaseAdapterDataClass(16,1,"Harsh"))
                            array.add(BaseAdapterDataClass(17,1,"Nandini"))
                            array.add(BaseAdapterDataClass(18,1,"Jaspreet"))
                            array.add(BaseAdapterDataClass(19,1,"Sukhpreet"))
                            array.add(BaseAdapterDataClass(20,1,"Suman"))
                            adapter.notifyDataSetChanged()
                            binding.progressBar.visibility = View.GONE
                        },10000)



                }
            }
        })
    }
}