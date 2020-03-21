# Day 26 

## 1. TCP网络聊天室实现

##### 1.1 分析

```
客户端
	功能：
		1. 数据发送
		2. 数据接收
	技术:
		1. socket
		2. 输入流和输出流
		3. 多线程，客户端功能模块有两个线程
	聊天：
		1. 群聊
		2. 私聊
			私聊前缀 @服务器用户ID号:msg
	
服务器
	功能:
		1. 数据转发
		2. 用户注册
	技术:
		1. ServerSocket
		2. 每一个用户对应的Sokcet对象
		3. 多线程同时在线
		4. HashMap<Integer, 用户>
	数据转发:
		私聊前缀判断
		群聊所有人发送
```

##### 1.2 客户端实现

```
数据发送:
	使用输出流发送数据给服务器
	遵从Runnable接口
数据接收:
	使用输入流从服务器端接收数据
	遵从Runnable接口

客户端主方法:
	用户名提交
	数据发送
	数据接收
		多线程启动
```

##### 1.3 资源关闭问题

```
代码中操作了大量的输入流和输出流，这里都需要进行关闭操作。
	DataInputStream, DataOutputStream, BufferedReader, Socket
	
以上这些资源都是Closeable接口的实现类，都有对应的Close方法
封装一个工具类:
	提供一个closeAll方法，参数为符合Closeable接口的实现类对象。
	这里可以考虑可变长参数
		Closeable... closeable
	
	可变长参数在方法中使用的过程里面是对应一个数组，这里完成可以使用增强for来使用

工具类名：
	CloseUtil
		public static void closeAll(Closeable... closeable)
```

##### 1.4 功能拓展

```
1. 用户退出
	用户输入指定字段之后可以退出
	客户端Socket服务
	服务端Socket服务
	涉及资源关闭，线程关闭

2. 用户异常退出
	在运行过程中发现问题，需要及时处理，关闭对应的资源，终止对应的线程

3. 服务器保存所有的聊天记录
```

## 2. JSON

### 2.1 JSON概述

```
JSON
	JavaScript
	JavaScript Object Notation
	（JavaScript Object Notation，JavaScript对象表示法，读作/ˈdʒeɪsən/）是一种由道格拉斯·克罗克福特构想和设计、轻量级的数据交换语言，该语言以易于让人阅读的文字为基础，用来传输由属性值或者序列性的值组成的数据对象。尽管JSON是JavaScript的一个子集，但JSON是独立于语言的文本格式，并且采用了类似于C语言家族的一些习惯
```

### 2.2 数据格式

```
对象特征
	1. 数据形式为键值对形式
	2. 数据支撑：字符串，数字，true false
	3. {}大括号以内的数据
	
数组特征：
	1. 数据使用[]中括号包含
	2. []中都是JSON格式对象
	3. 每一个对象都是使用逗号隔开，同时最后一个元素后不需要使用
```

[JSON格式验证](www.bejson.com)

### 2.3 解析JSON格式的工具

```
常用的工具：
	Gson，fastjson，Jackson
```

#### 2.3.1 FastJson内容

```
JSON核心类
	JSON核心类提供解析和转化方法，用于解析JSON数据格式，同时用于转换类对象到JSON格式，该类对象需要符合JavaBean规范
	--| JSONArray
		存在按照键值对方式解析获取数据，同时存在一定的List方法
	--| JSONObject
		获取对应的类对象，指定键值对对应数据的方法
```

