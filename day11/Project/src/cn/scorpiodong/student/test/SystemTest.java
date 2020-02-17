package cn.scorpiodong.student.test;

import cn.scorpiodong.student.entity.Student;
import cn.scorpiodong.student.manage.StudentManage;
import org.junit.jupiter.api.Test;

/**
 * 学生管理系统 - 测试类
 *
 * @author ScorpioDong
 */
public class SystemTest {

    @Test
    public void testStudent() {
        Student student1 = new Student();
        Student student2 = new Student();
        Student student3 = new Student();
        Student student4 = new Student();
        Student student5 = new Student();
        Student student6 = new Student("骚磊", 16, '男', 99, 95, 97);

        System.out.println(student1);
        System.out.println(student2);
        System.out.println(student3);
        System.out.println(student4);
        System.out.println(student5);
        System.out.println(student6);
    }

    @Test
    public void testAdd() {
        Student student1 = new Student();
        Student student2 = new Student();
        Student student3 = new Student();
        Student student4 = new Student();
        Student student5 = new Student();
        Student student6 = new Student("骚磊", 16, '男', 99, 95, 97);

        StudentManage manage = new StudentManage();

        manage.add(student1);
        manage.add(student2);
        manage.add(student3);
        manage.add(student4);
        manage.add(student5);
        manage.add(new Student("骚磊", 16, '男', 99, 95, 97));
        manage.add(new Student("骚磊", 16, '男', 99, 95, 97));
        manage.add(new Student("骚磊", 16, '男', 99, 95, 97));
        manage.add(new Student("骚磊", 16, '男', 99, 95, 97));
        manage.add(new Student("骚磊", 16, '男', 99, 95, 97));
        manage.add(new Student("骚磊", 16, '男', 99, 95, 97));
        manage.add(new Student("骚磊", 16, '男', 99, 95, 97));
        manage.add(new Student("骚磊", 16, '男', 99, 95, 97));
        manage.add(new Student("骚磊", 16, '男', 99, 95, 97));
        manage.add(new Student("骚磊", 16, '男', 99, 95, 97));
        manage.add(new Student("骚磊", 16, '男', 99, 95, 97));
        manage.add(new Student("骚磊", 16, '男', 99, 95, 97));
        manage.add(new Student("骚磊", 16, '男', 99, 95, 97));
        manage.add(new Student("骚磊", 16, '男', 99, 95, 97));
        manage.add(new Student("骚磊", 16, '男', 99, 95, 97));
        manage.add(new Student("骚磊", 16, '男', 99, 95, 97));
        manage.add(new Student("骚磊", 16, '男', 99, 95, 97));
        manage.add(new Student("骚磊", 16, '男', 99, 95, 97));
        manage.add(new Student("骚磊", 16, '男', 99, 95, 97));
        manage.add(new Student("骚磊", 16, '男', 99, 95, 97));
        manage.add(new Student("骚磊", 16, '男', 99, 95, 97));
        manage.add(new Student("骚磊", 16, '男', 99, 95, 97));


        manage.show();
    }

    @Test
    public void testDelete() {
        Student student1 = new Student();
        Student student2 = new Student();
        Student student3 = new Student();
        Student student4 = new Student();
        Student student5 = new Student();
        Student student6 = new Student("骚磊", 16, '男', 99, 95, 97);

        StudentManage manage = new StudentManage();

        manage.add(student1);
        manage.add(student2);
        manage.add(student3);
        manage.add(student4);
        manage.add(student5);
        manage.add(new Student("骚磊", 16, '男', 99, 95, 97));
        manage.add(new Student("骚磊", 16, '男', 99, 95, 97));
        manage.add(new Student("骚磊", 16, '男', 99, 95, 97));
        manage.add(new Student("骚磊", 16, '男', 99, 95, 97));
        manage.add(new Student("骚磊", 16, '男', 99, 95, 97));
        manage.add(new Student("骚磊", 16, '男', 99, 95, 97));
        manage.add(new Student("骚磊", 16, '男', 99, 95, 97));
        manage.add(new Student("骚磊", 16, '男', 99, 95, 97));
        manage.add(new Student("骚磊", 16, '男', 99, 95, 97));
        manage.add(new Student("骚磊", 16, '男', 99, 95, 97));
        manage.add(new Student("骚磊", 16, '男', 99, 95, 97));
        manage.add(new Student("骚磊", 16, '男', 99, 95, 97));
        manage.add(new Student("骚磊", 16, '男', 99, 95, 97));
        manage.add(new Student("骚磊", 16, '男', 99, 95, 97));
        manage.add(new Student("骚磊", 16, '男', 99, 95, 97));
        manage.add(new Student("骚磊", 16, '男', 99, 95, 97));
        manage.add(new Student("骚磊", 16, '男', 99, 95, 97));
        manage.add(new Student("骚磊", 16, '男', 99, 95, 97));
        manage.add(new Student("骚磊", 16, '男', 99, 95, 97));
        manage.add(new Student("骚磊", 16, '男', 99, 95, 97));
        manage.add(new Student("骚磊", 16, '男', 99, 95, 97));
        manage.add(new Student("骚磊", 16, '男', 99, 95, 97));

        manage.delete(20);

        manage.delete(40);

        manage.show();
    }
}
