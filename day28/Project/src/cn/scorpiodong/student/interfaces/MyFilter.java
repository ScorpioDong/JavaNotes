package cn.scorpiodong.student.interfaces;

import cn.scorpiodong.student.entity.Student;

/**
 *  学生管理系统 - 过滤器接口
 *
 * @author ScorpioDong
 */
public interface MyFilter {
    /**
     * 判断学生属性是否符合条件
     * @param stu Student类对象
     * @return 在范围内返回true，否则返回false
     */
    boolean condition(Student stu);
}
