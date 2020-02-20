package com.qihoo.tbtool.core.taobao.view

import android.content.Context
import android.graphics.Color
import android.view.Gravity
import android.view.View
import android.widget.LinearLayout
import androidx.appcompat.widget.ActionBarContextView

import com.qihoo.tbtool.expansion.l
import kotlinx.android.synthetic.main.content_main.view.*
import kotlinx.coroutines.NonCancellable
import kotlinx.coroutines.NonCancellable.start
import org.jetbrains.anko.*

class CountDownView(
    context: Context,
    val timeValue: Long,
    val stop: () -> Unit,
    val start: () -> Unit
) : BaseView(context) {
    fun getRootView(): View {
        return context.UI {
            verticalLayout {
                padding = dip(15)

                backgroundColor = Color.WHITE
                textView("抢购倒计时") {
                    textSize = 20f

                    textColor = Color.BLACK
                }.lparams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                ) {
                    gravity = Gravity.CENTER
                }

                val countDownTimeView = CountDownTextView(context, timeValue).apply {
                    textSize = 18f
                    textColor = Color.RED
                }.lparams {
                    setMargins(0, dip(20), 0, 0)
                    gravity = Gravity.CENTER
                }


                addView(countDownTimeView)
                countDownTimeView.setOnTimeCallBack(object : CountDownTextView.TimeCallBack {
                    override fun onEnd() {
                        start()
                    }

                })
                countDownTimeView.start()

                linearLayout {
                    setPadding(0, dip(15), 0, 0)

                    orientation = LinearLayout.HORIZONTAL

                    button("停止") {
                        background = buildRoundRectShape(Color.GRAY)
                        textColor = Color.WHITE
                        setOnClickListener {
                            countDownTimeView.stop()
                            stop()
                        }
                    }.lparams(0, LinearLayout.LayoutParams.WRAP_CONTENT) {
                        weight = 1f
                        setMargins(dip(10), 0, dip(10), 0)
                    }

                    button("立即开始") {

                        background = buildRoundRectShape(Color.parseColor("#FF6721"))
                        textColor = Color.WHITE
                        setOnClickListener {
                            countDownTimeView.stop()
                            start()
                        }
                    }.lparams(0, LinearLayout.LayoutParams.WRAP_CONTENT) {
                        weight = 1f

                        setMargins(dip(10), 0, dip(10), 0)
                    }

                }.lparams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                ) {
                    gravity = Gravity.CENTER
                }
            }

        }.view
    }

}