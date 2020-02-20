package com.qihoo.tbtool.core.taobao.view

import android.content.Context
import android.graphics.Color
import android.view.Gravity
import android.view.View
import android.widget.LinearLayout
import com.qihoo.tbtool.bean.Prop
import org.jetbrains.anko.*
import android.R
import android.graphics.drawable.GradientDrawable
import android.widget.TextView
import android.view.ViewGroup
import com.qihoo.tbtool.bean.Value
import android.graphics.drawable.StateListDrawable
import android.widget.ScrollView


/**
 * 选择商品属性 View
 * 构造器
 */
class ChoosePropertyView(
    context: Context,
    val props: List<Prop>,
    val confirm: () -> Unit,
    val cancel: () -> Unit
) : BaseView(context) {
    fun getRootView(): View {
        return context.UI {

            verticalLayout {
                backgroundColor = Color.WHITE


                textView("请选择商品属性") {
                    textSize = 20f

                    textColor = Color.BLACK
                }.lparams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                ) {
                    gravity = Gravity.CENTER
                }

                scrollView {
                    verticalLayout {
                        // 增加属性选项
                        for (prop in props) {
                            val itemView = buildItem(prop)
                            addView(itemView)
                        }
                    }
                }.lparams(ViewGroup.LayoutParams.MATCH_PARENT, dip(300))


                linearLayout {
                    setPadding(0, dip(15), 0, 0)

                    orientation = LinearLayout.HORIZONTAL

                    button("取消") {
                        background = buildRoundRectShape(Color.GRAY)
                        textColor = Color.WHITE
                        setOnClickListener {
                            cancel()
                        }
                    }.lparams {
                        weight = 1f
                        setMargins(dip(10), 0, dip(10), 0)
                    }

                    button("确定") {
                        background = buildRoundRectShape(Color.parseColor("#FF6721"))
                        textColor = Color.WHITE
                        setOnClickListener {
                            confirm()
                        }
                    }.lparams {
                        weight = 1f
                        setMargins(dip(10), 0, dip(10), 0)
                    }

                }.lparams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )

                padding = dip(5)
            }

        }.view
    }

    fun buildItem(prop: Prop): View {
        return context.UI {
            verticalLayout {
                textView(prop.name) {
                    setPadding(0, dip(5), 0, 0)

                    textSize = 16f

                    textColor = Color.BLACK
                }

                val flowLayout = FlowLayout(context).apply {
                    padding = dip(5)

                    // 选项点击事件
                    val tagClick = { view: View, value: Value ->
                        // 将 flowLayout 的所有选项的 Selected 变成 false
                        resetChildSelected()

                        // 重置 values 的选中状态
                        prop.values.forEach {
                            it.isSelected = false
                        }


                        // 设置选中的数据
                        value.isSelected = true
                        view.isSelected = value.isSelected
                    }

                    // 如果只有一个选项就选中第一个
                    if (prop.values.size == 1) {
                        prop.values[0].isSelected = true
                    }

                    // 增加标记
                    for (value in prop.values) {
                        val tv = buildText(value)
                        tv.setOnClickListener {
                            tagClick(it, value)
                        }
                        addView(tv)
                    }

                }.lparams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                ) {

                    setMargins(0, dip(8), 0, 0)
                }

                addView(flowLayout)
            }

        }.view

    }


    private fun buildText(value: Value): TextView {
        val layoutParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        ).apply {
            setMargins(context.dip(5), context.dip(3), context.dip(5), context.dip(3))
        }

        val tv = TextView(context)
        tv.setPadding(context.dip(14), context.dip(5), context.dip(14), context.dip(5))
        tv.text = value.name

        tv.textColor = Color.WHITE

        tv.layoutParams = layoutParams
        tv.background = buildSelectedBG(Color.parseColor("#FF6721"), Color.GRAY)
        tv.isSelected = value.isSelected
        tv.setSingleLine()




        return tv
    }


}