# Day 29

## 1. Stream 流

### 1.1 引入

```
	Stream 流不是I/O流，按照流水线处理方式来考虑代码中的思想。
	JDK1.8 之后，我们拥有了Lambda表达式，让代码的中心偏向解决实际问题，直到重点，可以提高效率。
	Stream流中使用了大量Lambda表达式，利用Lambda操作方式，提供开发效率
```

### 1.2 传统遍历方式和Stream流方式

```
Stream流更倾向于重点
```

### 1.3 Stream流对应的思想

```
流水线
	原材料从头到尾只会占用一份空间，中间的过程中不会占用空间，最后生成一个结果。
	
Stream流有一些特征：
	1. 带有很多Stream流操作的方法，filter、limit、map、sorted、skip...这些方法大多是都会使用到函数式接口，有Lambda表达式
	2. 整个Stream流模型造作过程中，只有执行到count，foreach等方法，操作真正的执行中的模型，如果不存在结果向导，中间的所有操作是无效的，这里得益于Lambda表达式的延后性。
	3. Stream流是存在一定的管道性Pipelining流水线
```

### 1.4 获取Stream流

```
java.util.stream.Stream<T> JDK1.8新特征
	1. 所有的Collection<T>集合都有对应的stream();
	2. 可以通过Stream类中的static Stream of() 获取
		static Stream<T> of(T... t);
		static Stream<T> of(T t);
```

### 1.5 Stream常用方法

```
延迟方法
	返回值类型依然是Stream接口，没有允许我们操作真正的资源
	允许链式操作
终结方法
	返回类型不是Stream接口本身，要么处理数据，要么返回其他类型数据，
	不再支持链式操作
	count、foreach
```

#### 1.5.1 foreach方法【终结方法】

```java
void foreach(Cunsumer<? super T> action);
/*
终结方法
	需要一个Consumer接口进行操作，消耗一个数据
	可以使用Lambda表达式
*/
```

#### 1.5.2 filter方法 

```java
Stream<T> filter(Predicate<? super T> filter);
/*
    filter 是过滤方法，需要的参数使Predicate接口，
    可以使用Lambda方法
    这里返回值类型是过滤后的Stream流对象，可以进行链式操作
    Predicate接口方法  	
*/
```

#### 1.5.3 map方法

```java
<R> Stream<R> map(Function<? super T, ? super R> fun);
/*
类型转换操作，得到的一个转换之后数据类型的Stream流对象
这里需要的参数是Functtion函数式接口，
	R apply(T t);
	T类型的数据转换成R类型数据
*/
```

#### 1.5.4 count方法 【终结方法】

```java
long count();
/*
返回当前Stream流对象中有多少个元素
类似有Collection接口下的size(). String的length();
【终结方法】
	一旦执行Stream流对象被关闭
*/
```

#### 1.5.5 limit方法

```java
Stream<T> limit(long maxSize);
/*
对于当前Stream流对象操作的数据进行限制操作，限制个数到maxSize
例如：
	Stream流中保存7个数据，取前5个。
*/
```

#### 1.5.6 skip 方法

```java
Stream<T> skip(long n);
/*
返回值依然是一个Stream流对象，这里跳过当前Stream流对象前n个元素
*/
```

#### 1.5.7 concat方法

```java
static Stream<T> concat(Stream<? extends T> stream1,Stream<? extends T> stream2);
/*
拼接两个Stream流对象，是一个静态方法，得到一个新的Stream流对象
*/
```

#### 1.5.8 原始操作方式和Stream流操作方式对比

```
1. 一个String类型的字符串集合
2. 过滤，得到包含5的数据
3. 跳过前三个数据
4. 限制得到前5个数据
5. 两个String类型集合字符串合并
6. 转换成Person类型
7. 展示
```

## 2. 方法引用

### 2.1 Lambda冗余问题以及方法引用初识

### 2.2 方法引用小要求

```
 testPrint("郑州加油!!!", str -> System.out.println(str));
 
 testPrint("郑州加油!!!", System.out::println);
 
 1. 明确对象
 	对象 ==> 调用者
 	类对象，类名，super，this，构造方法，数组构造方法
 2. 明确的执行方法
 	该方法只有名字不需要显式出现参数
 3. 需要处理的数据
 	【联想，推导，省略】
 4. :: 方法引用格式
```

### 2.3 通过类对象执行方法引用

```
1. 明确对象
	类对象
2. 明确执行的方法
	自定义
3. 处理的数据
	简单要求为String类型
```

### 2.4 通过类名执行方法引用

### 2.5 通过super关键字执行方法引用

### 2.6 通过this关键字执行方法引用

