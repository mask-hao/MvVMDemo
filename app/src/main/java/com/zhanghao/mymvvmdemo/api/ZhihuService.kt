package com.zhanghao.mymvvmdemo.api

import com.zhanghao.mymvvmdemo.bean.ZhiHu
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

/**
 * Created by zhanghao on 2017/6/8.
 */
interface ZhihuService {

    @GET("/api/4/news/latest")
    fun getLatest() :Observable<ZhiHu>

    object Service{
        val getService:ZhihuService by lazy {
            Retrofit.Builder().baseUrl("http://news-at.zhihu.com")
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build().create(ZhihuService::class.java)
        }
    }

}