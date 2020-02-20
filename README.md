## 提醒
如果大家有需要抢购的物品，可以提 issues 备注上抢购物品的入口方式，我可以兼容增加秒杀逻辑。  

![](http://p0.qhimg.com/t01be2a3ce3171dde59.gif)

## 升级公告
### 版本 2.1 更新内容：
感谢 [whoamixx1](https://github.com/whoamixx1) 提供的商品属性 `API` 已经解决遗留问题。
1. 增加抢购预设界面，若抢购预设的属性商品没有，会默认选择最后一个可选项。

![](http://p0.qhimg.com/t01fe8e3afe72f11701.png)

2. 定时抢购时间提示优化.  
![](http://p0.qhimg.com/t01fa03a1dce6e66abd.png)  

3. 同步淘宝时间,关于 `Root` 权限获取优化
4. 修正属性展示不全的问题

## 故事背景
I am a programmer, I have a dream!  

![](https://i04piccdn.sogoucdn.com/8b682d508954cba0)

没错！我有一个车厘子自由的梦想，但是看到淘宝车厘子的价格。  

![](http://p0.qhimg.com/t014813f5f5625301c4.jpg)  

![](https://i03piccdn.sogoucdn.com/410fa501bb98ea69)  

（口吐芬芳中。。。） `5` 斤就要 `399` 米币，虽是 `3J` 但是也太贵了吧！！什么是 `3J` 呢？下面我给大家科普下！    

## 车厘子知识小课堂
![](http://p0.qhimg.com/t01f48b938cc0a27b01.jpg)  

智利的车厘子分为SXJ级、XJ级别、J级别、XL级别、L级别，其中SXJ级别为最顶级，以杆绿、肉脆如冬枣、色紫黑如宝石为最优，等级不同差价也相当大

主要是按颗粒的直径大小来划分，按果粒大小一般分为：(不同公司所用标识不同，所以同一规格可能有多种字母表示)。具体如下：
果粒直径 | 俗称
:---:|:---:
果粒直径32mm以上 |写作 XG\SG\XP\SP\XXXJ\XXSJ 俗称4勾
果粒直径30mm-32mm写作 |G\P\XSJ\SXJ\XXJ\SSJ 俗称3勾
果粒直径28mm-30mm写作 |XJ\SJ\JJ 俗称双勾
果粒直径26mm-28mm写作 |J 俗称单勾
果粒直径24mm-26mm写作 |XL 俗称XL
果粒直径22mm-24mm写作 |L 俗称L

补充说明，上方提到的字母代表含义为：
字母 | 描述
:---:|:---:
G=GIANT |巨大的
P=PREMIUM |特级的
S=SUPER |超级的
X=EXTRA |额外的、更加的
J=JUMBO |较大
L=LARGE |大

代表车厘子的颜色的字母：
字母 | 描述
:---:|:---:
L\R|浅颜色（红色）
D|深颜色（紫色）
L=LIGHT |浅
R=RED |红色
D=DARK |深

命名规则：大小规格在前，颜色在后，公司包装厂不同略有不同。

例如：XXJL 即3J红
PD 即3J黑
JR 即单J红

![](http://p0.qhimg.com/t01f3708c9d7a7e116b.gif)

## 实现梦想的机会
突然有一天，我发现了淘宝 `聚划算百亿补贴` 活动。  

![](http://p0.qhimg.com/t014f57f27ea3e81e45.jpg)

`109` 丶`109` 只要 `109` ，你就可以得到 `5` 斤 `3J` 车厘子，机不可失失不再来！！！我天，太便宜了，我要抢，我要抢！！  

![](http://p0.qhimg.com/t016462c2901440fab8.jpg)  

说实话，真的太难抢了，我找同事帮忙也都是秒没！！好烦啊！！闲鱼上找人花了 `40` 元大洋找人代强，也没帮我抢到！  

![](http://p0.qhimg.com/t019cd4999b49ddd5a8.jpg)  

好烦，求人不如求自己，一气之下，我打开了我的电脑。  

![](http://p0.qhimg.com/t012b81f037bb7959fd.jpg)  

自己手撸一个秒杀软件，最后既然被还真的让我秒杀上了！！  

![](http://p0.qhimg.com/t01691f9d514dddafc0.jpg)  

看看我的战利品！

![](http://p0.qhimg.com/t014fa1030649bbcfbb.jpg)  

![](http://p0.qhimg.com/t01ff128de344de25e2.jpg)

# 正篇
`淘宝秒杀插件` 插件是基于 `Xposed` 开发，通过 `Xposed` 的注入，完成模拟按键操作，快速检测是否可以购买，并模拟下单的功能。  

[git地址](https://github.com/makeloveandroid/TaoBaoTool)  

[博客地址](https://www.wenyingzhi.com/mu-lu-5/feng-mian-2)

## 功能&特色
1. `Xposed` 模拟按键，更快速，更准确
2. 秒速下单
3. 可定时抢购
4. 理论兼容所有淘宝版本
5. 省钱

`2020` 年聚划算百亿补贴活动还是相当给力的，用我软件还是存在概率能秒到的哦！  
![](http://p0.qhimg.com/t01aa1ac4fd70ef092e.jpg)
![](http://p0.qhimg.com/t01d66ee731d8f1562e.jpg)


## 如何使用呢？
1. 安装 [360分身大师X版](https://a.app.qq.com/o/simple.jsp?pkgname=com.qihoo.magic.xposed)
2. 在 [360分身大师X版](https://a.app.qq.com/o/simple.jsp?pkgname=com.qihoo.magic.xposed) 添加最新版本淘宝秒杀插件
3. 在 [360分身大师X版](https://a.app.qq.com/o/simple.jsp?pkgname=com.qihoo.magic.xposed) 添加淘宝秒杀插件分身本程序分身
4. 分身中启动淘宝，进入需要抢购的物品页面（我主要去抢聚划算百亿补贴的东西）。  

![](http://p0.qhimg.com/t01af9a7b4a76f9a26c.jpg)
![](http://p0.qhimg.com/t01e848646ffcec98b7.png)  

5. 等待要抢时间，例如 `12:00` 开始抢购，我们在 `11:59:58` 秒左右，点击 ![](http://p0.qhimg.com/t017d47fa8ca6650b06.png) 按钮，软件就开始 `快速刷新页面`，当能点击 `立即购买` 按钮时候，便可瞬间下单。  

![](http://p0.qhimg.com/t01b474f896ca3b8cfd.gif)

6. 当然你也可以定时抢哦。  

![](http://p0.qhimg.com/t016dc10108b1a52473.png)

注意：  

![](http://p0.qhimg.com/t01be2a3ce3171dde59.gif)

[git地址](https://github.com/makeloveandroid/TaoBaoTool)  

## 遗留问题
~~现在软件还无法预设抢单的订单属性功能，默认是选择最后一个可选属性作为下单条件！这是一个遗留问题，后续想办法解决。~~

感谢 [whoamixx1](https://github.com/whoamixx1) 提供的商品属性 `API` 已经解决遗留问题。

## 免责声明
本软件仅供学习使用，完全模拟人工操作，抢购速度取决于你手机的性能与网络，不涉及任何第三方软件接口，本软件已开放源代码，无病毒、不收集用户隐私信息，禁止使用本软件参与非法活动。一切因使用造成的任何后果概不负责，亦不承担任何法律责任!
