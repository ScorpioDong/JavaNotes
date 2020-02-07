# Day 04

> ScorpioDong

## 1. 复习

``` 
运算符：
	关系运算符
	逻辑运算符
	自增自减运算符
	三元运算符
    
Scanner使用
  导包  import java.util.Scanner;
  声明  Scanner sc = new Scanner(System.in);
  方法  nextInt(); nextDouble(); nextLine();
		
分支结构
  if
  if - else
  if - else if
  switch - case

局部变量
  1. 作用域
  2. 重定义问题
  3. 未定义、未赋值不能使用
```

## 2. 循环结构

### 2.1 为什么使用循环

```
某功能多次使用时，CV大法缺点：
  1. 代码过于臃肿，AJCG规定方法体代码小于80行
  2. 代码阅读性极差
  3. 代码维护性差
```

### 2.2 while 循环

```java
while (/* 循环条件判定表达式 */) {
  // 循环体
  // (循环条件变更)
}

// (常用)循环变量 i j k l m n 

/*
	1. 避免死循环
	2. Ctrl + C 退出程序执行
*/
```

### 2.3 do - while 循环

```java
do {
  // 循环体
  // (循环条件变更)
} while (/* 循环条件判定表达式 */);

/*
	1. 分号结尾
*/
```

### 2.4 for 循环

```java
for (/* 循环条件初始化 */; /* 循环条件判断 */; /* 循环条件变更 */;) {
  // 循环体
}
/*
	
*/
```

### 2.5 break 关键字

```
字面意思：
		打破！！！
* switch - case 跳出case选择或default选择
* 循环中使用是用于跳出循环
```

### 2.6 continue 关键字

```
继续！！！
* 跳出此次循环，继续执行下次循环

注意：
  1. while 和 do - while 中需要注意循环变更条件，防止出现死循环
  2. for循环没啥隐患
```

### 2.7. 循环使用总结

```
1. 找出代码中运行的规律，完成循环的实现
		数组、集合、数据遍历、算法...
2. 时时刻刻注意循环中的坑
		死循环，continue...
3. 学会循环变量的变量推理过程
		for循环循环次数、循环终止条件
4. 学会使用嵌套循环
5. 模块化处理的思想
6. 普适性代码和代码延展性考虑
```

## 3. 方法初探

### 3.1 为什么使用方法

```
1. 循环解决了一部分复用问题，但治标不治本
  a. 代码过于臃肿
  b. 阅读性极差
  c. 维护性极差
```

### 3.2 main 方法分析

```java
public static void main(String[] args) {
  
}
/*
	public static : 公有的、静态的
	void : 返回值，没有返回值
	main : 方法名，小驼峰命名法、见明知意、动宾结构
	String[] args : 形式参数列表
	
	public static ReturnType MethodName(Arguments) {
			Method Body
	}
	
*/
```

### 3.3 无参数无返回值方法

```java
/**
	说明方法的作用
*/
public static void methodName() {
  // 方法体
}

/*
		定义在类内、方法体外
		调用: 方法名()
*/
```



## Tips

```
1. 开发中使用 == 判断，尽量满足常量在前，变量在后
```

