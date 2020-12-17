package com.example.nestedrecyclerivew

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.viewholder_horizen.view.*
import kotlinx.android.synthetic.main.viewholder_vertical.view.*

class ParentAdapter(val context: Context,val horizenList:List<InsideData>,val verticalList:List<ParentData>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object{
        const val HORIZEN_TYPE = 0
        const val VERTICAL_TYPE = 1
    }

    val insiderAdapter = InSideAdapter(horizenList)
    val localList = verticalList

    inner class HorizenViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val rview = itemView.rview_horizen

    }

    inner class VerticalViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val title = itemView.tv_title
        val subTitle = itemView.tv_subtitle

        fun bind(item:ParentData){
            title.text = item.title
            subTitle.text = item.subTitle
        }
    }

    override fun getItemCount(): Int  = localList.size

    override fun getItemViewType(position: Int): Int {
        if(position==0) return HORIZEN_TYPE
        else return VERTICAL_TYPE
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if(viewType == VERTICAL_TYPE){
            val inflater = LayoutInflater.from(parent.context)
            val holder = inflater.inflate(R.layout.viewholder_vertical,parent,false)
            return VerticalViewHolder(holder)
        }
        else {
            val inflater = LayoutInflater.from(parent.context)
            val holder = inflater.inflate(R.layout.viewholder_horizen,parent,false)

            val linearLayoutManager = LinearLayoutManager(context)
            linearLayoutManager.orientation = LinearLayoutManager.HORIZONTAL
            val horizenViewHolder = HorizenViewHolder(holder)
            horizenViewHolder.rview.layoutManager = linearLayoutManager
            horizenViewHolder.rview.adapter = insiderAdapter

            return HorizenViewHolder(holder)
        }

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(holder is VerticalViewHolder){
            holder.bind(localList[position])
        }
        else if(holder is HorizenViewHolder) {
            //不用綁資料 資料在InsideAdapter綁完ㄌ
        }
    }





}