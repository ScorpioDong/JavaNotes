# Day 19 

> Author: ScorpioDong

## 1. IO流

### 1.1 文件操作字符输出流

```
FileWriter文件操作输出字符流

Constructor 构造方法
	FileWriter(File file);
		根据File类对象创建对应文件的文件操作输出字符流
	FileWriter(String pathName);
		根据String类型文件路径创建对应文件的文件操作输出字符流
	FileWriter(File file, boolean append);
		根据File类对象创建对应文件的文件操作输出字符流，并要求为追加写
	FileWriter(String pathName, boolean append);
		根据String类型文件路径创建对应文件的文件操作输出字符流，并要求为追加写
	
	如果创建FileWrite对象时，这里文件不存在，路径合法，这里会创建对应的操作文件。如果路径不合法，抛出异常 FileNotFoundException 
	
Method 成员方法	
	void write(int ch);
		写入一个char类型数据到文件中
	void write(char[] arr);
		写入一个char类型数组到文件中
	void write(char[] arr, int offset, int length);	
		写入一个char类型数组到文件中，要求从offset下标位置开始读取数组数据，长度为
		length
	void write(String str);
		写入一个字符串到文件中
	void write(String str, int offset, int lenght);
		写入一个字符串到文件中，要求从指定字符串offset下标位置开始，长度为length
	如果写入数据操作过程中，发生问题，这里会有一个IOException
```

## 2. 缓冲流

### 2.1 缓冲流的作用

- 整体的读取，写入效率提升很大
- 降低了CPU通过内存访问硬盘的次数，提高了效率，降低了硬盘损耗

- `BufferedInputStream`:字节输入缓冲流
-  `BufferedOutputStream`:字节输出缓冲流
- `BufferedReader`:字符输入缓冲流
- `BufferedWriter`：字符输出缓冲流

```
缓冲流本身没有文件读写能力，需要对应的输入输出流配合使用
创建缓冲流时需要提供对应的输入输出流对象
底层提供一个默认的缓冲数组，提高效率
```

### 2.2 字节缓冲流

- `BufferedInputStream(InputStream in);`
- `BufferedOutputStream(OutputStream out);`

#### 2.2.1 字节输入流缓冲效率问题

```
1. 在BufferedInputStream底层中有一个默认容量为8KB的byte类型缓冲数组。
2. fill方法是一个操作核心
	a. 从硬盘中读取数据，读取的数据容量和缓冲数组容量一致。
	b. 所有的read方法，都是从缓冲数组中读取数据
	c. 每一次读取数据之前，都会检查缓冲区内是否有数据，如果没有，fill方法执行，填充数据。

3. 利用缓冲，fill方法，可以极大的降低CPU通过内存访问硬盘的次数。同时程序操作的数据是在内存中进行交互的。
```

#### 2.2.2 字节输出流缓冲效率问题

```
1. 在BufferedOutputStream类对象，默认有一个8KB的byte类型缓冲数组
2. 数据写入文件时并不是直接保存到文件中，而是保存在内存8KB字节缓冲数组中
3. 如果8KB空间填满，会直接flush缓冲区，数据保存到硬盘中，同时清空整个缓冲区。
4. 在BufferedOutputStream关闭时，首先会调用flush方法，保存数据到文件，清空缓冲区，并且规划缓冲区占用内存，同时关闭缓冲流使用的字节输出流。
```

### 2.3 字符缓冲流

```
BufferedReader
	字符缓冲输入流
	BufferedReader(Reader reader);
BufferedWriter
	字符缓冲输出流
	BufferedWriter(Writer writer);
```

#### 2.3.1 字符缓冲流效率问题

```
1. 字符缓冲输入流，底层有一个8192个元素的缓冲字符数组，而且使用fill方法从硬盘中读取数据填充缓冲数组

2. 字符缓冲输出流，底层有一个8192个元素的缓冲字符数组，使用flush方法将缓冲数组中的内容写入到硬盘当中。

3. 使用缓冲数组之后，程序在运行的大部分时间内都是内存和内存直接的数据交互过程。内存直接的操作效率是比较高的。并且降低了CPU通过内存操作硬盘的次数

4. 关闭字符缓冲流，都会首先释放对应的缓冲数组空间，并且关闭创建对应的字符输入流和字符输出流。

5. 
字符缓冲输入流中
	String readLine(); 读取一行数据
字符缓冲输出流中
	void newLine(); 换行
```

## 4. 序列化

### 4.1 序列化概述

```
Java中提供的一种序列化操作的方式，用一个字节序列化来表示一个对象，该字节序列化中保存了对象的属性，对象的类型，对象的数据。

从文件中读取字节序列化数据，可以直接得到对应的对象。
```

### 4.2 ObjectOutputStream类

```
将对象数据序列化，保存到文件中

构造方法 Constructor
	ObjectOutputStream(OutputStream out);
		输出字节流对象作为当前方法的参数
```

### 【序列化注意事项】

```
1. 如果一个类需要进行序列化操作，必须遵从。java.io.Serializable。不遵从无法进行序列化操作

2. 序列化之后从文件中读取序列化内容，转换成对应的对象，
	ClassNotFoundException 对应类没有找到。
		对应的类型没有导包，不存在...
	InvalidClassException 类型不一样
		序列化之后的每一个类都会有一个serialVersionUID，该编号在使用过程中，序列化
		和反序列化必须一致
	
3. transient 修饰的成员变量不能被序列化 
```

#### 