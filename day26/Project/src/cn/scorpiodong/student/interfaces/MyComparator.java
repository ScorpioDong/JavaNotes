package cn.scorpiodong.student.interfaces;

import cn.scorpiodong.student.entity.Student;

/**
 * 学生管理接口 - 比较接口
 *
 * @author ScorpioDong
 */
public interface MyComparator {
    /**
     * 比较两Student对象的属性
     *
     * @param stu1 Student类对象
     * @param stu2 Student类对象
     * @return boolean 返回比较结果
     */
    boolean compare(Student stu1, Student stu2);
}
