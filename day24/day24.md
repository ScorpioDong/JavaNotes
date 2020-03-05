# Day 24

## 1. 反射

### 1.1 Java文件和.class文件的关系

```
Java文件
	Java文件中包含代码的所有内容
	
.class文件
	.java文件通过javac编译工具生成对应的.class字节码文件
		包含
			Class 完整的包名，类名
			Field 成员变量
			Method 成员方法
```

### 1.2 程序加载过程和.class文件的关系

```
在Java文件运行过程中，当前程序需要哪一个类参与代码执行，那么就需要加载这个类的.class字节码文件，该.class字节码文件时在程序的加载阶段，存在于内存的【代码区】
	
	.class字节码文件既然加载到内存的【代码区】
	.class文件中包含对应Java程序的所有内容
	代码区存在一块空间 ==> .class ==> Java程序的所有内容
```

### 1.3 Java中的万物皆对象

```
在Java代码中，把在内存代码区保存的.class字节码内存空间，看做是一个对象，而该对象包含了所有内容
```

## 2. 反射必会方法

### 2.1 Class涉及到的方法

```
Class Class.forName(String packageNameAndClassName)
    Class类的静态成员方法，通过完整的包名和类名获取对应的.class文件的Class对象
    同时也可以作为.class文件加载方法
    
Class 类名.class;
	获取对应的Class类对象，通常用于方法的参数类型

Class 类对象.getClass()；
    通过类对象获取对应.class的Class类对象，方法参数，或者说数据类型判断
        
获取的Class类对象是同一个对象
```

### 2.2 Constructor 构造方法类涉及到的方法

```
public Constructor[] getConstructors();
	获取当前Class类对象对应Java文件中所有非私有化构造方法的类对象数组
	
public Constructor[] getDeclaredConstructors();
	获取当前Class类对象对应Java文件中所有构造方法的类对象数组

public Constructor getCOnstructor(Class... initArgumentTypes)
	根据指定的数据类型，选择对应的构造方法，这里可能抛出异常
	只能获取非私有化构造方法类对象，私有化使用Declared【暴力反射】
	Class : 约束数据类型 int.class String.class
	... : 不定长参数
	
Object newInstance(Object... initArguments);
	通过Constructor对象调用，传入房钱构造方法所需创建所需创建对象的初始化参数，创建对象
```

### 2.3 Method成员方法涉及到的方法

```
Method[] getMethods();
	获取类内所有public方法，包括继承来的
Method[] getDeclaredMethods();
	暴力反射
	获取全部，但不包括继承的方法
	
Method getMethod(String methodName, Class...);
	根据指定的方法名和对应的参数类型，获取对应的public修饰的方法

Method getDeclaredMethod(String methodName, Class... parameterTypes);
	根据指定的方法名和对应的参数类型，获取对应的成员方法，包括私有化成员方法，但是不包括从父类继承而来的方法

Object invoke(Object obj, Object... Arguments);
	通过Method类对象调用，执行对应的执行者的方法
```

### 2.4 Field成员变量涉及到的方法

```
Field[] getFields();
	获取类内所有public修饰的成员变量
Field[] getDeclaredFields();
	获取类内所有成员变量，包括私有化成员方法

Field getField(String fieldName);
	获取指定变量名的成员变量对象，要求是public修饰的成员变量

Field getDeclaredField(String fieldName);
	获取指定变量名的成员变量对象，包括private私有化修饰的成员变量
	
void set(Object obj, Object value);
	设置指定调用者中对应成员变量的数据
	
Object get(Object obj);
	获取指定调用者中指定成员变量的数据
```

### 2.5 给予暴力反射私有化内容的权限操作

```java
setAccessible(boolean flag);
	给予Constructor，Method, Field对象，私有化内容，操作权限设置
true表示可以操作
```

#### 