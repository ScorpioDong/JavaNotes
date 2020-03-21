package cn.scorpiodong.student.util;

import java.io.Serializable;
import java.util.Arrays;

/**
 * 学生管理系统 - 自定义ArrayList集合
 *
 * @author ScorpioDong
 */
public class MyArrayList<E> implements Serializable {
    /**
     * 底层元素存储数组
     */
    private Object[] elements;

    /**
     * 默认数组容量
     */
    private static final int DEFAULT_CAPACITY = 10;

    /**
     * 最大数组容量
     */
    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

    /**
     * 数组有效元素计数器
     */
    private int size = 0;

    /**
     * 无参构造函数，默认存储容量初始化数组
     */
    public MyArrayList() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * 有参数构造函数，使用指定容量初始化数组
     *
     * @param initCapacity int 初始化容量
     */
    public MyArrayList(int initCapacity) {
        if (initCapacity < 0 || initCapacity > MAX_ARRAY_SIZE) {
            throw new IllegalArgumentException("initCapacity:" + initCapacity);
        }

        elements = new Object[initCapacity];
    }

    /**
     * 添加元素，尾插法
     *
     * @param e E 要添加的元素
     * @return 添加成功返回true，否则false
     */
    public boolean add(E e) {
        return add(size, e);
    }

    /**
     * 像数组指定位置添加数组
     *
     * @param index int 要添加的位置
     * @param e     E 要添加的元素
     * @return 添加成功返回true，否则false
     */
    public boolean add(int index, E e) {
        if (index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException(index);
        }

        ensureCapacity(size + 1);

        for (int i = size; i > index; i--) {
            elements[i] = elements[i - 1];
        }

        elements[index] = e;
        size++;

        return true;
    }

    /**
     * 向集合中添加另一集合，尾插法
     *
     * @param c MyArrayList<E> 集合
     * @return 添加成功返回true
     */
    public boolean addAll(MyArrayList<E> c) {
        return addAll(size, c);
    }

    /**
     * 向集合指定位置添加另一集合
     *
     * @param index int 下标
     * @param c     MyArrayList<E> 集合
     * @return 添加成功返回true
     */
    public boolean addAll(int index, MyArrayList<E> c) {
        if (index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException(index);
        }

        Object[] temp = c.toArray();
        int newSize = temp.length;

        ensureCapacity(size + newSize);

        for (int i = size + newSize; i >= newSize + index; i--) {
            elements[i] = elements[i - newSize];
        }

        for (int i = 0; i < newSize; i++) {
            elements[i + index] = temp[i];
        }

        size += newSize;

        return true;
    }

    /**
     * 删除指定元素
     *
     * @param obj 指定删除的元素
     * @return 删除成功返回true
     */
    public boolean remove(Object obj) {
        int index = indexOf(obj);

        return obj.equals(remove(index));
    }

    /**
     * 删除下标元素
     *
     * @param index 指定的下标范围
     * @return 删除成功返回对应元素，失败返回null
     */
    public E remove(int index) {
        if (index < -1 || index > size) {
            throw new IllegalArgumentException("index:" + index);
        }

        if (-1 == index) {
            return null;
        }

        E e = get(index);

        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }

        elements[--size] = null;

        return e;
    }

    /**
     * 替换指定下标的元素
     *
     * @param index 指定下标元素，但是必须在有效范围以内
     * @param e     符合泛型约束的对应数据类型
     * @return 被替换的元素
     */
    public E set(int index, E e) {
        if (index < -1 || index >= size) {
            throw new IllegalArgumentException("index:" + index);
        }

        E temp = get(index);

        elements[index] = e;

        return temp;
    }

    /**
     * 判断集合是否为空
     *
     * @return boolean
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 获取集合有效元素
     *
     * @return boolean
     */
    public int size() {
        return size;
    }

    /**
     * 返回指定下标对应的元素
     *
     * @param index int 下标
     * @return E
     */
    public E get(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("index:" + index);
        }

        return (E) elements[index];
    }

    /**
     * 判断指定元素是否存在
     *
     * @param obj 指定元素
     * @return 存在返回true，不存在返回false
     */
    public boolean contains(Object obj) {
        return indexOf(obj) > -1;
    }

    /**
     * 判断指定集合是不是集合的子集
     *
     * @param list 集合
     * @return 是子集返回true，否则返回false
     */
    public boolean containsAll(MyArrayList<E> list) {
        // 判断list是否有内容 以及当前list对应的地址是不是null
        if (null == list) {
            throw new NullPointerException();
        }

        // 空集合返回false
        if (list.isEmpty()) {
            return false;
        }

        // 集合转为数组
        Object[] temp = list.toArray();
        // 获取数组长度
        int tempSize = temp.length;

        // 遍历整个数组
        for (int i = 0; i < size; i++) {

            if (temp[0].equals(elements[i])) {
                /*
                    {1, 2, 8, 3, 4, 5}
                    {4, 5, 7, 9}
                    elements数组剩余的长度如果小于temp数组长度
                    一定不是其子集
                 */
                if (size - i < tempSize) {
                    return false;
                }

                // 判断剩余元素是否一致
                boolean flag = true;
                for (int j = 1; j < tempSize; j++) {
                    if(!temp[j].equals(elements[i + j])) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 获取当前集合的子集合，截取范围是fromIndex <= n < endIndex
     *
     * @param fromIndex fromIndex <= endIndex 不得小于0
     * @param endIndex  endIndex >= fromIndex 小于等于size
     * @return 截取得到的一个MyArrayList子集合对象
     */
    public MyArrayList<E> subList(int fromIndex, int endIndex) {

        if (fromIndex > endIndex || fromIndex < 0 || endIndex > size) {
            throw new IllegalArgumentException();
        }

        MyArrayList<E> temp = new MyArrayList<>(endIndex - fromIndex);

        for (int i = fromIndex; i < endIndex; i++) {
            temp.add(get(i));
        }

        return temp;
    }

    /**
     * 返回指定元素在集合中的位置
     *
     * @param obj Object
     * @return 元素在集合中的位置
     */
    public int indexOf(Object obj) {
        for (int i = 0; i < size; i++) {
            if (obj.equals(elements[i])) {
                return i;
            }
        }

        return -1;
    }

    /**
     * 返回指定元素在集合中的最后一个位置
     *
     * @param obj Object
     * @return int 元素在集合中的最后一个位置
     */
    public int lastIndexOf(Object obj) {
        for (int i = size - 1; i >= 0; i--) {
            if (obj.equals(elements[i])) {
                return i;
            }
        }

        return -1;
    }

    /**
     * 将集合转为数组
     *
     * @return 返回Object数组
     */
    public Object[] toArray() {
        return Arrays.copyOf(elements, size);
    }

    @Override
    public String toString() {
        String str = "[";
        for (int i = 0; i < size - 1; i++) {
            str += elements[i] + ", ";
        }

        return str + elements[size - 1] + "]";
    }

    /**
     * 判断是否需要扩容
     *
     * @param minCapacity 最小容量
     */
    private void ensureCapacity(int minCapacity) {
        if (minCapacity > elements.length) {
            grow(minCapacity);
        }
    }

    /**
     * 数组扩容
     *
     * @param minCapacity 最小容量
     */
    private void grow(int minCapacity) {
        int oldSize = elements.length;
        int newSize = oldSize + (oldSize >> 1);

        if (newSize < minCapacity) {
            newSize = minCapacity;
        }

        if (newSize > MAX_ARRAY_SIZE) {
            if (minCapacity < MAX_ARRAY_SIZE) {
                newSize = minCapacity;
            } else {
                throw new OutOfMemoryError("Overflow MAX_ARRAY_SIZE");
            }
        }

        Object[] temp = new Object[newSize];

        System.arraycopy(elements, 0, temp, 0, size);

        elements = temp;
    }
}
