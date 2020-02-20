package com.qihoo.tbtool.core.taobao.event

import android.app.Activity
import android.app.Dialog
import android.content.Intent
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import com.qihoo.tbtool.core.PlugInInit
import com.qihoo.tbtool.core.taobao.Core
import com.qihoo.tbtool.core.taobao.TbDetailActivityHook
import com.qihoo.tbtool.dao.SelectPropertyDao
import com.qihoo.tbtool.expansion.l
import com.qihoo.tbtool.expansion.mainScope
import kotlinx.coroutines.launch
import java.util.ArrayList

object OrderChooseEvent : BaseEvent() {
    fun execute(dialog: Dialog) = mainScope.launch {
        // 子线程,循环判断界面是否加载完毕
        checkLoadCompleteById(dialog.context, dialog.window!!, "confirm")

        // 选择订单逻辑
        selectOrderProperty(dialog)


//         点击确定按钮
        val resId =
            dialog.context.resources.getIdentifier("confirm", "id", dialog.context.packageName)
        val go = dialog.findViewById<View>(resId)
        if (go == null) {
            // 重新尝试抢购
            val activity = dialog.ownerActivity ?: return@launch
            Core.startGo(activity.applicationContext, activity.intent.clone() as Intent)
            activity.finish()
        } else if (go.tag == null) {
            go.tag = "已经点击过"
            go.performClick()
        }

    }


    /**
     * 订单属性选择
     */
    private fun selectOrderProperty(dialog: Dialog) {

        try {
            // 1 获取预选的订单Id
            val item_id =
                dialog.ownerActivity?.intent?.getStringExtra("item_id")
                    ?: ""
            // 从数据库中获取选中的属性
            val select = PlugInInit.daoSession?.selectPropertyDao?.queryBuilder()
                ?.where(SelectPropertyDao.Properties.ItemId.eq(item_id))?.unique()

            val selectLayout = dialog.context.resources.getIdentifier(
                "sku_native_view_layout",
                "id",
                dialog.context.packageName
            )
            val selectLayoutView = dialog.findViewById<View>(selectLayout) as LinearLayout

            // 循环遍历,选择订单的属性
            for (i in 0 until selectLayoutView.childCount) {
                val views = ArrayList<View>()

                val group = selectLayoutView.getChildAt(i) as ViewGroup

                // 获取第一个属性昵称
                val propertyName = (group.getChildAt(0) as TextView).text
                val propertyValue = select?.tbProperty?.get(propertyName)
                l("获取属性昵称:$propertyName   需要选中:$propertyValue")

                // 找到所有的选择条件
                findPropValueView(group, views)
                if (views.size > 0) {

                    // 查找选中项的条件,对应位置
                    val condition = findIndexByText(views, propertyValue ?: "")
                    if (condition.index != -1 && condition.isSelect) {
                        // 选中自己的条件
                        val view = views.get(condition.index)
                        if (!view.isSelected) {
                            // 选中
                            view.performClick()
                        }
                    } else {
                        // 选中最后一个可选添加
                        if (condition.lastClickView?.isSelected != true) {
                            // 选中
                            condition.lastClickView?.performClick()
                        }
                    }
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }


    }

    /**
     * 根据选中的条件,查找View 返回 Condition 对象
     * 如果没有查找到 View Condition.index=-1
     */
    private fun findIndexByText(views: ArrayList<View>, value: String): Condition {
        val condition = Condition(text = value)

        for (index in views.indices.reversed()) {
            val view = views[index]
            val valueText = view.contentDescription.toString()
            Log.d("wyz", "选择: " + view.contentDescription)

            // 判断是否是我的选中条件
            if (valueText.contains(value)) {
                condition.index = index

                // 判断自己的属性能不能点击
                if (valueText.contains("不可选择")) {
                    // 不能点击,寻找最后一个可以点击的
                    condition.isSelect = false
                } else {
                    // 可以点击
                    condition.isSelect = true
                    break
                }

            }


            if (valueText.contains("不可选择")) {
                continue
            }

            // 记录第一个可以选的
            if (condition.lastClickView == null) {
                condition.lastClickView = view
            }

            // 优化算法 自己的条件不可以选, 且已经找到了最后一个可选条件
            if ((condition.index != -1 || value.isEmpty()) && condition.lastClickView != null) {
                break
            }
        }

        return condition
    }

    private fun findPropValueView(view: View, views: ArrayList<View>) {
        if (view is ViewGroup) {
            if (view.toString().contains("PropValueView")) {
                views.add(view)
                return
            }

            for (i in 0 until view.childCount) {
                val childAt = view.getChildAt(i)
                findPropValueView(childAt, views)
            }

        }

    }
}

/**
 * 记录条件View
 * lastClickView 代表没有找到,默认点击最后一个
 *
 * isSelect 代表选项是否可以选中
 */
data class Condition(
    var index: Int = -1,
    var lastClickView: View? = null,
    var text: String = "",
    var isSelect: Boolean = true
)
