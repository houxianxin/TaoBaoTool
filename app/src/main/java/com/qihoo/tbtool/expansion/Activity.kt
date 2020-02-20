package com.mm.red.expansion

import android.app.Activity
import android.app.AlertDialog
import android.app.Dialog
import android.app.ProgressDialog
import android.content.DialogInterface
import android.text.InputFilter
import android.text.InputType
import android.text.Spanned
import android.text.method.DigitsKeyListener
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.*
import com.qihoo.tbtool.core.taobao.view.CountDownDialog

import java.math.BigDecimal

fun Activity.showHintDialog(tile: String, msg: String, block: () -> Unit) {

    AlertDialog
        .Builder(this)
        .setTitle(tile)
        .setMessage(msg)
        .setPositiveButton("确定") { dialogInterface: DialogInterface, i: Int ->
            block()
        }
        .setNegativeButton("取消", null)
        .setCancelable(false)
        .show()

}


fun Activity.showLoadDialog(msg: String): Dialog {
    return ProgressDialog(this).apply {
        setMessage(msg)
        setCancelable(false)
        show()
    }
}


fun Activity.showCountDownDialog(time: Long, stop: () -> Unit, start: () -> Unit): Dialog {
    return CountDownDialog(this, time, stop, start).apply {
        show()
    }
}
