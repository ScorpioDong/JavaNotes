# Day 09  

> ScorpioDong

## 1. 面向对象三大特征

```
封装 继承 多态
```

## 2. 封装

### 2.1 不局限于面向对象的封装

```
方法的封装
工具类的封装
框架的封装

需要拥有封装额思想 ， 可以用于整合的知识点
```

### 2.2 符合JavaBean规范的类封装过程

```
代码规范非常重要
	后期可以有效的提供我们的开发效率
	
在Java中定义符合JavaBean规范的类的要求
	1. 所有的成员变量全部私有化 ==> private
	2. 必须提供一个无参构造函数
	2. 要求使用private修饰的成员变量提供对应的操作方法 ==> Setter Getter
```

#### 2.2.1 private关键字

```
private关键字是一个权限修饰符
	privat修饰的成员变量，成员方法，【构造方法】都是私有化内容，只能在类内部使用，类外没有操作权限。
```

#### 2.2.2 Setter 和Getter方法

```
private修饰的成员变量类外没哟任何操作权限，需要提供地赢得操作方法

Setter方法格式：
	public void set成员变量名（对应成员变量数据类型 成员变量形参） {
		this.成员变量名 = 成员变量形参；
	}
	
Getter方法格式：
	public 对应成员变量数据类型 get成员变量名（） {
		return 成员变量；
	}
如果成员变量是一个boolean类型，Getter方法格式：
	public 对应成员变量数据类型 is成员变量名（） {
		return 成员变量；
	}
```

## 3. 多类合作

### 3.1 什么是多类合作

```
在开发中，除了基本数据类型，大多数情况，都是类对象操作数据，作为：
	1. 方法参数
	2. 类定义是成员变量数据类型
```

### 3.2 方法的参数

```
需求：
	电脑类
		属性
			屏幕是否OK boolean
		方法
			电脑屏幕OK，可以看直播
	维修店类
		属性
			地址
			电话
			店名
		方法
			修电脑
```

### 3.3 成员变量类型为自定义类型

```
汽车
	发动机
	轮胎
	class Car
		Engine engine
		Tyre tyre1
	
发动机是个类
	class Engine
		型号
		排量
轮胎是个类
	class Tyre
		型号
		尺寸

```

## 4. 匿名对象

```
new 类构造方法().方法()

不推荐使用匿名对象的属性
	new 类构造方法().属性
```

## 5. 继承

### 5.1 生活中的继承

```
子承父业
龙生龙，凤生凤，老鼠的儿子会打洞
儿子长的特别像父母
```

### 5.2 Java中实现继承的方式

```
继承使用的关键字
	extends
Java中的继承是单继承模式

基本要求
	1. 子类继承父类之后，可以使用父类的非私有化成员
	2. 子类不能继承得到父类的私有化内容
```

### 5.3 继承的问题

#### 5.3.1 父类的构造方法被调用

![继承父类和子类内存分析图](/Users/scorpio/Desktop/Java/day09/day09.assets/继承父类和子类内存分析图.png)

#### 5.3.2 为什么会自动执行父类无参构造方法

```
这里有一个super关键字
	1. 调用父类成员方法和成员变量的关键字。
		[解决就近原则问题]
	2. 用于显式调用父类的构造方法。

super关键字调用父类的构造方法
	super(实际参数);
	Java编译器会根据实际参数的数据类型，参数顺序，选择对应的父类构造方法执行，初始化父类的成员空间，方法重载机制。
	
特征：
	1. 如果没有显式调用父类的构造方法，默认Java编译器会调用无参父类构造方法使用
	2. 根据数据类型选择对应方法
	3. super调用构造方法，必须在当前构造方法的第一行
```





## Tips:

```
1. 一定要有无参构造方法
```
