# Day 12

## 1. 项目

```
学生管理系统
```

## 2. 异常

### 2.1 生活中的异常

### 2.2 代码中的异常

```
Throwable类
	Java中所有异常的超类，在Java中所有异常，错误的基类都是Throwable类
	
Throwable
--| Exception 异常 可以处理， 代码还有拯救的可能
--| Error 错误 没救了

Throwable常用方法
	Constructor
		Throwable():Throwable构造方法，Throwable类对象中，存储的异			常或错误信息为null
		Throwable(Stirng message):Throwable构造方法，Throwable			 类对象中，存储异常或错误信息为message
	Method
		String getMessage():返回异常或错误信息
		String toString():返回报名（有错误或异常信息会展示）
		void printStackTrace(): 红色字体展示错误前因后果
```

### 2.3 Exception和Error区别

```
Exception 异常， 可以处置
Error 错误，不可处置，智能避免
```

### 2.4 异常处理

#### 2.4.1 捕获异常

```
try - catch 结构
try - catch - finally 结构 后期设计到资源问题

格式
    try {
		// 可能出现异常代码
    } catch (/* 对应处理的异常对象 */) {
    	// 处理方式
    }
```

#### 2.4.2 抛出异常

```
throw
	在方法内抛出异常
throws
	在【方法声明】位置，告知调用者当前方法有哪些异常
	
1. 一个代码块内，有且只能抛出一个异常
2. throw位置开始，之后的代码不再运行
3. 代码存在throw抛出异常，在方法声明位置告知用户什么异常
```

#### 2.4.3 抛出和捕获的对比

```
捕获之后，代码可以正常运行，要保证处理之后的异常不会再导致其他问题。

抛出的确可以解决很多问题，并且可以让代码健壮性很强。但到用户层面说什么也不能抛出异常。
	所谓不能抛出，指不能将错误信息直接给用户
	
用户密码错误情况
	1. 捕获异常
	2. 通过异常处理，将错误抛出
	3. 给与用户友好的提示
```

#### 2.4.4 为什么不使用大异常和为什么出错

```
Exception
	No!!!
	对症下药!
	不能所有的异常都使用Exception捕获或者抛出无法得知具体的异常类型，无法做到对症下药
	
为什么出错
	IDE都会有当前错误的提示
	正常情况下，只要不是带有自定义异常的方法，通常都会有异常处理方式
```

### 2.5 RuntimeException

```
运行时异常
	JVM在运行的过程中可以非检查异常
	例如：
		ArrayIndexOutOfBoundException
		NullPointerException
		StringIndexOutOfBoundException
		ArithmeticException
	
	这些异常在代码中如果出现，不需要在代码中强制进行捕获或抛出的异常
```

### 2.6 自定义异常

```
代码运行过程中存在一定的生活化
	例如
		用户名密码错误
		NoGirlFriendException
		
自定义异常格式
	class 自定义异常类名 extends Exception {
		// No Fields Constructor
		
		// String Field Constructor
	}
	自定义异常类名
		必须以Exception结尾
```

