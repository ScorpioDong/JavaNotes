package cn.scorpiodong.controller;

import cn.scorpiodong.model.Student;

import java.util.ArrayList;

/**
 * StudentManage - Manage
 * 学生管理系统 - 管理类
 *
 * @author ScorpioDong
 * @version 1.0
 * @date 2020/3/14 9:43 AM
 */
public class Manage {

    // Fields

    private static final Manage INSTANCE = new Manage();

    /**
     * 存储Student类对象
     */
    private ArrayList<Student> elements;

    // Constructors

    private Manage() {
        elements = new ArrayList<>();
    }

    // Methods

    /**
     * 向管理器添加学生
     *
     * @param stu 要添加的Student类对象
     * @return boolean 添加成功返回true，否则返回false
     */
    public boolean add(Student stu) {
        return elements.add(stu);
    }

    /**
     * 通过学生id删除学生对象
     *
     * @param id int 学生id
     * @return Student 被删除的学生对象
     */
    public Student remove(int id) {
        return elements.remove(getIndexById(id));
    }

    /**
     * 删除学生对象
     *
     * @param stu Student 被删除的学生对象
     * @return boolean 成功返回true，否则返回false
     */
    public boolean remove(Student stu) {
        return elements.remove(stu);
    }

    /**
     * 通过id获取学生对象
     *
     * @param id int 学生id
     * @return Student 返回学生对象
     */
    public Student get(int id) {
        return elements.get(getIndexById(id));
    }

    /**
     * 获取Student对象个数
     *
     * @return int 管理器中存储的Student的个数
     */
    public int size() {
        return elements.size();
    }

    /**
     * 展示学生数据
     */
    public void show() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (Student student : elements) {
            str.append(student.toString()).append("\n");
        }
        return str.toString();
    }

    /**
     * 通过id获取Student对象在管理器中的下标
     *
     * @param id int 学生id
     * @return int Student对象的下标
     */
    private int getIndexById(int id) {
        if (id < 0 || id >= elements.size()) {
            throw new IllegalArgumentException(String.valueOf(id));
        }
        for (int i = 0; i < elements.size(); i++) {
            if (id == elements.get(i).getId()) {
                return i;
            }
        }
        return -1;
    }

    // Getter and Setter

    public ArrayList<Student> getElements() {
        return elements;
    }

    public void setElements(ArrayList<Student> elements) {
        this.elements = elements;
    }

    public static Manage getInstance() {
        return INSTANCE;
    }
}
