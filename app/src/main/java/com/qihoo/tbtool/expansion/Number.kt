package com.mm.red.expansion

import android.util.Log
import java.math.BigDecimal
import java.text.SimpleDateFormat

fun BigDecimal.to2(): BigDecimal {
    return setScale(2, BigDecimal.ROUND_HALF_UP)
}


fun BigDecimal.trimZero(): String {
    var s = toString()
    if (s.indexOf(".") > 0) {
        // 去掉多余的0
        s = s.replace("0+?$".toRegex(), "")
        // 如最后一位是.则去掉
        s = s.replace("[.]$".toRegex(), "")
    }
    return s
}

fun Number.toTimeFormat(pattern: String = "yyyyMMdd.HHmmss"): String {
    val v = toLong()
    return SimpleDateFormat(pattern).run {
        format(v)
    }
}


fun Number.fillZero(): String {
    return if (toLong() > 9) {
        toString()
    } else {
        "0${toShort()}"
    }
}

/**
 * 将秒变成
 * 时:分:秒的格式
 */
fun Number.formatTime(): String {
    val h = toLong() / 3600

    val m = (toLong() % 3600) / 60;

    val s = (toLong() % 3600) % 60;
    return "${h.fillZero()}:${m.fillZero()}:${s.fillZero()}"
}
