package cn.scorpiodong.server.dao;

import cn.scorpiodong.server.model.Student;

import java.util.HashMap;

/**
 * StudentSystemC - StudentDao
 * 数据持久化操作
 *
 * @author ScorpioDong
 * @version 1.0
 * @date 2020/3/17 7:52 下午
 */
public class StudentDao {

    private HashMap<Integer, Student> allStudents;
    private static StudentDao instance;

    /**
     * id计数器
     */
    private int count = 0;

    public StudentDao() {
        this.allStudents = new HashMap<>();
    }

    public void add(Student student) {
        student.setId(count);
        allStudents.put(count++, student);
    }

    public Student remove(Integer id) {
        return allStudents.remove(id);
    }

    public Student modify(Integer id, Student student) {
        if (id > -1 ) {
            student.setId(id);
            return allStudents.put(id, student);
        }
        return null;
    }

    public Student get(Integer id) {
        return allStudents.get(id);
    }

    public void Sort(Comparable<Student> comparable) {
        ;
    }

    public void show() {
        for (Student value : allStudents.values()) {
            System.out.println(value.toString());
        }
    }

    public static synchronized StudentDao getInstance() {
        if (instance == null) {
            instance = new StudentDao();
        }
        return instance;
    }

    public HashMap<Integer, Student> getAllStudents() {
        return allStudents;
    }

    public void setAllStudents(HashMap<Integer, Student> allStudents) {
        this.allStudents = allStudents;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
