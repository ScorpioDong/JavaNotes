# Day 27

## 1. 注释

### 1.1 注释解释

```
注释：
	解释代码，给程序员看的
注解：
	Java语言中的类、方法、变量、参数和包等都可以被标注。和Javadoc不同，Java标注可以通过反射获取标注内容。在编译器生成类文件时，标注可以被嵌入到字节码中。Java虚拟机可以保留标注内容，在运行时可以获取到标注内容[2]。 当然它也支持自定义Java标注。
	JDK1.5 之后的特征
	用于说明程序
	一般在框架中使用
	格式：
		@AnnotationName
		
注解是有一部分参与编译的
```

### 1.2 注解作用

```
生成文档：
	代码中生成对应的JavaDoc API文档
	@param @return
	
代码检查
	继承重写，或者接口遵从之后的实现 @Override
	
代码数据获取：【小框架】
	通过反射获取指定注解中的一些内容，例如 配置，数据，操作，验证。。。
```

### 1.3 Java中预定义的注解

```
@Override
	重写、实现方法的情况下，检查方法声明是否和父类或接口中的声明一致，强制格式检查
@Deprecated
	标注当前方法已过时
@SuppressWarings("all")
	压制警告，可以用于一些代码无明确异常的情况下，压制一些警告
```

## 2. Java中自定义注解

### 2.1 Java中自定义注解

```
格式
	public @interface AnnotationName {
		属性 ==> 方法形式;
	}
Annotation注解是可以编译得到对应的.class字节码文件，验证了注解是可以参与编译过程的

通过反编译工具可以得到一下内容
【Annotation本质】
public interface MyAnnotation1 extends java.lang.annotation.Annotation {
}

MyAnnotation1
	本质是一个interface，同时java.lang.annotation.Annotation 子接口
```

### 2.2 Annotation注解属性

```
属性
	实际使用注解的方式，数据使用方式更加偏向于属性概念
	
	使用
		1. 在编写代码中使用
		2. 利用反射时，会涉及到对应值的概念来完成
	实际上是利用abstract方法来完成属性概念的
	
属性使用格式
	1. 属性的值数据类型和对应具体数据 ==> 返回值类型和返回值数据
		支持的类型：
            a. 基本数据类型
            b. String
            c. 其他注解 @开头
            d. 枚举类型
            e. 以上类型对应的数组
        属性值要求
        	a. 定义属性是可以使用default关键字定义默认值
        	b. 如果注解有且只有一个value属性，或者除value外其他属性都有默认值，可以在使用注解时，不指定属性名(单属性注解)
        	c. 属性是数据类型，{}大括号保存，并且不同的内容，使用逗号隔开
	2. 属性的键名字 ==> 方法的名字
```

### 2.3 注解的注解  ->  元注解

```
给予注解的解释，用于约束注解的一些操作问题
@Retention - 
	标识这个注解怎么保存，是只在代码中，还是编入class文件中，或者是在运行时可以通过反射访问。
	RetentionPolicy.RUNTIME：当前注解会编译生成对应的.class字节码文件，并且可以加
	载到JVM中，参与代码执行
	RetentionPolicy.CLASS: 
	
别纠结，记下就好：
	RetentionPolicy.SOURCE：注解将被编译器丢弃（该类型的注解信息只会保留在源码里，源码经过编译后，注解信息会被丢弃，不会保留在编译好的class文件里）
	@Override
	对应属性RetentionPolicy.SOURCE
	在代码编译过程中，检查方法格式是否正确，不参与代码运行和解析。
	
@Documented 
	标记这些注解是否包含在用户文档中。
	是否可以通过JavaDoc工具，生成对应的API文档
	
@Target 
	标记这个注解应该是哪种 Java 成员。
	属性:
		ElementType
			TYPE: 当前注解可以用于类声明
			METHOD: 当前注解可以用于方法声明位置
			FIELD：当前注解可以用于成员变量声明位置
@Inherited 
	标记这个注解是继承于哪个注解类(默认 注解并没有继承于任何子类)
	
【重点】
	@Target目标
		可以作用范围 类，方法，成员变量...
	@Retention
		RetentionPolicy.RUNTIME 常用
```

### 2.4 使用反射获取注解中的内容

```
MyAnnotation5 annotation = cls.getAnnotation(MyAnnotation5.class);
String s = annotation.className();
int id = annotation.id();
String name = annotation.name();
```

### 2.5 使用注解测试代码运行

```
// 从注解中获取对应的属性
Class<TestProject> cls  = TestProject.class;
ClassAnnotation annotation = cls.getAnnotation(ClassAnnotation.class);
```

## 3. 注解使用总结

```
1. 注解以后大多数情况下，都是使用过程，而不是自定义，会使用到框架中预处理好的注解。
2. 注解给谁用
	a. 编译器
	b. 代码解析器
	c. JVM运行代码使用
3. 注解是一个标签，有时是做标记的，有时是有属性的
```

