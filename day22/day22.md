# Day 22

> Author:ScorpioDong

## 1. 多线程

### 1.1 WAITING(无限等待)

当某一线程被执行wait()方法，需要等待其他线程进行唤醒操作。

+ public void wait();

    - 当前线程进入无线等待状态

    - 开启锁对象

+ public void notify();

    + 唤醒一个当前锁对象有关的无线等待线程，随机选择
    + 开启锁对象

+ public void notifyAll();

    + 唤醒所有和当前锁对象有关的线程
    + 开启锁对象
    + 进入锁对象抢占过程，有可能进入锁阻塞状态

## 2. 线程通信

```
现在存在两个完全无关的线程，生产者和消费者，但是商品会作为他们两者之间的共享资源。

生产者和消费者中都有一个成员变量
	商品类型

【解决方案】
创建生产者或者消费者线程对象时，使用同一个商品类对象，作为构造方法参数进行初始化操作
```

## 3. 线程池

```
	不管是继承Thread还是遵从Runnable接口，都需要重写Run方法，而且每一个线程对象有且只能执行一次，之后就会被销毁。
	利用Runnable接口来提供执行目标，而且借助于Thread执行线程。
	
线程池 ==> 可以容纳多个线程的容器
	程序可以从线程池获取线程来完成目标代码
	同时也可以将线程归还给线程池。
	省去了创建线程和销毁线程这样非常繁琐的操作。

线程池使用：
 public static ExecutorService newFixedThreadPool(int nThreads);
 	得到一个线程对象，初始化参数是要求的当前线程池中的线程数
 
 public Future submit(Runnable target);
 	从线程池中获取一个线程对象，并且执行给定的Runnable接口实现类对象作为执行目标
```

## 4. Lambda表达式

```
service.submit(() -> System.out.println(Thread.currentThread().getName())); 

/*
	() -> System.out.println(Thread.currentThread().getName())
	Lambda表达式
	
	() 参数列表
	-> 做什么事情，就是对应方法体
	箭头之后的代码就是正常语句
	
	(参数列表) -> {代码语句}
*/
注意事项
    1. 有且只有一个缺省属性为public abstract方法的接口，例如 Comparator<T>接口，Runnable接口
    2. 使用lambda表达式是有一个前后要求约束的
        方法的参数为接口类型，或者说局部变量使用调用方法，可以使用lambda也OK
    3. 有且只有一个抽象方法的接口，称之为【函数式接口】
```

