package com.zhanghao.mymvvmdemo.bean

import com.google.gson.annotations.SerializedName

/**
 * Created by zhanghao on 2017/6/8.
 */
data class ZhiHu(@SerializedName("date")var date:String,@SerializedName("stories")
var stories:List<ZhiHuItem>,@SerializedName("top_stories")var top_stories:List<ZhiHuTopItem>)
data class ZhiHuItem(var images:List<String>,var type:Int,var id:String,var ga_prefix:String,var title:String)
data class ZhiHuTopItem(var images: String,var type: Int,var id: String,var ga_prefix: String,var title: String)