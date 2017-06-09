package com.zhanghao.mymvvmdemo.viewmode

import android.content.Intent
import android.databinding.BaseObservable

/**
 * Created by zhanghao on 2017/6/9.
 */
class DetailContentViewModelExample(var intent :Intent):BaseObservable(){
    fun getId():String{
        return intent.getStringExtra("id")
    }
}