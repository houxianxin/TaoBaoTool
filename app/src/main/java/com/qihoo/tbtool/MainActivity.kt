package com.qihoo.tbtool

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import com.mm.red.expansion.*
import com.qihoo.tbtool.api.H5TBApi
import com.qihoo.tbtool.api.H5TBRetrofit
import com.qihoo.tbtool.api.TBRetrofit
import com.qihoo.tbtool.expansion.l
import com.qihoo.tbtool.util.ShellUtils
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import org.jetbrains.anko.toast
import java.util.*
import kotlin.math.log
import androidx.core.app.ComponentActivity
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T



class MainActivity : AppCompatActivity(), CoroutineScope by MainScope() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getRootPermissions()

        fab.setOnceClick(this) {
            openWebView("https://github.com/makeloveandroid/TaoBaoTool")
        }

        liability.setOnceClick(this) {
            showHintDialog(
                "免责声明",
                "本软件仅供学习使用，完全模拟人工操作，抢购速度取决于你手机的性能与网络，不涉及任何第三方软件接口，本软件已开放源代码，无病毒、不收集用户隐私信息，禁止使用本软件参与非法活动。一切因使用造成的任何后果概不负责，亦不承担任何法律责任!"
            ) {

            }
        }

        time.setOnceClick(this) {
            val dialog = showLoadDialog("正在获取淘宝时间...")

            launch {
                try {
                    val timestamp = TBRetrofit.api.getTimestamp()

                    l("时间${timestamp}")
                    val time = System.currentTimeMillis() - timestamp.data.t
                    val timeText = if (time > 0) {
                        "当前系统时间比淘宝快了${Math.abs(time)}ms"
                    } else {
                        "当前系统时间比淘宝慢了${Math.abs(time)}ms"
                    }

                    tv_time.text = timeText

                    var cmds = "date ${timestamp.data.t.toTimeFormat("MMddHHmmyyyy.ss")} set"

                    val execCmdAsync = ShellUtils.execCmdAsync(cmds, true) {
                        l(it.toString())

                        if (it.result == 0) {
                            showToast("同步时间成功!")

                        } else {
                            showToast("同步时间失败!")
                        }
                    }

                } catch (e: Exception) {
                    showToast("获取淘宝时间失败!")
                }

                dialog.dismiss()
            }


        }


    }

    private fun getRootPermissions() {
        try {
            Runtime.getRuntime().exec("su");
        } catch (e: Exception) {
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        cancel()
    }


    private fun openWebView(url: String) {
        val intent = Intent()
        intent.action = "android.intent.action.VIEW"
        val content_url = Uri.parse(url)
        intent.data = content_url
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
    }

}



