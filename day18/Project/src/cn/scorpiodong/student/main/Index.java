package cn.scorpiodong.student.main;

import cn.scorpiodong.student.entity.Student;
import cn.scorpiodong.student.manage.StudentManage;

import java.util.Scanner;

/**
 * 学生管理系统 - 主类
 *
 * @author ScorpioDong
 */
public class Index {

    /**
     * 全局扫描器
     */
    private static Scanner sc = new Scanner(System.in);

    /**
     * 管理器
     */
    private static StudentManage manage = new StudentManage();

    public static void main(String[] args) {

        boolean flag = false;
        int choose = 0;
        do {
            System.out.println("--------------------");
            System.out.println("- 欢迎使用学生管理系统 -");
            System.out.println("- 1. 添加学生 ");
            System.out.println("- 2. 删除学生 ");
            System.out.println("- 3. 修改学生信息 ");
            System.out.println("- 4. 查看学生信息 ");
            System.out.println();
            System.out.println("- 5. 退出 ");
            System.out.println("--------------------");
            System.out.print("请输入您的操作：");

            choose = sc.nextInt();
            switch (choose) {
                case 1:
                    addStudent();
                    break;
                case 5:
                    flag = true;
                    break;
                default:
                    break;
            }
        } while (!flag);
    }

    /**
     * 添加学生
     *
     * @return boolean 添加成功返回true
     */
    public static boolean addStudent() {

        do {
            sc.nextLine();
            System.out.print("请输入学生姓名:");
            String name = sc.nextLine();
            System.out.print("请输入学生年龄:");
            int age = sc.nextInt();
            sc.nextLine();
            System.out.print("请输入学生性别:");
            char gender = sc.nextLine().charAt(0);
            System.out.print("请输入学生数学成绩:");
            int mathScore = sc.nextInt();
            System.out.print("请输入学生语文成绩:");
            int chnScore = sc.nextInt();
            System.out.print("请输入学生英语成绩:");
            int engScore = sc.nextInt();
            sc.nextLine();

            Student stu = new Student(name, age, gender, mathScore, chnScore, engScore);
            manage.add(stu);

            System.out.print("是否继续添加（Y/N)");
            char choose = sc.nextLine().charAt(0);
            if (!('Y' == choose || 'y' == choose)) {
                break;
            }
        } while (true);

        return true;
    }

    /**
     * 删除学生
     *
     * @return 删除成功返回true
     */
    public static boolean removeStudent() {

        return true;
    }
}
