package com.zhanghao.mymvvmdemo.ui

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.zhanghao.mymvvmdemo.R
import com.zhanghao.mymvvmdemo.bean.ZhiHuItem
import com.zhanghao.mymvvmdemo.databinding.MainActivityBinding
import com.zhanghao.mymvvmdemo.model.ZhihuRepository
import com.zhanghao.mymvvmdemo.viewmode.ZhiHuViewModel
import kotlinx.android.synthetic.main.main_activity.*
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity(){
    var mainActivityBinding:MainActivityBinding?=null
    var zhihuViewModel:ZhiHuViewModel?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initDataBinding()
        initListAdapter()
        initData()
    }

    private fun initListAdapter() {
        zhihu_recycler.layoutManager = LinearLayoutManager(this)
         val zhihuAdapter : ZhiHuAdapter = ZhiHuAdapter(ArrayList<ZhiHuItem>(0),this)
        zhihu_recycler.adapter = zhihuAdapter
    }

    private fun initDataBinding() {
        mainActivityBinding = DataBindingUtil.setContentView(this,R.layout.main_activity)
        zhihuViewModel = ZhiHuViewModel(ZhihuRepository.getInstance(),this)
        mainActivityBinding?.zhihuViewModel = zhihuViewModel
    }


    private fun initData(){
        zhihuViewModel?.loadData()
    }


    override fun onDestroy() {
        super.onDestroy()
        zhihuViewModel?.destroy()
    }
}
