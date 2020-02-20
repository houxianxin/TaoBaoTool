package com.qihoo.tbtool.bean

import com.google.gson.annotations.SerializedName


data class CommodityDetail(
    @SerializedName("api")
    val api: String,
    @SerializedName("data")
    val data: CommodityDetailData,
    @SerializedName("ret")
    val ret: List<String>,
    @SerializedName("v")
    val v: String
)

data class CommodityDetailData(
    @SerializedName("apiStack")
    val apiStack: List<ApiStack>,
    @SerializedName("debug")
    val debug: Debug,
    @SerializedName("item")
    val item: Item,
    @SerializedName("mockData")
    val mockData: String,
    @SerializedName("params")
    val params: Params,
    @SerializedName("props")
    val props: Props,
    @SerializedName("props2")
    val props2: Props2,
    @SerializedName("propsCut")
    val propsCut: String,
    @SerializedName("rate")
    val rate: Rate,
    @SerializedName("resource")
    val resource: Resource,
    @SerializedName("seller")
    val seller: Seller,
    @SerializedName("skuBase")
    val skuBase: SkuBase,
    @SerializedName("vertical")
    val vertical: Vertical
)

data class ApiStack(
    @SerializedName("name")
    val name: String,
    @SerializedName("value")
    val value: String
)

data class Debug(
    @SerializedName("app")
    val app: String,
    @SerializedName("host")
    val host: String
)

data class Item(
    @SerializedName("brandValueId")
    val brandValueId: String,
    @SerializedName("cartUrl")
    val cartUrl: String,
    @SerializedName("categoryId")
    val categoryId: String,
    @SerializedName("commentCount")
    val commentCount: String,
    @SerializedName("countMultiple")
    val countMultiple: List<Any>,
    @SerializedName("exParams")
    val exParams: ExParams,
    @SerializedName("favcount")
    val favcount: String,
    @SerializedName("images")
    val images: List<String>,
    @SerializedName("itemId")
    val itemId: String,
    @SerializedName("openDecoration")
    val openDecoration: Boolean,
    @SerializedName("rootCategoryId")
    val rootCategoryId: String,
    @SerializedName("skuText")
    val skuText: String,
    @SerializedName("subtitle")
    val subtitle: String,
    @SerializedName("taobaoDescUrl")
    val taobaoDescUrl: String,
    @SerializedName("taobaoPcDescUrl")
    val taobaoPcDescUrl: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("tmallDescUrl")
    val tmallDescUrl: String
)

class ExParams(
)

data class Params(
    @SerializedName("trackParams")
    val trackParams: TrackParams
)

data class TrackParams(
    @SerializedName("BC_type")
    val bCType: String,
    @SerializedName("brandId")
    val brandId: String,
    @SerializedName("categoryId")
    val categoryId: String
)

data class Props(
    @SerializedName("groupProps")
    val groupProps: List<GroupProp>
)

data class GroupProp(
    @SerializedName("基本信息")
    val 基本信息: List<基本信息>
)

data class 基本信息(
    @SerializedName("Apple型号")
    val apple型号: String,
    @SerializedName("CPU品牌")
    val cPU品牌: String,
    @SerializedName("CPU型号")
    val cPU型号: String,
    @SerializedName("CPU核心数")
    val cPU核心数: String,
    @SerializedName("上市时间")
    val 上市时间: String,
    @SerializedName("分辨率")
    val 分辨率: String,
    @SerializedName("后置摄像头")
    val 后置摄像头: String,
    @SerializedName("品牌")
    val 品牌: String,
    @SerializedName("售后服务")
    val 售后服务: String,
    @SerializedName("套餐类型")
    val 套餐类型: String,
    @SerializedName("存储容量")
    val 存储容量: String,
    @SerializedName("屏幕尺寸")
    val 屏幕尺寸: String,
    @SerializedName("屏幕材质")
    val 屏幕材质: String,
    @SerializedName("屏幕类型")
    val 屏幕类型: String,
    @SerializedName("手机类型")
    val 手机类型: String,
    @SerializedName("接口类型")
    val 接口类型: String,
    @SerializedName("摄像头类型")
    val 摄像头类型: String,
    @SerializedName("操作系统")
    val 操作系统: String,
    @SerializedName("机身厚度")
    val 机身厚度: String,
    @SerializedName("机身颜色")
    val 机身颜色: String,
    @SerializedName("款式")
    val 款式: String,
    @SerializedName("版本类型")
    val 版本类型: String,
    @SerializedName("生产企业")
    val 生产企业: String,
    @SerializedName("电信设备进网许可证编号")
    val 电信设备进网许可证编号: String,
    @SerializedName("电池容量")
    val 电池容量: String,
    @SerializedName("电池类型")
    val 电池类型: String,
    @SerializedName("网络模式")
    val 网络模式: String,
    @SerializedName("网络类型")
    val 网络类型: String,
    @SerializedName("耳机插头类型")
    val 耳机插头类型: String,
    @SerializedName("视频显示格式")
    val 视频显示格式: String,
    @SerializedName("触摸屏类型")
    val 触摸屏类型: String,
    @SerializedName("运行内存RAM")
    val 运行内存RAM: String,
    @SerializedName("键盘类型")
    val 键盘类型: String,
    @SerializedName("附加功能")
    val 附加功能: String
)

data class Props2(
    @SerializedName("groups")
    val groups: List<Group>,
    @SerializedName("majorProps")
    val majorProps: List<MajorProp>
)

data class Group(
    @SerializedName("groupName")
    val groupName: String,
    @SerializedName("properties")
    val properties: List<Property>
)

data class Property(
    @SerializedName("propertyIcon")
    val propertyIcon: String,
    @SerializedName("propertyName")
    val propertyName: String,
    @SerializedName("valueText")
    val valueText: String
)

data class MajorProp(
    @SerializedName("propertyIcon")
    val propertyIcon: String,
    @SerializedName("valueText")
    val valueText: String,
    @SerializedName("valueTextTransform")
    val valueTextTransform: String
)

data class Rate(
    @SerializedName("keywords")
    val keywords: List<Keyword>,
    @SerializedName("rateList")
    val rateList: List<RateX>,
    @SerializedName("totalCount")
    val totalCount: String
)

data class Keyword(
    @SerializedName("attribute")
    val attribute: String,
    @SerializedName("count")
    val count: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("word")
    val word: String
)

data class RateX(
    @SerializedName("content")
    val content: String,
    @SerializedName("dateTime")
    val dateTime: String,
    @SerializedName("feedId")
    val feedId: String,
    @SerializedName("headPic")
    val headPic: String,
    @SerializedName("images")
    val images: List<String>,
    @SerializedName("isVip")
    val isVip: String,
    @SerializedName("memberLevel")
    val memberLevel: String,
    @SerializedName("skuInfo")
    val skuInfo: String,
    @SerializedName("tmallMemberLevel")
    val tmallMemberLevel: String,
    @SerializedName("userName")
    val userName: String
)

data class Resource(
    @SerializedName("entrances")
    val entrances: Entrances
)

data class Entrances(
    @SerializedName("askAll")
    val askAll: AskAll
)

data class AskAll(
    @SerializedName("icon")
    val icon: String,
    @SerializedName("link")
    val link: String,
    @SerializedName("text")
    val text: String
)

data class Seller(
    @SerializedName("allItemCount")
    val allItemCount: String,
    @SerializedName("atmophereMask")
    val atmophereMask: Boolean,
    @SerializedName("atmosphereColor")
    val atmosphereColor: String,
    @SerializedName("atmosphereImg")
    val atmosphereImg: String,
    @SerializedName("atmosphereMaskColor")
    val atmosphereMaskColor: String,
    @SerializedName("brandIcon")
    val brandIcon: String,
    @SerializedName("brandIconRatio")
    val brandIconRatio: String,
    @SerializedName("creditLevel")
    val creditLevel: String,
    @SerializedName("creditLevelIcon")
    val creditLevelIcon: String,
    @SerializedName("entranceList")
    val entranceList: List<Entrance>,
    @SerializedName("evaluates")
    val evaluates: List<Evaluate>,
    @SerializedName("evaluates2")
    val evaluates2: List<Evaluates2>,
    @SerializedName("fans")
    val fans: String,
    @SerializedName("fbt2User")
    val fbt2User: String,
    @SerializedName("goodRatePercentage")
    val goodRatePercentage: String,
    @SerializedName("newItemCount")
    val newItemCount: String,
    @SerializedName("sellerNick")
    val sellerNick: String,
    @SerializedName("sellerType")
    val sellerType: String,
    @SerializedName("shopCard")
    val shopCard: String,
    @SerializedName("shopIcon")
    val shopIcon: String,
    @SerializedName("shopId")
    val shopId: String,
    @SerializedName("shopName")
    val shopName: String,
    @SerializedName("shopTextColor")
    val shopTextColor: String,
    @SerializedName("shopType")
    val shopType: String,
    @SerializedName("shopUrl")
    val shopUrl: String,
    @SerializedName("shopVersion")
    val shopVersion: String,
    @SerializedName("showShopLinkIcon")
    val showShopLinkIcon: Boolean,
    @SerializedName("simpleShopDOStatus")
    val simpleShopDOStatus: String,
    @SerializedName("starts")
    val starts: String,
    @SerializedName("taoShopUrl")
    val taoShopUrl: String,
    @SerializedName("userId")
    val userId: String
)

data class Entrance(
    @SerializedName("action")
    val action: List<Action>,
    @SerializedName("backgroundColor")
    val backgroundColor: String,
    @SerializedName("borderColor")
    val borderColor: String,
    @SerializedName("text")
    val text: String,
    @SerializedName("textColor")
    val textColor: String
)

data class Action(
    @SerializedName("key")
    val key: String,
    @SerializedName("params")
    val params: ParamsX
)

data class ParamsX(
    @SerializedName("trackName")
    val trackName: String,
    @SerializedName("trackParams")
    val trackParams: TrackParamsX
)

data class TrackParamsX(
    @SerializedName("spm")
    val spm: String
)

data class Evaluate(
    @SerializedName("level")
    val level: String,
    @SerializedName("levelBackgroundColor")
    val levelBackgroundColor: String,
    @SerializedName("levelText")
    val levelText: String,
    @SerializedName("levelTextColor")
    val levelTextColor: String,
    @SerializedName("score")
    val score: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("tmallLevelBackgroundColor")
    val tmallLevelBackgroundColor: String,
    @SerializedName("tmallLevelTextColor")
    val tmallLevelTextColor: String,
    @SerializedName("type")
    val type: String
)

data class Evaluates2(
    @SerializedName("level")
    val level: String,
    @SerializedName("levelText")
    val levelText: String,
    @SerializedName("levelTextColor")
    val levelTextColor: String,
    @SerializedName("score")
    val score: String,
    @SerializedName("scoreTextColor")
    val scoreTextColor: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("titleColor")
    val titleColor: String,
    @SerializedName("type")
    val type: String
)

data class SkuBase(
    @SerializedName("props")
    val props: List<Prop>,
    @SerializedName("skus")
    val skus: List<Sku>
)

data class Prop(
    @SerializedName("name")
    val name: String,
    @SerializedName("pid")
    val pid: String,
    @SerializedName("values")
    val values: List<Value>
)

data class Value(
    @SerializedName("name")
    val name: String,
    @SerializedName("vid")
    val vid: String,
    var isSelected: Boolean = false
) {
    override fun equals(other: Any?): Boolean {
        return other?.let {
            return it.toString() == this.name
        } ?: false
    }
}

data class Sku(
    @SerializedName("propPath")
    val propPath: String,
    @SerializedName("skuId")
    val skuId: String
)

data class Vertical(
    @SerializedName("askAll")
    val askAll: AskAllX
)

data class AskAllX(
    @SerializedName("askIcon")
    val askIcon: String,
    @SerializedName("askText")
    val askText: String,
    @SerializedName("linkUrl")
    val linkUrl: String,
    @SerializedName("model4XList")
    val model4XList: List<Model4X>,
    @SerializedName("modelList")
    val modelList: List<Model>,
    @SerializedName("questNum")
    val questNum: String,
    @SerializedName("showNum")
    val showNum: String,
    @SerializedName("title")
    val title: String
)

data class Model4X(
    @SerializedName("answerCountText")
    val answerCountText: String,
    @SerializedName("askIcon")
    val askIcon: String,
    @SerializedName("askText")
    val askText: String,
    @SerializedName("askTextColor")
    val askTextColor: String
)

data class Model(
    @SerializedName("answerCountText")
    val answerCountText: String,
    @SerializedName("askText")
    val askText: String
)

