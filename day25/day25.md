# Day 25

## 1. IDEA使用

## 2. XML

### 2.1 XML概述

```
Extensible Markup Language
可拓展标记语言

用途
	1. 数据存储，小型数据库，存在一定的CRUD操作可能性
	2. 网络端数据的传输
	3. JavaWEB框架项目配置文件
		Spring Druid ...
		
W3C 万维网联盟制定的规范
```

### 2.2 基本语法

```
1. XML文件后缀名.xml
2. XML第一行是对于当前文件的定义声明
3. XML文件只能有一个根标签
4. 属性值必须使用引号包含，推荐使用双引号
5. 标签必须正确匹配，必须正确开始和关闭
6. XML标签内严格区分大小写
```

```xml
<?xml version="1.0" encoding="utf-8" ?>
<users>
	<user>
        <name>James</name>
        <age>16</age>
        <gender>male</gender>
    </user>
</users>
```

### 2.3 文件组成部分

```
1. 文档声明
	a. 格式： <?xml 属性列表 ？>
		version：当前文件版本号
		encoding：编码方式
		standalone：是否依赖其他文件
			yes/no
			
2. 指令(了解)
	<? xml-stylesheet type"text/css" href="test.css" ?>
		可以导入CSS样式
		
3. 标签内容自定义
	规则
		a. 自定义标签可以使用英文字母，数字和其他标点（- _）
		b. 只能用英文字母
		c. 不允许自定义标签内使用xml标记
4. 属性
	可以给标签一个属性，有时候要求id唯一

5. 文本
	CDATA区，所见即所得，完整展示
	格式
		<![CDATA[数据]]>
```

### 2.4 XML文件数据约束

```
1. DTD
	一种简单的XML文件约束方式
	但是存在一定约束问题
2. Schema
	一种复杂的XML文件约束方式
	非常严谨，阅读性略差
```

#### 2.4.1 DTD约束

```dtd
<!-- students 根标签 要求根标签内存放student -->
<!ELEMENT students (student*) >
<!-- student标签包含子标签的内容 -->
<!ELEMENT student (name,age,sex)>
<!-- 所有子标签当前数据都都是文本形式 -->
<!ELEMENT name (#PCDATA)>
<!ELEMENT age (#PCDATA)>
<!ELEMENT sex (#PCDATA)>
<!-- ATTLIST Attribute List 属性列表 student id ID -->
<!ATTLIST student id ID #REQUIRED>
```

#### 2.4.2 Schema约束

```xsd
<?xml version="1.0"?>
<xsd:schema xmlns="http://www.qfedu.com/xml"
        xmlns:xsd="http://www.w3.org/2001/XMLSchema"
        targetNamespace="http://www.qfedu.com/xml" elementFormDefault="qualified">
    <!-- 根节点名字和包含的内容，内容是自定义studentType -->
    <xsd:element name="students" type="studentsType"/>
    <!-- studentType类型声明   -->
    <xsd:complexType name="studentsType">
        <xsd:sequence>
            <!-- students根节点中存放的是student类型  type="studentType" 要求student的个数从0开始 个数不限制 -->
            <xsd:element name="student" type="studentType" minOccurs="0" maxOccurs="unbounded"/>
        </xsd:sequence>
    </xsd:complexType>
    <!-- studentType声明 -->
    <xsd:complexType name="studentType">
        <xsd:sequence>
            <!-- 要求student标签内有name，age，sex子标签，并且要求对一个对应保存的数据类型是type指定 -->
            <xsd:element name="name" type="xsd:string"/>
            <!-- ageType 和 sexType 是自定义数据约束 -->
            <xsd:element name="age" type="ageType" />
            <xsd:element name="sex" type="sexType" />
        </xsd:sequence>
        <!-- 给予Student标签属性 属性为id，要声明idType， use="required"不可缺少的 -->
        <xsd:attribute name="id" type="idType" use="required"/>
    </xsd:complexType>
    <!-- sexType性别类型声明 -->
    <xsd:simpleType name="sexType">
        <xsd:restriction base="xsd:string">
            <!-- 有且只有两个数据 male female -->
            <xsd:enumeration value="male"/>
            <xsd:enumeration value="female"/>
        </xsd:restriction>
    </xsd:simpleType>
    <xsd:simpleType name="ageType">
        <xsd:restriction base="xsd:integer">
            <!-- 0 ~ 256 要求范围，是一个integer类型 -->
            <xsd:minInclusive value="0"/>
            <xsd:maxInclusive value="256"/>
        </xsd:restriction>
    </xsd:simpleType>
    <xsd:simpleType name="idType">
        <xsd:restriction base="xsd:string">
            <!-- ID类型，要求gp_xxxx(四位数字) -->
            <xsd:pattern value="gp_\d{4}"/>
        </xsd:restriction>
    </xsd:simpleType>
</xsd:schema> 
```

## 3. XML解析

### 3.1 XML解析思路

```
DOM解析
	Document Object Model 文件对象模型
	吧XML整个文件看做一个Document对象，们一个节点看做一个Element，节点中有Attribute，或者当前节点中存在Text文本内容
	缺点
		占用大量内存空间
	使用环境
		服务器环境	
SAX解析
	逐行读取，给予一定事件操作
	读取一行内容，释放一行内容，有效节约内存空间
	缺点
		不能对XML文件，进行增删改
	使用环境
		手机环境
```

### 3.2 XML文件解析

```
1. JAXP: Java原生，操作繁琐
2. Dom4j: DOM For Java 一款非常优秀的解析器
3. Jsoup： 基于Java完成的对HTML解析的工具
4. PULL：Android手机继承的XML解析工具，SAX
```

### 3.3 Dom4j使用入门

```
1. 导包
	导入第三方Jar包，官网获取
2. IDEA设置
3. Dom4j涉及到的方法
	SAXreader()；
		核心类
		raad() -> XML文件Document对象
		
	Document对象可以使用的方法
		Element getRootElement();
		
	Element对象使用的方法
		List elements();
		List elements(String name);
		Element element();
		Element element(String name);
		Attribute getAttribute(String name);
			String getValue()
		String getName();
		String getText();
```



## 4. XML文件保存

```
流程：
	1. 创建Document对象
	2. 通过Document对象来添加元素
		addElment();
		addAttribute();
```

