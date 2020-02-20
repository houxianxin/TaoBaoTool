package com.qihoo.tbtool.core.taobao.view

import android.content.Context
import android.os.CountDownTimer
import android.widget.TextView
import android.widget.Toast
import com.mm.red.expansion.formatTime
import com.qihoo.tbtool.core.taobao.Core
import com.qihoo.tbtool.core.taobao.JobManagers
import com.qihoo.tbtool.expansion.l
import com.qihoo.tbtool.expansion.mainScope
import kotlinx.coroutines.*
import org.jetbrains.anko.AnkoAsyncContext

class CountDownTextView(context: Context, val timeValue: Long) : TextView(context) {
    private var timeCallBack: TimeCallBack? = null
    var job: Job? = null

    fun start() {
        l("开始倒计时:$timeValue")
        job = GlobalScope.launch {
            while (true) {
                val currentTimeMillis = System.currentTimeMillis()
                val time = timeValue - currentTimeMillis
                if (time <= 0) {
                    timeCallBack?.onEnd()
                    break
                }

                mainScope.launch {
                    text = "剩余: ${(time / 1000).formatTime()}"
                }

                delay(1000)
            }
        }


    }


    fun stop() {
        l("执行停止了")
        try {
            job?.cancel()
        } catch (e: Exception) {
            l("出错${e.message}")
        }
    }


    interface TimeCallBack {
        fun onEnd()
    }

    fun setOnTimeCallBack(timeCallBack: TimeCallBack) {
        this.timeCallBack = timeCallBack

    }


}