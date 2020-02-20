package com.qihoo.tbtool.core

import android.content.Context
import com.qihoo.tbtool.dao.DaoMaster
import com.qihoo.tbtool.dao.DaoSession
import com.qihoo.tbtool.dao.MySQLiteOpenHelper

object PlugInInit {
    lateinit var daoSession: DaoSession

    fun init(context: Context) {
        initDb(context)
    }

    private fun initDb(context: Context) {
        val dbHelper = MySQLiteOpenHelper(context, "TB_DB", null)
        val writableDatabase = dbHelper.getWritableDatabase()
        daoSession = DaoMaster(writableDatabase).newSession()
    }


}