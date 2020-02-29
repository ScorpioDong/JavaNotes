package cn.scorpiodong.student.util;

import java.util.NoSuchElementException;

/**
 * 学生管理系统 - 自定义LinkedList集合
 *
 * @author ScorpioDong
 */
public class MyLinkedList<E> {
    /**
     * 指向链表头
     */
    private Node<E> first;

    /**
     * 指向链表尾
     */
    private Node<E> last;

    /**
     * 有效元素个数
     */
    private int size = 0;

    /**
     * 成员内部类，链表节点
     *
     * @param <E> 泛型类型限定
     */
    private static class Node<E> {
        /**
         * 节点元素
         */
        E item;
        /**
         * 指向上一个节点
         */
        Node<E> prev;
        /**
         * 指向下一个节点
         */
        Node<E> next;

        /**
         * 有参构造方法
         *
         * @param item 节点元素
         * @param prev 指向上一个节点
         * @param next 指向下一个节点
         */
        public Node(E item, Node<E> prev, Node<E> next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }

    }

    /**
     * 无参数构造函数
     */
    public MyLinkedList() {
    }

    /*
        add(E e);
        addFirst(E e);
        addLast(E e);
        E getFirst();
        E getLast():
        E get(int index);
        removeFirst();
        removeLast();
        remove(int index);
        remove(Object obj);
        E set(int index, E);
        size();
    */

    /**
     * 添加一个元素，尾插法
     *
     * @param e 元素
     * @return 成功返回true
     */
    public boolean add(E e) {
        Node<E> l = last;

        Node<E> n = new Node<>(e, l, null);

        last = n;

        // 如果链表为空
        if (null == first) {
            first = n;
        } else {
            l.next = n;
        }

        size++;

        return true;
    }

    /**
     * 添加一个元素到链表末尾
     *
     * @param e 元素
     * @return 成功返回true
     */
    public boolean addLast(E e) {
        return add(e);
    }

    /**
     * 添加一个元素到链表头
     *
     * @param e 元素
     * @return 成功返回true
     */
    public boolean addFirst(E e) {
        Node<E> f = first;

        Node<E> n = new Node<>(e, null, f);

        first = n;

        if (null == first) {
            last = n;
        } else {
            f.prev = n;
        }

        size++;

        return true;
    }

    /**
     * 获取头节点元素
     *
     * @return 返回头节点的元素
     */
    public E getFirst() {
        Node<E> f = first;

        if (null == f) {
            throw new NoSuchElementException();
        }

        return first.item;
    }

    /**
     * 获取尾结点的元素
     *
     * @return 返回尾节点的元素
     */
    public E getLast() {
        Node<E> l = last;

        if (null == l) {
            throw new NoSuchElementException();
        }

        return last.item;
    }

    /**
     * 获取指定位置的节点元素
     *
     * @param index 节点位置
     * @return 返回指定节点的元素
     */
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(index);
        }

        if (index < (size >> 1)) {
            Node<E> n = first;
            for (int i = 0; i < index; i++) {
                n = n.next;
            }

            return n.item;
        } else {
            Node<E> n = last;
            for (int i = size - 1; i > index; i--) {
                n = n.prev;
            }

            return n.item;
        }
    }

    /**
     * 删除头节点
     *
     * @return 返回被删除的节点元素
     */
    public E removeFirst() {
        return remove(0);
    }

    /**
     * 删除尾节点
     *
     * @return 返回被删除的节点元素
     */
    public E removeLast() {
        return remove(size - 1);
    }

    /**
     * 删除指定位置节点
     *
     * @param index int 下标位置
     * @return 返回被删除的节点元素
     */
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(index);
        }

        Node<E> n;
        if (index < (size >> 1)) {
            Node<E> f = first;
            for (int i = 0; i < index; i++) {
                f = f.next;
            }
            n = f;
        } else {
            Node<E> l = last;
            for (int i = size - 1; i > index; i--) {
                l = l.prev;
            }
            n = l;
        }

        Node<E> prev = n.prev;
        Node<E> next = n.next;
        n.next = null;
        n.prev = null;

        if (null == prev) {
            next.prev = null;
            first = next;
        } else if (null == next) {
            prev.next = null;
            last = prev;
        } else {
            next.prev = prev;
            prev.next = next;
        }

        E e = n.item;
        n.item = null;

        size--;

        return e;

    }

    /**
     * 删除指定元素节点
     *
     * @param obj Object元素
     * @return 成功返回true
     */
    public boolean remove(Object obj) {
        int index = indexOf(obj);

        if (index == -1) {
            return false;
        }

        remove(index);
        return true;
    }

    /**
     * 设置指定位置节点的元素
     *
     * @param index int 位置
     * @param e     e 要替换的元素
     * @return 返回被替换的元素
     */
    public E set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(index);
        }

        if (index < (size >> 1)) {
            Node<E> n = first;
            for (int i = 0; i < index; i++) {
                n = n.next;
            }
            E temp = n.item;
            n.item = e;
            return temp;
        } else {
            Node<E> n = last;
            for (int i = size - 1; i > index; i--) {
                n = n.prev;
            }

            E temp = n.item;
            n.item = e;
            return temp;
        }
    }

    /**
     * 获取有效元素个数
     *
     * @return 返回有效元素个数
     */
    public int size() {
        return size;
    }

    /**
     * 获取元素在链表中的下标
     *
     * @param obj 元素
     * @return 返回下标
     */
    public int indexOf(Object obj) {
        Node<E> f = first;

        for (int i = 0; i < size; i++) {
            if (f.item.equals(obj)) {
                return i;
            }
            f = f.next;
        }

        return -1;
    }

    /**
     * 获取元素最后一次在链表中的下标
     *
     * @param obj 元素
     * @return 返回下标
     */
    public int lastIndexOf(Object obj) {
        Node<E> l = last;

        for (int i = size - 1; i >= 0; i--) {
            if (l.item.equals(obj)) {
                return i;
            }
            l = l.prev;
        }

        return -1;
    }

    /**
     * 指定位置添加节点
     *
     * @param index int 位置
     * @param e E 元素
     * @return 成功返回true
     */
    public boolean add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(index);
        }

        Node<E> n = first;

        for (int i = 0; i < index; i++) {
            n = n.next;
        }

        Node<E> next = n.next;

        Node<E> temp = new Node<>(e, n, next);

        n.next = temp;
        next.prev = temp;

        size++;

        return true;

    }

    /**
     * 添加集合到末尾
     *
     * @param list 集合
     * @return 成功返回true
     */
    public boolean addAll(MyLinkedList<E> list) {
        return addAll(size, list);
    }

    /**
     * 指定位置添加集合
     *
     * @param index int 位置
     * @param list 集合
     * @return 成功返回true
     */
    public boolean addAll(int index, MyLinkedList<E> list) {
        if (null == list) {
            throw new NullPointerException();
        }
        if (list.isEmpty()) {
            return false;
        }

        Object[] objs = list.toArray();
        int newSize = objs.length;

        if (index == 0) {
            for (int i = newSize - 1; i >= 0; i--) {
                addFirst((E) objs[i]);
            }
        }

        for (int i = 0; i < newSize; i++) {
            add(index + i, (E) objs[i]);
        }

        return true;
    }

    /**
     * 判断元素是否在集合中
     *
     * @param obj 元素
     * @return 在集合中返回true
     */
    public boolean contains(Object obj) {
        if (null == obj) {
            return false;
        }

        return indexOf(obj) > -1;
    }

    /**
     * 判断集合是否是此集合的子集合
     *
     * @param list 集合
     * @return 是子集合返回true
     */
    public boolean containsAll(MyLinkedList<?> list) {
        if (null == list) {
            throw new NullPointerException();
        }
        if (list.isEmpty()) {
            return false;
        }

        Object[] objs = list.toArray();
        int newSize = objs.length;

        Node<E> n = first;

        for (int i = 0; i < size; i++) {
            if (n.item.equals(objs[0])) {
                if (size - i < newSize) {
                    return false;
                }

                boolean flag = true;
                Node<E> temp = n.next;
                for (int j = 1; j < newSize; j++) {
                    if (!temp.item.equals(objs[i])) {
                        flag = false;
                        break;
                    }
                    temp = temp.next;
                }

                if (flag) {
                    return true;
                }
            }
            n = n.next;
        }

        return false;
    }

    /**
     * 集合转为数组
     *
     * @return Object类型数组
     */
    public Object[] toArray() {
        Object[] obj = new Object[size];
        Node<E> n = first;
        for (int i = 0; i < size; i++) {
            obj[i] = n.item;
            n = n.next;
        }

        return obj;
    }

    /**
     * 判断集合是否为空
     *
     * @return 为空返回true
     */
    public boolean isEmpty() {
        return 0 == size;
    }

    @Override
    public String toString() {
        Node<E> f = first;
        String str = "[";
        for (int i = 0; i < size - 1; i++) {
            str += f.item + ", ";
            f = f.next;
        }

        return str + f.item + "]";
    }
}
