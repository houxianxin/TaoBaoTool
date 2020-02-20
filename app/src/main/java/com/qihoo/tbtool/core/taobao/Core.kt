package com.qihoo.tbtool.core.taobao

import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.widget.Toast
import com.mm.red.expansion.showCountDownDialog
import com.mm.red.expansion.showLoadDialog
import com.mm.red.expansion.showToast
import com.qihoo.tbtool.api.H5TBRetrofit
import com.qihoo.tbtool.bean.Prop
import com.qihoo.tbtool.bean.SelectProperty
import com.qihoo.tbtool.core.PlugInInit
import com.qihoo.tbtool.core.taobao.Core.startGo
import com.qihoo.tbtool.core.taobao.event.ClickBuyEvent
import com.qihoo.tbtool.core.taobao.event.OrderChooseEvent
import com.qihoo.tbtool.core.taobao.event.SubmitOrderEvent
import com.qihoo.tbtool.core.taobao.view.ChoosePropertyDialog
import com.qihoo.tbtool.core.taobao.view.ChooseTime
import com.qihoo.tbtool.dao.SelectPropertyDao
import com.qihoo.tbtool.expansion.l
import com.qihoo.tbtool.expansion.mainScope
import kotlinx.coroutines.*

object Core {

    /**
     * 开始秒杀
     */
    fun startGo(context: Context, intent: Intent) {
        val intent = intent.clone() as Intent
        // IS_KILL 就代表是抢购的标记
        intent.putExtra(TbDetailActivityHook.IS_KILL, true)
        // IS_KILL_GO 判断秒杀逻辑直走一次
        intent.putExtra(TbDetailActivityHook.IS_KILL_GO, false)
        // IS_INJECT 这个无需注入控制 View
        intent.putExtra(TbDetailActivityHook.IS_INJECT, false)

        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        context.startActivity(intent)
    }


    /**
     * 检测是否可以抢购了
     */
    fun checkBuy(activity: Activity) {
        // 执行点击购买逻辑
        ClickBuyEvent.execute(activity)
    }


    /**
     * 选择订单详情
     */
    fun orderChoose(dialog: Dialog) {
        OrderChooseEvent.execute(dialog)
    }


    /**
     * 提交订单
     */
    fun submitOrder(activity: Activity) {
        SubmitOrderEvent.execute(activity)
    }


    /**
     * 选择商品属性
     */
    fun selectCommodityProperty(
        activity: Activity,
        confirm: (items: HashMap<String, String>?) -> Unit
    ) {
        // 获取商品ID
        var itemId = activity.intent.getStringExtra("item_id") ?: ""
        if (itemId.isBlank()) {
            return
        }

        val dialog = activity.showLoadDialog("正在获取商品抢购属性...")

        mainScope.launch {
            try {
                // 请求商品属性接口
                val detail = H5TBRetrofit.api.getDetailById("{\"itemNumId\":\"${itemId}\"}")
                val props = detail.data.skuBase.props
                l("获取到的属性:${props}")
                // 从数据库中获取,以前选择的条件
                PlugInInit.daoSession.selectPropertyDao.queryBuilder()
                    .where(
                        SelectPropertyDao.Properties.ItemId.eq(
                            itemId
                        )
                    )
                    .unique()
                    ?.let {
                        // 初始化 选中条件
                        initSelectd(it, props)
                    }


                ChoosePropertyDialog(activity, props) {
                    // 保存数据
                    PlugInInit.daoSession?.queryBuilder(SelectProperty::class.java)
                        ?.where(SelectPropertyDao.Properties.ItemId.eq(itemId))
                        ?.unique()
                        .let { dbSelect ->
                            if (dbSelect == null) {
                                // 没有以前的选择记录
                                val property = SelectProperty()
                                property.itemId = itemId
                                property.tbProperty = it
                                property
                            } else {
                                // 存在以前的记录 更新
                                dbSelect.tbProperty = it
                                dbSelect
                            }
                        }.apply {
                            // 保存
                            PlugInInit.daoSession?.insertOrReplace(this)
                        }

                    // 保存数据完毕

                    confirm(it)
                }.show()


            } catch (e: Exception) {
                activity.showToast("商品属性获取失败,使用默认或者曾经记录的选项!")
                confirm(null)
            }
            dialog.dismiss()
        }


    }

    /**
     * 遍历设置上次选中的条件
     */
    private fun initSelectd(
        it: SelectProperty,
        props: List<Prop>
    ) {
        for (condition in it.getTbProperty()) {
            for (prop in props) {
                if (prop.name == condition.key) {
                    prop.values.find {
                        it.name == condition.value
                    }?.apply {
                        isSelected = true
                    }
                    break
                }
            }
        }
    }


    /**
     * 开始定时抢购
     */
    fun statTimeGo(
        chooseTime: ChooseTime,
        activity: Activity
    ) {
        val context = activity.applicationContext
        val intent = activity.intent.clone() as Intent
        val itemId = intent.getStringExtra("item_id") ?: ""

        activity.showCountDownDialog(chooseTime.time(), {
            // 停止
            l("倒计时停止")
        }, {
            l("倒计时开始")
            // 开始
            startGo(context, intent)
        })

    }

}