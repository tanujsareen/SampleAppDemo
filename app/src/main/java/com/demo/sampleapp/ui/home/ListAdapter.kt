package com.demo.sampleapp.ui.home

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView
import com.demo.sampleapp.R
import timber.log.Timber

class ListAdapter(var context: Context, var iCallback: ICallback) :
    RecyclerView.Adapter<ListAdapter.HomeHolder>() {

    val arrayList: ArrayList<Object> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.home_layout_item, parent, false)
        return HomeHolder(view)
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    override fun onBindViewHolder(holder: HomeHolder, position: Int) {
        val genericResponse: Object = arrayList[position]

        Timber.i("%s", "resposne")
        /*Glide.with(context).load(genericResponse.featuredMedia).fitCenter()
            .into(holder.imgMovie)*/


    }

    interface ICallback {

        fun selection(position: Int)
    }

    class HomeHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txtTitleLibBlogItem: AppCompatImageView =
            itemView.findViewById(R.id.imageViewItem)
    }

    fun addItemAll(data: Object) {
        arrayList.addAll(listOf(data))
        notifyDataSetChanged()
    }
}