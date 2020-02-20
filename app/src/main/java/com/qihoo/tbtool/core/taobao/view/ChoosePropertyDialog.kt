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
 * 商品属性选择Dialog
 */
class ChoosePropertyDialog(
    context: Context, val props: List<Prop>, val confirm: (HashMap<String, String>) -> Unit
) : Dialog(context),
    CoroutineScope by createMyScope() {

    init {
        setContentView(buildView())
        window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
//        setCancelable(false)


        window!!.getDecorView().setPadding(0, 0, 0, 0)
        val lp = window!!.attributes
        lp.width = WindowManager.LayoutParams.MATCH_PARENT
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT
        lp.gravity = Gravity.BOTTOM
        window!!.attributes = lp

    }

    private fun buildView(): View {
        return ChoosePropertyView(context, props, {
            // 确认
            confirm()
        }, {
            // 取消
            dismiss()
        }).getRootView()

    }


    private fun confirm() {
        // 转换选中数据
        val selects = HashMap<String, String>()


        for (prop in props) {
            for (value in prop.values) {
                if (value.isSelected) {
                    selects[prop.name] = value.name
                    break
                }
            }
        }

        confirm(selects)
        dismiss()
    }


    override fun dismiss() {
        super.dismiss()
        coroutineContext.cancel()
    }


}

