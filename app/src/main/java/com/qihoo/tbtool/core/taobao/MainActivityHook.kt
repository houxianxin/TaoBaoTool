package com.qihoo.tbtool.core.taobao

import android.app.Activity
import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import com.qihoo.tbtool.core.PlugInInit
import com.qihoo.tbtool.expansion.l
import de.robv.android.xposed.XC_MethodHook
import de.robv.android.xposed.XposedHelpers
import de.robv.android.xposed.callbacks.XC_LoadPackage

object MainActivityHook {
    fun hook(lpparam: XC_LoadPackage.LoadPackageParam) {
        XposedHelpers.findAndHookMethod(
            Activity::class.java,
            "onCreate",
            Bundle::class.java,
            object : XC_MethodHook() {
                @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
                override fun afterHookedMethod(param: MethodHookParam) {
                    super.afterHookedMethod(param)
                    val activity: Activity = param.thisObject as Activity
                    // 获取 Activity 的全路径昵称
                    val simpleName = activity.javaClass.name
                    if (simpleName == "com.taobao.tao.TBMainActivity") {
                        l("初始化操作完成!")
                        PlugInInit.init(activity)
                    }
                }
            })

    }
}