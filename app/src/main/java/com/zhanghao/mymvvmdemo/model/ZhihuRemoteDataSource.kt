package com.zhanghao.mymvvmdemo.model

import com.zhanghao.mymvvmdemo.bean.ZhiHu
import io.reactivex.Observable

/**
 * Created by zhanghao on 2017/6/9.
 */
interface ZhihuRemoteDataSource {
    fun getLatest():Observable<ZhiHu>
}