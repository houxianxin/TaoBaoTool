package com.qihoo.tbtool.api

import com.facebook.stetho.okhttp3.StethoInterceptor
import com.qihoo.tbtool.bean.CommodityDetail
import com.qihoo.tbtool.bean.Timetamp
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import java.util.concurrent.TimeUnit

private val appInterceptor = mutableListOf<Interceptor>()

private val netInterceptor = mutableListOf<Interceptor>().apply {
    add(StethoInterceptor())
}
private val http: OkHttpClient = OkHttpClient
    .Builder()
    .apply {
        appInterceptor.forEach {
            addInterceptor(it)
        }

        netInterceptor.forEach {
            addNetworkInterceptor(it)
        }
    }
    .connectTimeout(30, TimeUnit.SECONDS)
    .readTimeout(30, TimeUnit.SECONDS)
    .writeTimeout(30, TimeUnit.SECONDS)
    .build()


open class BaseRtrofit(val baseUrl: String) {
    val retrofit by lazy {
        Retrofit.Builder().client(http)
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


}


interface TBApi {
    // http://api.m.taobao.com/rest/api3.do?api=mtop.common.getTimestamp
    @GET("/rest/api3.do")
    suspend fun getTimestamp(@Query("api") api: String = "mtop.common.getTimestamp"): Timetamp
}


interface H5TBApi {
    //http://h5api.m.taobao.com/gw/mtop.taobao.detail.getdetail/6.0/?data=%7B%22itemNumId%22%3A%22609197376738%22%7D
    @GET("/gw/mtop.taobao.detail.getdetail/6.0")
    suspend fun getDetailById(@Query("data") itemId: String): CommodityDetail
}

/**
 * 淘宝API
 */
object TBRetrofit : BaseRtrofit("http://api.m.taobao.com") {
    val api = retrofit.create(TBApi::class.java)
}

object H5TBRetrofit : BaseRtrofit("http://h5api.m.taobao.com") {
    val api = retrofit.create(H5TBApi::class.java)
}