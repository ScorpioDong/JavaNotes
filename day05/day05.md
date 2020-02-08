# Day 05

> ScorpioDong

## 1. 复习

```
1. 循环结构
	a. while
	b. do - while 
	c. for
	d. break 关键字
	e. continue 关键字
2. 方法
  - 模板：
  public static ReturnType MethodName(Arguments) {
  	Method Body
  }
  - 无参数无返回值方法
```

## 2. 方法学习

### 2.1 无参数无返回值方法

 [参考Day03 - 3.3小结](../day04/day04.md)

### 2.2 有参数无返回值方法

```java
/*
	参数：
		当前方法执行时所需的外部数据
	需求
		展示一个int类型数据
	方法分析：
		public static：修饰符，不解释
		返回值类型：void 无返回值
		方法名：printIntNum
		形式参数列表：(int num)  一个int类型数据
	方法声明：
		public static void printIntNumber(int num);
*/
/**
* 打印一个int类型数据
* 
* @param num 要求用户传入一个int类型数据
*/
public static void printIntNumber(int num) {
  System.out.println("int数据为" + num);
}

/*
	调用时注意事项：
		1. 非有参数的方法，一定提供对应数据类型的实际参数
		2. 调用带参方法时，给予实参时，数据类型一致化
		3. 多参数方法中，需按形参列表给予对应个数和类型的实参
*/
```

### 2.3 无参数有返回值方法

```java
/*
	return关键字
		1. 结束当前方法的执行
		2. 数据可以返回到方法之外
	【注意】
		代码中如果需要返回值，必有一个明确的return
		方法返回值类型为void，可以用return结束方法
*/
/*
	需求：
		Give Me Five
	方法分析：
		public static: 修饰符
		返回值类型： int int类型的5
		方法名：giveMeFive
		形参列表：()
	public static int giveMeFive();
*/
/**
*	返回一个int类型的5
*
*	@return 返回值为int类型5
*
*/
public static int giveMeFive() {
  return 5;
}
```

### 2.4 有参数有返回值方法

```java
/*
	需求：
		计算两个int类型数据之和，返回结果
	方法分析：
		public static：固定格式
		返回值类型：int
		方法名：getSumOfTwoNumber
		形参列表：(int num1, int num2)
	方法模板
		public static int getSumOfTwoNumber(int num1, int num2);
*/
/**
* 计算两个int类型数据之和，返回结果
*
* @param num1 int类型数据
* @param num2 int类型数据
* @return 两个int数据之和，返回值类型为int
*/
public static int getSumOfTwoNumber(int num1, int num2) {
  return num1 + num2;
}
```

## 3.方法总结

### 3.1 方法三要素

```
1. 返回值
2. 方法名
3. 形式参数列表
```

#### 3.1.1 返回值类型

```
『建议』
	尽量减少黑盒方法的使用。
1. 返回值类型需考虑对应的含义
	- 计算结果，状态监控，判断情况...
2. 选择合适的返回值类型
	a. 不要答非所问
	b. 考虑数据的延展性
3. 返回值一个方法有且只能有一个返回值类型
4. 目前建议：
	- 当下不要考虑使用数组作为返回值类型
```

#### 3.1.2 方法名

```
1. 见明知意，动宾结构，小驼房命名法
2. 代码是一个好的代码
3. 全英文
```

#### 3.1.3 形式参数列表

```
1. 整个方法运行过程中，需要的必要外来数据
2. 形式参数列表和实际参数列表的个数、类型和顺序完全一致
3. 考虑好对应的数据类型
```

### 3.2 方法的封装过程

```
需求分析：
	1. 分析需求的作用是什么
	2. 考虑方法的名字
	3. 形参列表
	4. 返回值类型选择和对应含义解释
分步骤完成
  - 可以用注释完成每一步需要做的事情
  - 实现代码
  	- 不要认为自己的代码一定是对的
  - 验证过程
  	1. 正确情况下代码是否OK
  	2. 使用错误情况验证代码的健壮性是否OK
```

## 4. 文档注释规范

```java
/**
* 当前方法的具体解释，说明利害关系
*
* @param arguments 参数名字 功能解释，参数要求
* @return 返回值解释，数据类型，返回值函数，状态，要求
*/
```

## Tips

```
1. 方法中尽量减少return的个数
```

