# Day 14

## 1. 集合

### 1.1 迭代器

```
通过集合对象获取对应的Iterator<E>迭代器
	Iterator<E> iterator();
常用方法
	boolean hasNext();
		判断Iterator是否可以继续运行
	E next();
		获取Iterator当前指向元素，并且指向下一个元素
    void remove();
    	删除
    		1. 只能删除通过next方法获取的元素
    		2. 必须紧挨着next方法
```

### 2.2 Iterator使用注意事项

```java
/*
 * ConcurrentModificationException
 * Iterator在创建的过程中，会对整个集合所有元素打招呼，记录每一个元素位置。
 * Iterator在执行next方法过程中，会按照初始条件一个一个遍历
 * 当前集合通过remove方法，删除已经被Iterator记录的元素时，是有可能导致
 * Iterator一脸懵逼！！！元素不见了！！！
 * 
 * 这里就会发生冲突！
 * 
 * 这里因为集合中元素，对于集合本身和当前Iterator而言是一个共享资源
 * 不管是哪一方操作元素，都存在影响对方操作的情况。【共享资源冲突问题】
 * 
 * ArrayList存储元素不是连续的吗，土豆牛肉删除了，他的位置不是会被后面的元素顶上来吗

 */
```

## 2. List<E>

### 2.1 List<E>集合接口特征和方法

```
特征
	有序，可重复
	有序：添加顺序和存储顺序一致
	可重复：相同元素可以同时添加
	List<E>
		ArrayList<E> 底层数组形式操作，可以通过下标直接访问
		LinkedList<E> 底层是一个双向链表结构，下标 ==> 计数器

特定的方法：
	增:
		add(E e);
			List接口下，当前方法是添加元素到集合的末尾，尾插法
		addAll(Collection<? extends E> c);
			List接口下，当前方法是添加另一个集合到当前集合末尾，要求添加的集合中保存的元素和当前集合保存元素一致，或者说是当前集合保存元素的子类
		add(int index, E e);
			在指定的下标位置，添加指定元素
		addAll(int index, Collection<? extends E> c);
			在指定的下标位置，添加指定的集合，集合要求同上一个addAll方法
	删:
		void clear();
			清空整个集合
		remove(Object obj);
			删除集合中的指定元素
		removeAll(Colletion<?> c);
			删除两个集合的交集
		retainAll(Colletion<?> c);
			保留两个集合的交集
		
		E remove(int index);
			删除集合中指定下标的元素。返回值是被删除的元素
	改:
		E set(int index, E e);
			使用指定元素替换指定下标index的元素，返回值是被替换掉的元素。
	查:
		int size();
			有效元素个数
		boolean isEmpty();
			判断当前集合是否为空
		boolean contains(Object obj);
		boolean containsAll(Collection<?> c);
		
		int indexOf(Object obj);
			找出指定元素在集合中的第一次出现位置
		int lastIndexOf(Object obj);
			找出指定元素在集合中最后一次出现位置
		E get(int index);
			获取指定下标的元素
		List<E> subList(int fromIndex, int endIndex);
			获取当前集合的子集合
			【特征】
				获取数据的范围是 fromIndex <= n < endIndex
				要头不要尾
```

### 2.2 ArrayList可变长数组

```
特征
	数组形式的操作方式，查询效率高，删除、增加效率低
	数组
		Object类型数组
方法:
	ArrayList使用的方法基本上都是从List接口中遵从实现的方法。
	特征:
		ensureCapacity(int minCapacity);
			判断当前容量是否足够
		trimToSize();
			截断整个数组容量 ==> size有效元素个数
			时间换空间，空间换时间
```

```
自定义实现的ArrayList	
	Constructor构造方法
	
	add(E e);
	add(int index, E e);
	addAll(自定义ArrayList<E> e)
	addAll(int index,自定义ArrayList<E> e)	
	remove(Object obj);
	remove(int index);
	set(int index, E);
	E get(int index);
	int indexOf();
	int lastIndexOf();
	boolean contains(Object obj);
	boolean containsAll(自定义ArrayList类型 list)
	boolean isEmpty();
    int size();
    自定义ArrayList subList(int fromIndex, int endIndex);
    Object[] toArray();
```

