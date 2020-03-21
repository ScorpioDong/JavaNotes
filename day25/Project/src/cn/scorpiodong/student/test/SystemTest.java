package cn.scorpiodong.student.test;

import cn.scorpiodong.student.util.DataUtil;
import cn.scorpiodong.student.util.MyArrayList;
import cn.scorpiodong.student.interfaces.MyComparator;
import cn.scorpiodong.student.entity.Student;
import cn.scorpiodong.student.interfaces.MyFilter;
import cn.scorpiodong.student.manage.StudentManage;
import cn.scorpiodong.student.util.MyLinkedList;
import org.dom4j.DocumentException;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.LinkedList;

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



        manage.add(1, new Student("骚磊", 16, '男', 100, 100, 100));



        manage.show();
    }

    @Test
    public void testRemove() {
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


        manage.remove(20);
        manage.remove(40);



        manage.show();
    }

    @Test
    public void testModify() {
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



        manage.modify(2);


        manage.show();
    }

    @Test
    public void testSort() {

        StudentManage manage = new StudentManage();

        manage.add(new Student("骚磊", 16, '男', 99, 95, 97));
        manage.add(new Student("骚磊", 17, '男', 99, 95, 97));
        manage.add(new Student("骚磊", 18, '男', 99, 95, 97));
        manage.add(new Student("骚磊", 14, '男', 99, 95, 97));
        manage.add(new Student("骚磊", 19, '男', 99, 95, 97));
        manage.add(new Student("骚磊", 66, '男', 99, 95, 97));
        manage.add(new Student("骚磊", 12, '男', 99, 95, 97));
        manage.add(new Student("骚磊", 88, '男', 99, 95, 97));
        manage.add(new Student("骚磊", 14, '男', 99, 95, 97));
        manage.add(new Student("骚磊", 77, '男', 99, 95, 97));

        manage.selectSortUsingComparator(new MyComparator() {
            @Override
            public boolean compare(Student stu1, Student stu2) {
                return stu1.getAge() > stu2.getAge();
            }
        });
    }

    @Test
    public void testSave() {

        StudentManage manage = new StudentManage();

        manage.add(new Student("骚磊", 16, '男', 99, 95, 97));
        manage.add(new Student("骚磊", 17, '男', 99, 95, 97));
        manage.add(new Student("骚磊", 18, '男', 99, 95, 97));
        manage.add(new Student("骚磊", 14, '男', 99, 95, 97));
        manage.add(new Student("骚磊", 19, '男', 99, 95, 97));
        manage.add(new Student("骚磊", 66, '男', 99, 95, 97));
        manage.add(new Student("骚磊", 12, '男', 99, 95, 97));
        manage.add(new Student("骚磊", 88, '男', 99, 95, 97));
        manage.add(new Student("骚磊", 14, '男', 99, 95, 97));
        manage.add(new Student("骚磊", 77, '男', 99, 95, 97));

        DataUtil.save(manage);
    }

    @Test
    public void testSaveXML() throws IOException, IllegalAccessException {

        StudentManage manage = new StudentManage();

        manage.add(new Student("骚磊", 16, '男', 99, 95, 97));
        manage.add(new Student("骚磊", 17, '男', 99, 95, 97));
        manage.add(new Student("骚磊", 18, '男', 99, 95, 97));
        manage.add(new Student("骚磊", 14, '男', 99, 95, 97));
        manage.add(new Student("骚磊", 19, '男', 99, 95, 97));
        manage.add(new Student("骚磊", 66, '男', 99, 95, 97));
        manage.add(new Student("骚磊", 12, '男', 99, 95, 97));
        manage.add(new Student("骚磊", 88, '男', 99, 95, 97));
        manage.add(new Student("骚磊", 14, '男', 99, 95, 97));
        manage.add(new Student("骚磊", 77, '男', 99, 95, 97));

        DataUtil.saveToXML(manage);
    }

    @Test
    public void testLoad() {
        StudentManage manage = new StudentManage();
        DataUtil.load(manage);
        manage.show();
    }

    @Test
    public void testLoadXML() throws IllegalAccessException, DocumentException {
        StudentManage manage = new StudentManage();
        DataUtil.loadFromXML(manage);
        manage.show();
        manage.show();
    }

    @Test
    public void testFilter() {

        StudentManage manage = new StudentManage();

        manage.add(new Student("骚磊", 16, '男', 99, 95, 97));
        manage.add(new Student("骚磊", 17, '男', 99, 95, 97));
        manage.add(new Student("骚磊", 18, '男', 60, 95, 97));
        manage.add(new Student("骚磊", 14, '男', 99, 95, 97));
        manage.add(new Student("骚磊", 19, '男', 80, 95, 97));
        manage.add(new Student("骚磊", 66, '男', 95, 95, 97));
        manage.add(new Student("骚磊", 12, '男', 99, 95, 97));
        manage.add(new Student("骚磊", 88, '男', 99, 95, 97));
        manage.add(new Student("骚磊", 14, '男', 99, 95, 97));
        manage.add(new Student("骚磊", 77, '男', 99, 95, 97));

        manage.filter(new MyFilter() {

            @Override
            public boolean condition(Student stu) {
                return (stu.getAge() >= 18 && stu.getAge() < 70);
            }
        });

        System.out.println("----------------------------------");

        manage.filter(new MyFilter() {

            @Override
            public boolean condition(Student stu) {
                return (stu.getAge() >= 18 && stu.getAge() < 70) && (stu.getMathScore() > 80);
            }
        });
    }

    @Test
    public void testMyArrayList() {
        MyArrayList<Integer> list = new MyArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(1);
        list.add(3);
        list.add(4);
        list.add(5);

//        MyArrayList<Integer> list1 = new MyArrayList<Integer>();
//        list1.add(5);
//        list1.add(6);
//        list1.add(7);
//        list1.add(8);
//
//        list.addAll(list1);

//        System.out.println(list.indexOf(new Integer(4)));
//
//        System.out.println(list.remove(new Integer(4)));

        System.out.println(list.toString());

        MyArrayList<Integer> list2 = new MyArrayList<Integer>();
        list2.add(3);
        list2.add(4);
        list2.add(5);

        // list.containsAll(list2);

        System.out.println(list2.toString());

        System.out.println(list.containsAll(list2));
    }

    @Test
    public void testMyLinkedList() {
        MyLinkedList<Integer> list = new MyLinkedList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(1);
        list.add(3);
        list.add(4);
        list.add(5);


        System.out.println(list);

        list.removeFirst();

        System.out.println(list);

        list.removeLast();

        System.out.println(list);

        list.remove(5);

        System.out.println(list);

        list.remove(new Integer(4));

        System.out.println(list);

        list.set(1, 2);

        System.out.println(list);
    }
}
