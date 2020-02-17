package cn.scorpiodong.student.manage;

import cn.scorpiodong.student.entity.Student;

/**
 * 学生管理系统 - 学生管理类
 *
 * @author ScorpioDong
 */
public class StudentManage {
    /**
     * 学生类数组，存储Student类对象
     */
    private Student[] allStu;

    /**
     * 学生数组最大容量
     */
    private static final int MAX_ARRAY_CAPACITY = Integer.MAX_VALUE - 8;

    /**
     * 学生数组默认容量
     */
    private static final int DEFAULT_CAPACITY = 10;

    /**
     * 数组有效元素计数器
     */
    private int size = 0;

    /**
     * 使用默认容量初始化学生数组
     */
    public StudentManage() {
        allStu = new Student[DEFAULT_CAPACITY];
    }

    /**
     * 通过初始化容量初始化学生数组
     * @param initCapacity int 初始化容量
     */
    public StudentManage(int initCapacity) {
        if (initCapacity <= 0 || initCapacity > MAX_ARRAY_CAPACITY) {
            System.out.println("请给出合理的初始化容量");
            allStu = new Student[DEFAULT_CAPACITY];
        } else {
            allStu = new Student[initCapacity];
        }
    }

    /**
     *  向学生数组添加数据
     *
     * @param student Student类型对象
     * @return boolean类型
     */
    public boolean add(Student student) {

        if (size == allStu.length) {
            growCapacity(size + 1);
        }

        allStu[size++] = student;
        return true;
    }

    /**
     * 从学生数组中删除指定id的学生对象
     *
     * @param id int类型，学生id
     * @return boolean 删除成功返回true，其他返回false
     */
    public boolean delete(int id) {
        for (int i = 0; i < size; i++) {
            if (allStu[i].getId() == id) {
                for (int j = i; j < size - 1; j++) {
                    allStu[j] = allStu[j + 1];
                }
                allStu[--size] = null;
                return true;
            }
        }
        System.out.println("未找到该id学生");
        return false;
    }

    /**
     *  学生数组扩容
     *  默认扩容到其原大小的1.5倍，可以使用参数minCapacity进行限定
     * @param minCapacity int类型，扩容后最小大小
     */
    private void growCapacity(int minCapacity) {
        int oldSize = allStu.length;
        int newSize = oldSize + (oldSize / 2);

        if (newSize < minCapacity) {
            newSize = minCapacity;
        }

        Student[] temp = new Student[newSize];

        for (int i = 0; i < size; i++) {
            temp[i] = allStu[i];
        }

        allStu = temp;
    }

    /**
     * 显示学生数组所有学生的信息
     */
    public void show() {
        for (int i = 0; i < size; i++) {
            System.out.println(allStu[i].toString());
        }
    }
}
