package com.zhanghao.mymvvmdemo.viewmode

import android.content.Context
import android.content.Intent
import android.databinding.BaseObservable

import com.zhanghao.mymvvmdemo.bean.ZhiHuItem
import com.zhanghao.mymvvmdemo.ui.SecondActivity

/**
 * Created by zhanghao on 2017/6/9.
 */
class ZhiHuItemViewModel(var zhiHuItem: ZhiHuItem,var context:Context): BaseObservable(){

    fun getTitle():String{
        return  zhiHuItem.title
    }

    private fun getId(): String {
        return zhiHuItem.id
    }

    fun getImageUrl():String{
        return zhiHuItem.images.get(0)
    }

    fun  setItem(zhiHuItem: ZhiHuItem){
        this.zhiHuItem = zhiHuItem
//        notifyPropertyChanged(BR._all)
        notifyChange()
    }

    fun onItemClick(){
        val intent : Intent = Intent(context,SecondActivity::class.java)
        intent.putExtra("id",getId())
        intent.putExtra("title",getTitle())
        context.startActivity(intent)
    }

}