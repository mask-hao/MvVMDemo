package com.zhanghao.mymvvmdemo.ui

import android.content.Context
import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.zhanghao.mymvvmdemo.R
import com.zhanghao.mymvvmdemo.bean.ZhiHuItem
import com.zhanghao.mymvvmdemo.databinding.ZhihuItemBinding
import com.zhanghao.mymvvmdemo.viewmode.ZhiHuItemViewModel
import java.util.*

/**
 * Created by zhanghao on 2017/6/9.
 */
class ZhiHuAdapter( var zhihuList : List<ZhiHuItem>,var context:Context): RecyclerView.Adapter<ZhiHuAdapter.ViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val zhihuitembinding : ZhihuItemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent?.context), R.layout.zhihu_item,parent,false)
        return ViewHolder(zhihuitembinding)
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder!!.bindItem(zhihuList.get(position))
    }

    override fun getItemCount(): Int {
        println(zhihuList.size)
        return zhihuList.size
    }


   inner class ViewHolder(itemBinding: ZhihuItemBinding) : RecyclerView.ViewHolder(itemBinding.zhihuItemRl0) {
        var zhihuItemBinding : ZhihuItemBinding?= itemBinding
        fun bindItem(zhihuItem:ZhiHuItem){
            if (zhihuItemBinding?.zhihuItemViewModel == null){
                zhihuItemBinding?.zhihuItemViewModel = ZhiHuItemViewModel(zhihuItem,context)
            }
            else{
                zhihuItemBinding?.zhihuItemViewModel?.setItem(zhihuItem)
            }
        }



    }
}