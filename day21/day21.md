# Day 21

## 1. 多线程

### 1.1 优缺点

- 优点
    1. 提升资源利用率
    2. 提高用户体验
- 缺点
    1. 降低了其他线程执行概率
    2. 用户会感受到软件的卡顿
    3. 增加了系统资源压力
    4. 多线程情况下的共享资源问题，线程冲突，线程安全问题

### 1.2 创建自定义线程类的两种方式

```
class Thread类
	Java中的线程类
	Runnable接口的实现类，同时提供了很多线程的操作使用方法
interface Runnable接口
	规定了What will be run？
	只有一个方法 run 方法
	
方式一：
	自定义线程类，继承Thread类，重写run方法
	直接调用start方法启动
方式二
	自定义线程类，实现Runnable接口
	通过Thread类的start方法启动
```

### 1.3 Thread类方法

```
Constructor
	Thread();
	Thread(Runnable target);
	Thread(String name);
	Thread(Runnable target, String name);
Method
	void setName(String name);
	String getName();
	void setPriority(int Priority);
	int getPriority();
	void start();
	
	public static void sleep(int ms);
	public static Thread currentThread();
```

## 2. 线程安全问题和解决方案

### 2.1 线程安全问题--共享资源使用问题

```

```

### 2.2 同步代码块

```java
synchronized (/* 锁对象 */) {
    
}
/*
特征
	1. synchronized 小括号里是锁对象，并且要求如果是多线程的情况下，锁对象必须是同一对象。
	2. synchronized 大括号中的代码块是需要同步的代码块，或者只加锁的代码，只允许一个线程进入
	3. 同步代码块越短越好，保证安全的前提下，提高性能

问题
	1. 锁对象存在隐患
	2. 代码层级关系复杂，看着有点麻烦
	3. 
*/
```

### 2.3 同步方法

```
synchronized 作为关键字修饰方法为同步方法

1. 静态成员方法
	锁对象为类文件
2. 非静态成员方法
	锁对象为this，当前类对象
```

### 2.4 Lock锁

```
Java提供了一个对于线程安全问题，加锁操作相对于同步代码块
1. Constructor
	Lock lock = new ReentrantLock()
2. Method
	加锁
		lock()
	开锁
		unlock()
```

### 2.5 三种加锁方式的总结

```
1. 一锁一线程，一锁多线程问题
	静态是一锁多线程，非静态是一锁一线程
	
2. 涉及到同步问题，要考虑好锁对象的选择问题
	同步代码块，同步方法，Lock对象
```

## 3. 守护线程

```
守护线程，也称后台线程，如果当前线程GG，守护线程也GG

守护线程一般用于：
	1. 自动下载
	2. 操作日志
	3. 操作监控

setDeamon(boolean flag)
	true 守护线程
	false 默认，正常线程
```

## 4. 线程状态

### 4.1 六种线程状态

```
Java中的线程有六种状态
```

<table>
<thead>
<tr>
<th>状态</th>
<th>导致状态发生条件</th>
</tr>
</thead>
<tbody>
<tr>
<td>NEW(新建)</td>
<td>线程刚刚被创建，没有启动</td>
</tr>
<tr>
<td>RUNNABLE(可运行)</td>
<td>线程已经可以在JVM中运行，是否运行不确定</td>
</tr>
<tr>
<td>BLOCKED(锁阻塞)</td>
<td>线程等待其他线程释放锁对象</td>
</tr>
<tr>
<td>WAITING(无限等待)</td>
<td>通过wait方法进入一个无限等待状态，需要另一个线程notify或者notifyAll唤醒</td>
</tr>
<tr>
<td>TIMED_WAITING(计时等待)</td>
<td>当前线程是等待状态，会在一定时间进入RUNNABLE方法，如Thread.sleep()或者Object中的wait(int ms)</td>
</tr>
<tr>
<td>TERMINATED(被终止)</td>
<td>因为run方法运行结束，正常退出，或者出现异常导致退出</td>
</tr>
</tbody>
</table>
### 4.2 TIMED_WAITING(计时等待)

```
Thread.sleep(int ms);
	当前线程休眠指定时间
Object.wait(int ms);
	当前线程进入计时等待状态
		1. 计时完毕，线程进入RUNNABLE
		2. 等待时间内，通过其他线程被notify或notifyAll唤醒
		
Sleep方法
	1. 调用之后休眠指定时间
	2. 必须执行在run方法内
	3. 不会打开当前进程持有的锁
```

### 4.3 BLOCKED(锁阻塞)

```
线程中有锁存在，线程未持有锁，进入锁阻塞状态，线程需要等待其他线程释放锁对象。当本线程持有锁对象后，进入可执行状态。

锁阻塞状态线程是否能够抢到锁对象，有很多因素
	1. 优先级问题，非决定因素
	2. CPU执行概率问题
后期高并发一定存在多线程操作锁问题，秒杀，抢购...
	队列方式解决
```

## Tips

```
1. 重写的方法的声明必须一致，和父类或者接口中的方法声明（包括异常抛出也要一致）
```

