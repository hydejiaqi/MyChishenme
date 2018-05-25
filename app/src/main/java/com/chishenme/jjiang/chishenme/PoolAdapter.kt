package com.chishenme.jjiang.chishenme

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.Adapter
import android.view.ViewGroup

/**
 * Created by jjiang on 5/24/2018.
 */
class PoolAdapter(val context: Context) : Adapter<RecyclerView.ViewHolder>() {

    var poollist: ArrayList<String>
    get() { return poollist}
    set(value){
        poollist = value;
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getItemCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}