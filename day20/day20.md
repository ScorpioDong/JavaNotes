# Day 20

## 1. StringBuffer

### 1.1 StringBuffer概述

```
	为了解决String字符串操作导致的内存冗余，提高效率，Java中提供了StringBuffer和StringBuilder来操作字符串，并且提供了很多方法，便于程序员开发。
	StringBuffer 线程安全，效率较低
	StringBuilder 线程不安全，效率较高
```

### 1.2 StringBuffer构造方法

```
Constructor
	StringBuffer();
		空StringBuffer，底层初始化16字符char类型数组
	StringBuffer(String str);
		根据提供字符串创建对应StringBuffer空间，length属性加16决定char数组空间
```

### 1.3 添加方法

```
append(Everything);
insert(int index, Everything)
```

### 1.4 查看方法

```
String toString();
int length();
String subString(int begin);
String substring(int begin, int end);
int indexOf(char ch);
int indexOf(String str);
```

### 1.5 修改方法

```
replace(int begin, index end, String str)
setCharAt(int index, char ch);
```

### 1.6 删除和反序

```
delete(int start, int end);
deleteCharAt(int index);
reverse();
```

## 2. Math工具类

```
static double ceil(double); 向上取整
static double floor(double);向下取整
static long round(double);四舍五入
static double random(); 0~1之间的随机小数
```

## 3.日期类

###  3.1 Date类

```
Constructor
	Date()
		创建当前时间Date对象
	Date(long date)
		根据时间戳，创建对应的Date对象
		
常用方法
	long getTime();
		获取Date类对象获取对应当前时间毫秒数
```

### 3.2 Calender日历类

```
	Calender日历类，替换了很多Date类中的方法，把很多的数据都作为静态属性，通过特定的方法获取，比Date类处理日期数组更加方便
	
	Calender是abstract修饰的类，通过getInstance方法获取其类实例对象
	
	public int get(int field);
	public void set(int field, int value);
	public Date getTime();
	
	字段名
		YEAR			年
		MONTH			月（0开始，加1）
		DAY_OF_MONTH	日
		HOUR			时（12）
		HOUR_OF_DAY		时（24）
		MINITE			分
		SECOND			秒
		DAY_OF WEEK		周几（周日为1，减1）
```

### 3.3. DateFormat 时间格式

```
概述
	DateFormat是一个abstract修饰的类，用于时间格式转换，不能直接使用
	SimpleDateFormat可以使用
	
	SimpleDateFormat构造方法参数是String匹配规则
```

#### 时间匹配规则

<table class="striped">
<caption style="display:none">Chart shows pattern letters, date/time component, presentation, and examples.</caption>
<thead>
    <tr>
        <th scope="col" style="text-align:left">Letter
        <th scope="col" style="text-align:left">Date or Time Component
        <th scope="col" style="text-align:left">Presentation
        <th scope="col" style="text-align:left">Examples
</thead>
<tbody>
    <tr>
        <th scope="row"><code>G</code>
        <td>Era designator
        <td><a href="#text">Text</a>
        <td><code>AD</code>
    <tr>
        <th scope="row"><code>y</code>
        <td>Year
        <td><a href="#year">Year</a>
        <td><code>1996</code>; <code>96</code>
    <tr>
        <th scope="row"><code>Y</code>
        <td>Week year
        <td><a href="#year">Year</a>
        <td><code>2009</code>; <code>09</code>
    <tr>
        <th scope="row"><code>M</code>
        <td>Month in year (context sensitive)
        <td><a href="#month">Month</a>
        <td><code>July</code>; <code>Jul</code>; <code>07</code>
    <tr>
        <th scope="row"><code>L</code>
        <td>Month in year (standalone form)
        <td><a href="#month">Month</a>
        <td><code>July</code>; <code>Jul</code>; <code>07</code>
    <tr>
        <th scope="row"><code>w</code>
        <td>Week in year
        <td><a href="#number">Number</a>
        <td><code>27</code>
    <tr>
        <th scope="row"><code>W</code>
        <td>Week in month
        <td><a href="#number">Number</a>
        <td><code>2</code>
    <tr>
        <th scope="row"><code>D</code>
        <td>Day in year
        <td><a href="#number">Number</a>
        <td><code>189</code>
    <tr>
        <th scope="row"><code>d</code>
        <td>Day in month
        <td><a href="#number">Number</a>
        <td><code>10</code>
    <tr>
        <th scope="row"><code>F</code>
        <td>Day of week in month
        <td><a href="#number">Number</a>
        <td><code>2</code>
    <tr>
        <th scope="row"><code>E</code>
        <td>Day name in week
        <td><a href="#text">Text</a>
        <td><code>Tuesday</code>; <code>Tue</code>
    <tr>
        <th scope="row"><code>u</code>
        <td>Day number of week (1 = Monday, ..., 7 = Sunday)
        <td><a href="#number">Number</a>
        <td><code>1</code>
    <tr>
        <th scope="row"><code>a</code>
        <td>Am/pm marker
        <td><a href="#text">Text</a>
        <td><code>PM</code>
    <tr>
        <th scope="row"><code>H</code>
        <td>Hour in day (0-23)
        <td><a href="#number">Number</a>
        <td><code>0</code>
    <tr>
        <th scope="row"><code>k</code>
        <td>Hour in day (1-24)
        <td><a href="#number">Number</a>
        <td><code>24</code>
    <tr>
        <th scope="row"><code>K</code>
        <td>Hour in am/pm (0-11)
        <td><a href="#number">Number</a>
        <td><code>0</code>
    <tr>
        <th scope="row"><code>h</code>
        <td>Hour in am/pm (1-12)
        <td><a href="#number">Number</a>
        <td><code>12</code>
    <tr>
        <th scope="row"><code>m</code>
        <td>Minute in hour
        <td><a href="#number">Number</a>
        <td><code>30</code>
    <tr>
        <th scope="row"><code>s</code>
        <td>Second in minute
        <td><a href="#number">Number</a>
        <td><code>55</code>
    <tr>
        <th scope="row"><code>S</code>
        <td>Millisecond
        <td><a href="#number">Number</a>
        <td><code>978</code>
    <tr>
        <th scope="row"><code>z</code>
        <td>Time zone
        <td><a href="#timezone">General time zone</a>
        <td><code>Pacific Standard Time</code>; <code>PST</code>; <code>GMT-08:00</code>
    <tr>
        <th scope="row"><code>Z</code>
        <td>Time zone
        <td><a href="#rfc822timezone">RFC 822 time zone</a>
        <td><code>-0800</code>
    <tr>
        <th scope="row"><code>X</code>
        <td>Time zone
        <td><a href="#iso8601timezone">ISO 8601 time zone</a>
        <td><code>-08</code>; <code>-0800</code>;  <code>-08:00</code>
</tbody>
</table>

#### 4. System类

```
System类提供了大量的静态方法，操作的内容和系统有关
	long currentTimeMillis(); 获取系统时间戳
	Properties getProperties(); 获取系统属性
	exit(int status); 退出当前程序
	数组拷贝
        arrayCopy(Object obj,   -- 原数组  
            int srcPos,			-- 原数组起始位置
            Object dest,		-- 目标数组
            int destPos,		-- 目标数组起始位置
            int length)			-- 拷贝长度
```

## 5. Runtime类

```
Runtime当前程序运行环境类对象
获取
	Runtime Runtime.getRuntime()
	
方法
	gc() 并不会立刻执行，只会加速其回收
	
	long totalMemory()  总内存
	long freeMemory()	空闲内存
	long maxMemory()    最大内存
	
	Process exec() 打开程序
```

## 6. 包装类

### 6.1 基本类型和对应包装类

| 基本类型 | 对应的包装类 |
| :------: | :----------: |
|   byte   |     Byte     |
|  short   |    Short     |
|   int    |   Integet    |
|   long   |     Long     |
|  float   |    Float     |
|  double  |    Double    |
| boolean  |   Boolean    |
|   char   |  Character   |

### 6.2 自动装箱和拆箱

```
基本类型到包装类之间的转换
装箱		基本类型到包装类
拆箱		包装类到基本类型
```

## 7. 多线程

```
进程 
	一个应用程序
	存在多个功能 -> 线程
线程 
	程序中的某一个功能
	多个功能同时执行 -> 多线程
	多线程同时抢占执行，会导致系统资源紧缺	
	
并发
	两个或两个以上的事物在同一个时间段发生
	宏观并行  微观串行
并行
	两个或两个以上的事物在同一个时刻发生
	
高并发
	同时在一个时间段内，很多事件都发生
```

