# Day 18

> Author: ScorpioDong

## 1. String类

### 1.1 获取方法

```
int length();![字符串比较要求](img/字符串比较要求.png)
	获取字符串长度 "" 
char charAt(int index);
	获取String字符串中指定下标位置的char类型字符，如果index超出有效范围
		StringIndexOutOfBoundsException
int indexOf(char ch);
int indexOf(String str);
int indexOf(char ch, int fromIndex);
int indexOf(String str, int fromIndex);
	这些方法都是获取指定元素所在的下标位置，元素可以是char类型字符，也可以是字符串。这里找出的是指定元素在字符串中第一次出现的位置，当然可以通过一定的约束，从哪个位置开始找fromIndex

int lastIndexOf(char ch);
int lastIndexOf(String str);
int lastIndexOf(char ch, int fromIndex);
int lastIndexOf(String str, int fromIndex);
	这些方法都是获取指定元素所在的下标位置，元素可以是char类型字符，也可以是字符串。这里找出的是指定元素在字符串中最后一次出现的位置，当然可以通过一定的约束，从哪个位置开始找fromIndex
	tips: 最后两个方法有坑！！！
```

### 1.2 判断方法

```
boolean endsWith(String str);
	判断当前字符串是不是以指定字符串结尾
boolean isEmpty();
	判断字符串是否为空 ""空串 JDK1.6之后 null不能读取，不能写入，不能调用方法
boolean equals(Object obj);
	继承重写Object类内的方法，完成字符串要求的比较方式
boolean equalsIgnoreCase(String str);
	不区分大小写比较
boolean contains(String str);
	判断指定字符串是否存在
```

### 1.3 转换方法

```
String(char[] arr);
	使用字符数组中内容创建一个字符串对象

String(char[] arr, int offset, int length);
String(char[] arr, int off, int len);
String(char[] arr, int off, int cou);
String(char[] arg0, int arg1, int arg2);
	使用字符数组中内容创建一个字符串对象，offset是从char类型数组中指定下标位置开始获取数据，获取的数据长度是length

static String valueOf(char[] arr);
	通过类名调用的静态方法，实际执行的是String(char[] arr);

static String valueOf(char[] arr, int offset, int length);
	通过类名调用的静态方法，实际执行的是String(char[] arr, int offset, int length);

char[] toCharArray();
	返回当前字符串对应的字符数组
```

### 1.4 其他方法

```
String replace(char oldChar, char newChar) 
	替换，替换不会修改原始的字符串，会创建一个新字符串返回，并且替换效果是所有的对应	的oldChar全部替换成newChar ???
String[] split(String regex) 
	按照指定的字符串切割当前字符串
	[00:00:15]XXXXXXX
String substring(int beginIndex) 
	从指定位置开始，截取子字符串，到字符串末尾
String substring(int beginIndex, int endIndex)
	从指定位置开始beginIndex，到endIndex结束，要头不要尾
String toUpperCase() 转大写
	字符串小写转大写
String toLowerCase() 转小写
	字符串大写转小写
String trim() 去除空格
	去除字符串两边的无用空格
```

## 2. IO流

### 2.1 什么是IO流

```
I
	input 输入流
	read 读取数据
o
	output 输出流
	write 写入数据

一般情况下都是按照当前程序的内存为参照物来考虑数据的走向问题
文件操作
	从内存中保存数据到硬盘 output
	从硬盘中读取数组到内存 input
	
IO流基类
	InputStream
		read
	OutputStream
		write
```

### 2.2 IO流分类

```
流向分类
	输入输出
文件操作处理单元分类
	字节流和字符流

FileInputStream
	文件操作输入字节流
FileOutputStream
	文件操作输出字节流

FileReader
	文件操作输入字符流
FileWriter
	文件操作输出字符流
```

### 2.3 文件操作字节流

#### 2.3.1 文件操作输入字节流

```
Constructor
	FileInputStream(File file);
		文件不存在，且路径正确，则创建文件
	FileInputStream(String pathName);
	
	构造方法会先删除数据，然后写入数据	

	异常：FileNotFoundException：文件未找到异常
	
Method 成员方法
	int read();
	int read(byte[] buf);
	int read(byte[] buf, int offset, int count);
```

### 2.3.2 文件读取缓冲

```
使用数据缓冲区可以大大提高数据的读写效率
```

#### 2.3.3 文件操作输出字节流

```
FileOutputStream 文件操作输出字节流

Constructor 构造方法
	FileOutputStream(File file);
		根据File类对象创建对应的文件输出字节流对象
	FileOutputStream(String pathName);
		根据String类型文件路径创建对应的文件输出字节流对象
	
	以上两个构造方法，创建的FileOutputStream是删除写/清空写操作，会将原文件中的内容全部删除之后，写入数据。
	
	FileOutputStream(File file, boolean append);
		根据File类对象创建对应的文件输出字节流对象。创建对象时给予append参数为
		true，表示追加写。
	FileOutputStream(String pathName, boolean append);
		根据String类型文件路径创建对应的文件输出字节流对象，创建对象时给予append参
		数为true，表示追加写。
	
	FileOutputStream构造方法是拥有创建文件的内容，如果文件存在，不创建，文件不存在且路径正确，创建对应文件。否则抛出异常FileNotFoundException
Method 成员方法	
	void write(int b);
		写入一个字节数据到当前文件中，参数是int类型，但是有且只会操作对应的低八位数
		据
	void write(byte[] buf);	
		写入字节数组中的内容到文件中
	void write(byte[] buf, int offset, int length);	
		写入字节数组中的内容到文件中，从指定的offset开始，到指定长度length
		
	以上方法会抛出异常：IOException
```

### 2.4 文件操作字符流

```
特征
	字符流 = 字节流 + 字符解码

如果是字符操作，效率还好
如果是非字符操作，凶多吉少

字符流操作文件
	使用记事本打开无乱码，可以使用
	视频文件，图片文件，特定格式文件，都无法使用字符流操作
	
Constructor
	FileReader(File)
	FileReader(String)
Method
	int read()
	int read(char[])
	int read(char[], off, len)
```

