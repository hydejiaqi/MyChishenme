package com.chishenme.jjiang.chishenme.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.Adapter
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

/**
 * Created by jjiang on 5/24/2018.
 */
class PoolAdapter(val context: Context) : RecyclerView.Adapter<PoolAdapter.ViewHolder>() {
    class ViewHolder(val textView: TextView, val image: ImageView) : RecyclerView.ViewHolder(textView)

    var poollist: ArrayList<String>
    get() { return poollist}
    set(value){
        poollist = value;
    }


    fun addListItem(item : String){
        this.poollist.add(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PoolAdapter.ViewHolder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
      //  val view = LayoutInflater.from(parent.context).inflate(R.layout.adapter_pool, parent, false)


    }

    override fun getItemCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        return poollist.size;
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        holder.textView.text = poollist.get(position)

    }


}