package com.qihoo.tbtool.core.taobao.view

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.View
import android.view.Gravity
import android.app.Dialog
import android.view.WindowManager
import android.widget.LinearLayout
import com.mm.red.expansion.fillZero
import com.qihoo.tbtool.R
import com.qihoo.tbtool.bean.Prop
import com.qihoo.tbtool.core.taobao.view.wheelview.adapter.ArrayWheelAdapter
import com.qihoo.tbtool.core.taobao.view.wheelview.common.WheelConstants.WHEEL_TEXT_SIZE
import com.qihoo.tbtool.core.taobao.view.wheelview.widget.WheelView
import com.qihoo.tbtool.expansion.createMyScope

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.cancel
import org.jetbrains.anko.*
import java.util.*
import kotlin.collections.HashMap


/**
 * 倒计时Dialog
 */
class CountDownDialog(
    context: Context, val timeValue: Long, val stop: () -> Unit, val start: () -> Unit
) : Dialog(context),
    CoroutineScope by createMyScope() {

    init {
        setContentView(buildView())
        window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        setCancelable(false)


        window!!.getDecorView().setPadding(0, 0, 0, 0)
        val lp = window!!.attributes
        lp.width = context.dip(300)
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT
        lp.gravity = Gravity.CENTER
        window!!.attributes = lp

    }

    private fun buildView(): View {
        return CountDownView(context, timeValue, {
            // 确认
            // 取消
            dismiss()
        }, {
            confirm()
        }).getRootView()

    }


    private fun confirm() {
        start()

        dismiss()
    }


    override fun dismiss() {
        stop()
        super.dismiss()
        coroutineContext.cancel()
    }

}

