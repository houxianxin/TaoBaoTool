package com.qihoo.tbtool.core.taobao.view

import android.R
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.graphics.drawable.StateListDrawable
import org.jetbrains.anko.AnkoAsyncContext
import org.jetbrains.anko.dip

open class BaseView(val context: Context) {
    fun buildSelectedBG(selecteDcolor: Int, noSelecteDcolor: Int): StateListDrawable {
        val drawable = StateListDrawable()
        // state_selected 为false

        drawable.addState(intArrayOf(-R.attr.state_selected), buildRoundRectShape(noSelecteDcolor))
        drawable.addState(
            intArrayOf(R.attr.state_selected),
            buildRoundRectShape(selecteDcolor)
        )

        return drawable
    }

    fun buildRoundRectShape(color: Int): GradientDrawable {
        val drawable = GradientDrawable()
        drawable.shape = GradientDrawable.RECTANGLE
        drawable.cornerRadius = context.dip(60).toFloat()
        drawable.setColor(color)
        return drawable
    }
}