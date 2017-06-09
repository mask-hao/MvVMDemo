package com.zhanghao.mymvvmdemo.model

import com.zhanghao.mymvvmdemo.api.ZhihuService
import com.zhanghao.mymvvmdemo.bean.ZhiHu
import io.reactivex.Observable

/**
 * Created by zhanghao on 2017/6/9.
 */
class ZhihuRepository private constructor(): ZhihuRemoteDataSource{

    companion object{
        fun getInstance() = Holder.instance
    }

    private object Holder{
        val instance = ZhihuRepository()
    }

    override fun getLatest(): Observable<ZhiHu> {
        return ZhihuService.Service.getService.getLatest()
    }
}