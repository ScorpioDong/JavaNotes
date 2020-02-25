# Day 17 Map和File

> Author: ScorpioDong

## 1. Map双边队列

### 1.1 什么是Map

```
键(Key)值(Value)对

程序开发中大部分数据都是键值对形式的
	MySQL JSON XML 类对象成员变量和存储的数据
	从前端发送的的数据可以转成Map格式 ==> 一键生成类对象 ==> 一键存储到数据库
	
interface Map<K, V>
--| class HashMap<K, V> 哈希表结构
--| class TreeMap<K, V> 树形结构,K有对应的排序方式

Map双边队列中，键是唯一的，值可以重复
```

### 1.2 Map双边队列方法

- 增
    - `put(K k, V v)`: 存入一个键值对,kv符合泛型约束
    - `putAll(Map<? extends K, ? extends V> map)`
- 删
    - `remove(Object k)`:删除k 对应的键值对
- 改
    - `put(K k, V v)`:对应当前的k存在
- 查
    - `int size()`
    - `boolean isEmpty()`
    - `boolean containsKey(Object key)`
    - `boolean containsValue(Object value)`
    - `Set<K> keySet()`：
        - 返回Map双边队列Key对应的Set集合
    - `Collection<V> values()`：
        - 返回Map双边队列Value对应Collection集合

### 1.3 EntrySet

```
Entry 可以认为是键值对对象
定义在Map类内
	class Entry<K, V> {
		K k;
		V v;
	}
	K,V是完全依赖于Map约束的，这里可以Entry里面保存的是每一个键值对类对象

Map中提供了一个方法
	Set<Entry<K, V>> entrySet
	返回值是键值对类对象Set集合
	Set集合中存储的是Entry类型
	Entry类型是带有泛型的
```

### 1.4 TreeMap<K, V> 以及Comparable和Comparator

```
K是需要有对应的比较方式，如果没有比较方式，无法存入。

推荐使用Comparator接口
```

## 2. File类

### 2.1 什么是File类

```
SUN公司提供给开发者操作文件和文件夹的一个类对象
	Java中一切皆对象，计算机中一切皆文件
	
获取File类的三种方式（Constructor）
	File(String pathName);
	File(String parent, String child);
	File(File parent, String child);
	
File.separatorChar 根据系统区分不同分隔符
```

### 2.2 创建文件和文件夹

```
boolean createNewFile();
	通过File类对象调用，创建对应File类对象中保存的路径的普通文件。
	返回false原因
		1. 路径不合法
		2. 对应文件夹没有写入权限
		3. 文件已存在

boolean mkdir();
	通过File类对象，创建对应File类对象中保存路径的文件夹
	返回false的原因
		1. 路径不合法
		2. 对应文件夹没有写入权限
		3. 文件夹已存在

mkdirs();
	创建文件夹，多重路径同时创建
	
boolean renameTo(File dest);
	通过File类对象调用，转为目标File类对象dest
	文件、文件夹移动，重命名
```

### 2.3 删除文件或者文件夹

```
booelan delete();
	通过File类对象调用，删除对应的文件或文件夹
	要求
		1. 删除的文件或文件夹，直接抹掉
		2. 非空文件夹无法删除
	
void deleteOnExit();
	程序退出时删除对应文件或文件夹
	用于删除文件运行过程中，留下的日志文件，缓存文件，操作日志...
```

### 2.4 文件属性判断

```
boolean isFile();
boolean isDirctory();
boolean isAbsolute();
	是否使用了绝对路径
boolean isHidden();
	是否是隐藏文件
boolean exists();
	文件是否存在
```

### 2.5 获取文件属性

```
String getPath()
String getName()
String getParent()
String getAbsolute()

long lastNodified()
	获取文件的最后一次修改时间，返回值是一个时间戳类型

long length()
	获取文件大小，占用硬盘空间字节数
```

### 2.6 列表方法

```
static File[] listRoots();
	只针对Windows有效,获取当前电脑内所有根盘符对象
File[] listFiles();
	通过File类对象调用，获取当前File类对象对应的文件夹下的所有子文件或子文件夹File对象
String[] list();
	通过File类对象调用，获取当前File类对象对应的文件夹下的所有子文件或子文件夹名字String类型
```

### 2.7 FileNameFilter

```java
interface FileNameFilter {
	boolean accept(File dir, String name);
}
```

## 3. 常用API -- String

```
使用双引号包含的字符串都是字符串常量
双引号包含的字符串都是存在与内存的【数据区】

* 字符串常量操作中，使用原本的两个字符串拼接之后完成一盒心得字符串常量

这里导致的字符串冗余问题，后期会使用StringBuilder和StringBuffer解决
```

