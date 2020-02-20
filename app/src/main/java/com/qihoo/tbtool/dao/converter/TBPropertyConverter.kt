package com.qihoo.tbtool.dao.converter

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.greenrobot.greendao.converter.PropertyConverter

class TBPropertyConverter : PropertyConverter<HashMap<String, String>, String> {
    companion object {
        val gson = Gson()
    }

    override fun convertToDatabaseValue(entityProperty: HashMap<String, String>): String {
        return gson.toJson(entityProperty)
    }

    override fun convertToEntityProperty(databaseValue: String): HashMap<String, String> {

        val typeToken = object : TypeToken<HashMap<String, String>>() {
        }.type
        return gson.fromJson(databaseValue, typeToken)
    }

}