package com.zhanghao.mymvvmdemo.viewmode

import android.content.Context
import android.databinding.*
import android.view.View
import com.zhanghao.mymvvmdemo.bean.ZhiHu
import com.zhanghao.mymvvmdemo.bean.ZhiHuItem
import com.zhanghao.mymvvmdemo.model.ZhihuRemoteDataSource
import com.zhanghao.mymvvmdemo.model.ZhihuRepository
import com.zhanghao.mymvvmdemo.rx.RxHelper
import io.reactivex.Observer
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable


/**
 * Created by zhanghao on 2017/6/8.
 */
class ZhiHuViewModel(repository: ZhihuRepository,context: Context):BaseObservable(){

    var loadingProgress : ObservableInt? =null
    var zhihuRecycler : ObservableInt?=null

    var mContext : Context?=null

    var zhihuStroies:ObservableList<ZhiHuItem>?=null

    var mCompositeDisposable:CompositeDisposable  = CompositeDisposable()
    var zhihuRemoteDataSource:ZhihuRemoteDataSource?=null

    init {
        mContext = context
        zhihuStroies = ObservableArrayList()
        loadingProgress = ObservableInt(View.GONE)
        zhihuRecycler = ObservableInt(View.GONE)
        zhihuRemoteDataSource = repository
    }


    fun loadData(){
        loadingProgress?.set(View.VISIBLE)
        zhihuRemoteDataSource?.getLatest()
                ?.compose(RxHelper.toUI())
                ?.subscribe(object :Observer<ZhiHu>{
                    override fun onError(e: Throwable?) {
                        println(e?.message)
                    }

                    override fun onSubscribe(d: Disposable?) {
                        mCompositeDisposable.add(d)
                    }

                    override fun onComplete() {
                        loadingProgress?.set(View.GONE)
                        zhihuRecycler?.set(View.VISIBLE)
//                        notifyPropertyChanged(BR._all)
                        notifyChange()
                    }
                    override fun onNext(value: ZhiHu?) {
                        if (value != null) {
                            zhihuStroies?.addAll(value.stories)
                        }
                    }
           })
    }





    fun destroy(){
        mCompositeDisposable.clear()
    }

}