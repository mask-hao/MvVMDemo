package com.zhanghao.mymvvmdemo

import android.databinding.BindingAdapter
import android.support.v7.widget.RecyclerView
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.zhanghao.mymvvmdemo.bean.ZhiHuItem
import com.zhanghao.mymvvmdemo.ui.ZhiHuAdapter

/**
 * Created by zhanghao on 2017/6/9.
 */
    object ImageViewBinding{
        @BindingAdapter("android:src")
        @JvmStatic
        fun setImage(image: ImageView, url:String){
            Glide.with(image.context).load(url).into(image)
        }
    }

    object ListBinding{
        @BindingAdapter("app:items")
        @JvmStatic
        fun setList(recyclerView: RecyclerView, stroies:List<ZhiHuItem>){
            val adapter : ZhiHuAdapter = recyclerView.adapter as ZhiHuAdapter
            adapter.zhihuList = stroies
        }
    }