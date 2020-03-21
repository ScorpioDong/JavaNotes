# Day 28

## 1. 函数式接口

### 1.1 概述

```
	如果说一个接口只有一个方法，而且干方法是一个缺省属性为abstract方法，该接口称之为函数式接口。
	可以直接使用JDK1.8新特征，Lambda表达式来使用
	
	Lambda表达式对比匿名内部类
		1. 简化了代码结构
		2. 节约了内存资源
		3. 让程序员更加关注我要做什么，而不是为了做什么需要完成什么
```

### 1.2 @FunctionalInterface使用

```
类似于
	@Override	开启代码重写格式严格检查
```

### 1.3 使用函数式接口

```
代码中使用函数式接口
	1. 让程序的目的性更强
	2. 提供复用，普适性的价值
	3. 节约资源
```

## 2. 函数式编程思想

### 2.1 Lambda延迟执行

```
日志是否保存会存在等级限制
这里需要一个函数式接口，返回值类型是String类型，其他的无所谓。
```

```java
/**
 * 使用函数式接口完成Log日志记录问题
 *
 * @author Anonymous 2020/3/11 10:53
 */
public class Demo2 {
    public static void main(String[] args) {
        String msg1 = "异常位置XXX，";
        String msg2 = "异常问题XXX，";
        String msg3 = "异常时间XXX";

        log(Level.LOWER, () -> {
            System.out.println("Lambda表达式执行!!!");
            return msg1 + msg2 + msg3;
        });
    }

    /**
     * 根据日志等级Level来确定是否需要记录日志
     *
     * @param level Level枚举类型，有三个数据 HIGH MIDDLE LOWER
     * @param lm LogMessage函数式接口做方法的参数
     */
    public static void log(Level level, LogMessage lm) {
        /*
        发现当Level等级为HIGH，执行对应的lm.returnLogMessage();
        Level等级不是HIGH不执行对应的方法。

        Lambda执行延迟问题不是Lambda效率执行慢，而是在执行之前多了一个判断
        是在判断之后才可以执行对应的代码。
            不执行代码字符串不会产生拼接导致的资源浪费问题，从而提高效率。
         */
        if (Level.HIGH == level) {
            // 通过函数式接口获取调用对应的returnLogMessage()方法
            System.err.println(lm.returnLogMessage());
        }
    }

    public static void testEnum(int level) {
        if (Level.HIGH.getStatus() == level) {

        }
    }
}
```

### 2.2 Lambda作为方法参数和返回值

```java
/**
 * Runnable接口函数式接口使用，作为方法的参数
 *
 * @author Anonymous 2020/3/11 11:18
 */
public class Demo3 {
    public static void main(String[] args) {
        // 匿名内部类来完成对应当前Runnable接口实现类对象使用，作为Thread构造方法参数
        // low
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程代码");
            }
        }).start();

        // Lambda表达式直接作为方法的参数
        Thread thread = new Thread(() -> {

            System.out.println("线程执行需要时间");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程执行");
        }
        , "线程");

        thread.start();
    }
}
```

```
Java中提供的比较接口Comparator<T>
	利用一些返回值作为方法中操作的调节
	
public interface Comparator<T> {
	int compare(T o1, T o2);
}
```

## 3. Java中提供的常用函数式接口

### 3.1 JDK常用函数式接口概述

```
java.util.function包名 。提供了很多函数式接口
	规范了一些操作，提升了开发效率，更加专注于目的性！！！
	
	Supplier<T> 生产者, 返回一个指定类型的数据
	Consumer<T> 消费者, 消耗一个指定类型的数据
	Predicate<T> 判断调节，过滤使用
	Function<T,R> 类型转换，根据你指定的类型T, 转换成对应类型R
```

### 3.2 Supplier<T> 生产者，返回一个指定的数据类型

```
java.util.function.Supplier<T>
	有且只有一个方法
		T get();
		不需要参数，返回指定T类型数据
		什么都不吃，挤的都是输出。。。
```

```java
package com.qfedu.c_supplier;

import com.qfedu.b_lambda.Level;

import java.util.function.Supplier;

/**
 * Supplier函数式接口演示
 *
 * @author Anonymous 2020/3/11 14:44
 */
public class Demo1 {
    public static void main(String[] args) {
        String msg1 = "异常位置XXX，";
        String msg2 = "异常问题XXX，";
        String msg3 = "异常时间XXX";

        /*
        这里需要的是一个函数式接口，直接传入一个lambda表达式
         */
        log(Level.HIGH, () -> {
            System.out.println("Lambda表达式执行!!!");
            return msg1 + msg2 + msg3;
        });

        /*
        Lambda表达式优化
         */
        log(Level.HIGH, () -> msg1 + msg2 + msg3);
    }

    /**
     * 根据日志等级Level来确定是否需要记录日志
     *
     * @param level Level枚举类型，有三个数据 HIGH MIDDLE LOWER
     * @param supplier Supplier函数式接口，利用T get() 完成提供数据操作
     */
    public static void log(Level level, Supplier<String> supplier) {
        /*
        Supplier函数式接口利用get方法，提供对应的返回指定String类型数据的操作
         */
        if (Level.HIGH == level) {
            // 通过函数式接口获取调用对应的returnLogMessage()方法
            System.err.println(supplier.get());
        }
    }
}
```

###### 找出数组中最大值所在下标位置

```java
package com.qfedu.c_supplier;

import java.util.function.Supplier;

/**
 * 利用函数式接口Supplier其中get方法，找出数组中最大值下标位置
 *
 * @author Anonymous 2020/3/11 14:54
 */
public class Demo2 {
    public static void main(String[] args) {
        int[] array = {1, 3, 5, 7, 9, 2, 4, 6, 8, 10};

        /*
        getMax方法需要的参数是一个Supplier函数式接口，这里可以使用Lambda表达式完成
         */
        int max = getMax(() -> {
            int index = 0;

            for (int i = 1; i < array.length; i++) {
                if (array[index] < array[i]) {
                    index = i;
                }
            }

            return index;
        });

        System.out.println(max);
    }

    /**
     * 利用函数式接口完成一个getMax，提供一个操作思想
     *
     * @param sup Supplier函数式接口
     * @return 最大值下标位置
     */
    public static int getMax(Supplier<Integer> sup) {
        return sup.get();
    }
}
```

###### 引出满足更多普适性代码的函数式接口使用方式

```java
package com.qfedu.c_supplier;

import java.util.function.Supplier;

/**
 * 演示Supplier函数式接口使用，对于方法的拓展能力和
 * 普适性满足
 *
 * @author Anonymous 2020/3/11 15:06
 */
public class Demo3 {
    public static void main(String[] args) {
        Integer[] array = {1, 3, 5, 7, 9, 2, 4, 6, 8, 10};

        Integer max = getMax(array, () -> {
            Integer temp = array[0];

            for (int i = 1; i < array.length; i++) {
                if (temp < array[i]) {
                    temp = array[i];
                }
            }

            return temp;
        });

        System.out.println(max);

        System.out.println("-------------------------------------------");

        Person[] persons = {new Person(1, "骚磊", 16),
                new Person(2, "老黑", 66),
                new Person(3, "老付", 36),
                new Person(4, "老高", 26),
                new Person(5, "污云", 96),
                new Person(6, "帅栋", 106)
        };

        Person max1 = getMax(persons, () -> {
            Person p = persons[0];

            for (int i = 1; i < persons.length; i++) {
                if (p.getAge() < persons[i].getAge()) {
                    p = persons[i];
                }
            }

            return p;
        });

        System.out.println(max1);
    }

    /**
     * 找出任意类型数组中最大数据
     *
     * @param arr 任意类型数组，同时约束当前泛型的使用规则
     * @param sup Supplier函数式接口，要利用get方法，返回指定T类型数据
     * @param <T> 泛型
     * @return 和数组类型一致的数据
     */
    public static <T> T getMax(T[] arr, Supplier<T> sup) {
        return sup.get();
    }
}
```

### 3.3 Consumer<T>消费者，处理数据

```
Consumer<T>
	操作使用的方式是
	void accept(T t);
		根据接口指定的数据类型接收对应数据，进行处理和消费，对外没有任何的返回
		至于处理的过程，展示，处理，计算。。。
```

```java
package com.qfedu.d_consumer;

import java.util.function.Consumer;

/**
 * 使用Consumer处理数据
 *
 * @author Anonymous 2020/3/11 15:24
 */
public class Demo1 {
    public static void main(String[] args) {
        // 该方法需要的参数是一个String类型，同时使用Consumer接口处理数据
        // 因为Consumer接口是一个函数式接口，可以使用Lambda表达式
        testConsumer("宫保鸡丁,番茄牛腩,酱牛肉,黄焖鸡米饭", (str) -> {
            String[] split = str.split(",");
            for (String s : split) {
                System.out.println(s);
            }
        });
    }

    /**
     * 给予当前方法一个String类型，通过Consumer函数式接口中的accept方法完成对应
     * 字符串处理
     *
     * @param str String类型字符串
     * @param consumer Consumer处理数据的函数式接口
     */
    public static void testConsumer(String str, Consumer<String> consumer) {
        consumer.accept(str);
    }
}
```

#### andThen

```java
package com.qfedu.d_consumer;

import java.util.function.Consumer;

/**
 * Consumer接口andThen使用
 * 需要两个Consumer接口，两个Consumer接口进行组合处理，对数据进行消费
 *
 * andThen(Consumer<T> con)
 *      调用格式
 *          con1.andThen(con2).accept(T t);
 *          等价于一下操作
 *          con1.accept(t);
 *          con2.accept(t);
 *
 * @author Anonymous 2020/3/11 15:57
 */
public class Demo2 {
    public static void main(String[] args) {
        /*
        该方法需要两个Consumer函数式接口，这里可以使用两个Lambda表达式操作
         */
        testAndThen("郑州加油!!!中国加油!!!",
                (str) -> System.out.println(str)
                ,
                (str) -> System.err.println(str)
                );
    }

    /**
     * 使用两个Consumer消费者方式处理str数据，首先是con1处理，再来con2处理
     *
     * @param str  需要处理的String类型数据
     * @param con1 Consumer<String> 处理String类型函数式接口
     * @param con2 Consumer<String> 处理String类型函数式接口
     */
    public static void testAndThen(String str, Consumer<String> con1, Consumer<String> con2) {
        /*
        con1.accept(str);
        con2.accept(str);

        允许组合拳
        con1.andThen(con2).andThen(con1).andThen(con2).andThen(con1).andThen(con2).accept(str);
        */
        con1.andThen(con2).accept(str);
    }
}
```

### 3.4 Predicate<T> 判断数据是否合适，返回true/false

```
Predicate<T>一般用于调节判断，过滤数据的方法
	函数式接口中指定的方法
	boolean test(T t);
		处理T类型数据，返回boolean true / false
```

```java
package com.qfedu.e_predicate;

import java.util.function.Predicate;

/**
 * 演示Predicate<T>基本使用
 *      boolean test(T t)
 *
 * @author Anonymous 2020/3/11 16:11
 */
public class Demo1 {
    public static void main(String[] args) {

        // Predicate函数式接口，使用Lambda表达式作为方法的参数
        boolean b = testPredicate("郑州奥力给!!!中国奥力给!!!",
                (str) -> {
                    return str.contains("加油");
                });

        System.out.println("ret : " + b);

        System.out.println("---------------------------");

        /*
        优化Lambda表达式，
            因为是一个参数，小括号可以省略
            就一行代码，大括号可以省略
            return也可以省略
         */
        testPredicate("郑州奥力给!!!中国奥力给!!!", str -> str.contains("加油"));
    }

    /**
     * 使用Predicate函数式接口利用boolean test(T t)对于当前数据进行判断操作，
     * 返回boolean类型数据
     *
     * @param str 需要进行判断数据的String类型字符串
     * @param pre 处理使用Predicate函数式接口
     * @return 判断接口是否满足要求，满足返回true，不满足返回false
     */
    public static boolean testPredicate(String str, Predicate<String> pre) {
        return pre.test(str);
    }
}

```

#### and 与

```java
package com.qfedu.e_predicate;

import java.util.function.Predicate;

/**
 * Predicate and使用
 * default修饰方法add(Predicate<T> pre)
 *      and就是逻辑运算符里面的 &&
 *      同真为真，有假【即】假
 *      需要对两个Predicate进行判断处理
 *
 *      例如：
 *          pre1.test(str) && pre2.test(srt);
 *          ==> pre1.and(pre2).test(str);
 *
 * @author Anonymous 2020/3/11 16:19
 */
public class Demo2 {
    public static void main(String[] args) {

        /*
        这里需要量Predicate接口，使用Lambda
         */
        boolean ret = testAnd("赶紧复工吧，不要搞事情了！！！",
                str -> str.length() > 5,
                str -> str.startsWith("赶紧"));

        System.out.println(ret);
    }

    /**
     * 组合判断
     *
     * @param str  需要判断的字符串
     * @param pre1 判断方式1
     * @param pre2 判断方式2
     * @return 处理结果 true, false
     */
    public static boolean testAnd(String str, Predicate<String> pre1, Predicate<String> pre2) {
        // return pre1.test(str) && pre2.test(str)
        return pre1.and(pre2).test(str);
    }
}
```

#### or 或

```java
package com.qfedu.e_predicate;

import java.util.function.Predicate;

/**
 * Predicate or演示
 *
 * @author Anonymous 2020/3/11 16:32
 */
public class Demo3 {
    public static void main(String[] args) {
        boolean ret = testOr("国家之强大，国外人羡慕不得~~",
                str -> str.length() < 10,
                str -> str.contains("国家"));

        System.out.println(ret);
    }

    /**
     * or 组合判断
     *
     * @param str  需要判断的字符串
     * @param pre1 判断方式1
     * @param pre2 判断方式2
     * @return 处理结果 true, false
     */
    public static boolean testOr(String str, Predicate<String> pre1, Predicate<String> pre2) {
        // return pre1.test(str) || pre2.test(str);
        return pre1.or(pre2).test(str);
    }
}
```

#### negate 非

```java
package com.qfedu.e_predicate;

import java.util.function.Predicate;

/**
 * Predicate negate()操作
 *
 * @author Anonymous 2020/3/11 16:36
 */
public class Demo4 {
    public static void main(String[] args) {
        boolean ret = testNegate("疫情总会过去的!!!",
                str -> str.length() < 5);
        System.out.println(ret);
    }

    /**
     * negate操作
     *
     * @param str 字符串
     * @param pre Predicate函数式接口
     * @return 处理结果
     */
    public static boolean testNegate(String str, Predicate<String> pre) {
        // return !pre.test(str);
        return pre.negate().test(str);
    }
}
```

#### ArrayList中使用Predicate删除指定数据

```java
package com.qfedu.e_predicate;

import com.qfedu.c_supplier.Person;

import java.util.ArrayList;

/**
 * ArrayList，使用Predicate作为条件约束删除对应的数据
 *
 * @author Anonymous 2020/3/11 16:41
 */
public class Demo5 {
    public static void main(String[] args) {
        ArrayList<Person> list = new ArrayList<>();

        list.add(new Person(1, "骚磊", 16));
        list.add(new Person(2, "老黑", 66));
        list.add(new Person(3, "老付", 36));
        list.add(new Person(4, "老高", 26));
        list.add(new Person(5, "污云", 96));
        list.add(new Person(6, "帅栋", 96));

        // 直接安排Predicate函数式接口来约束对应的条件，进行删除操作
        // 代码的阅读性，普适性提升
        // 以及代码的冗余程度降低
        list.removeIf(person -> person.getAge() > 40 && person.getId() > 3);

        System.out.println(list);
    }
}
```

### 3.5 Function<T,R> 类型转换

```
使用R apply(T t)
	转换指定类型T到R
```

```java
package com.qfedu.f_function;

import com.qfedu.c_supplier.Person;

import java.util.function.Function;

/**
 * Function<T, R> 函数式接口
 *      R apply(T)
 *
 * @author Anonymous 2020/3/11 16:50
 */
public class Demo1 {
    public static void main(String[] args) {
        // Integer类型转换成一个String
        String change = change(10, i -> i + "");
        System.out.println(change);

        // 利用函数式接口处理一个String类型，转换成对应的Person类型
        Person person1 = change("1,骚磊,16", str -> {
            String[] split = str.split(",");
            Person person = new Person();

            person.setId(Integer.parseInt(split[0]));
            person.setName(split[1]);
            person.setAge(Integer.parseInt(split[2]));

            return person;
        });

        System.out.println(person1);
    }

    /**
     * 转换格式的方法，要求数据从Integer类型转换到指定的String类型
     *
     * @param i 需要转换的Integer类型
     * @param fun 转换使用的Function函数式接口
     * @return 返回值的是String类型
     */
    public static String change(Integer i, Function<Integer, String> fun) {
        return fun.apply(i);
    }

    public static Person change(String str, Function<String, Person> fun) {
        return fun.apply(str);
    }
}
```

#### andThen 

```java
package com.qfedu.f_function;

import java.util.function.Function;

/**
 * Function<T, R>
 *     default修饰andThen方法使用
 *
 * @author Anonymous 2020/3/11 17:01
 */
public class Demo2 {
    public static void main(String[] args) {
        String s = testAndThen(10,
                i -> i + "",
                i -> i + "测试");

        System.out.println(s);
    }

    /**
     * 两次转换过程
     *
     * @param i 需要处理的类型
     * @param fun1 Function函数接口
     * @param fun2 Function函数接口
     * @return String类型
     */
    public static String testAndThen(int i, Function<Integer, String> fun1, Function<String, String> fun2) {

        // andThen使用，最后apply方法参数类型是fun1要求的转换参数类型
        return fun1.andThen(fun2).apply(i);
    }
}
```

#### 