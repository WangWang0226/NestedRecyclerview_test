package com.example.nestedrecyclerivew

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.viewholder_inside.view.*

class InSideAdapter(val list:List<InsideData>) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    val localList = list

    inner class MyViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){
        val title = itemView.tv_title

        fun bind(item:InsideData){
            title.text = item.title
        }
    }

    override fun getItemCount(): Int  = localList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater =  LayoutInflater.from(parent.context)
        val holder = inflater.inflate(R.layout.viewholder_inside,parent,false)
        return MyViewHolder(holder)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        if(holder is MyViewHolder)
            holder.bind(localList[position])
    }


}