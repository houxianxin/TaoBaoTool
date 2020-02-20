package com.qihoo.tbtool.dao

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import org.greenrobot.greendao.database.Database

class MySQLiteOpenHelper(context: Context?, name: String?, factory: SQLiteDatabase.CursorFactory?) :
    DaoMaster.OpenHelper(context, name, factory) {


    override fun onUpgrade(db: Database?, oldVersion: Int, newVersion: Int) {
        MigrationHelper.migrate(db, object : MigrationHelper.ReCreateAllTableListener {
            override fun onCreateAllTables(db: Database?, ifNotExists: Boolean) {
                DaoMaster.createAllTables(db, ifNotExists);
            }

            override fun onDropAllTables(db: Database?, ifExists: Boolean) {
                DaoMaster.dropAllTables(db, ifExists)
            }

        }, SelectPropertyDao::class.java)
    }

}