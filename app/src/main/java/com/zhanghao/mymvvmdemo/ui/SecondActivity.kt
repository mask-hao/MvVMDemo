package com.zhanghao.mymvvmdemo.ui

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import com.zhanghao.mymvvmdemo.R
import com.zhanghao.mymvvmdemo.databinding.SecondActivityBinding
import com.zhanghao.mymvvmdemo.viewmode.DetailContentViewModelExample

/**
 * Created by zhanghao on 2017/6/9.
 */

class SecondActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val intent = intent
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        title = intent.getStringExtra("title")
        val binding : SecondActivityBinding = DataBindingUtil.setContentView(this, R.layout.second_activity)
        binding.detail = DetailContentViewModelExample(intent)
    }


    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when{
            item?.itemId == android.R.id.home->{
                onBackPressed()
                return true
            }

        }
        return super.onOptionsItemSelected(item)
    }
}
