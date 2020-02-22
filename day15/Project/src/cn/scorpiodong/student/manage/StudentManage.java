package cn.scorpiodong.student.manage;

import cn.scorpiodong.student.util.MyArrayList;
import cn.scorpiodong.student.entity.Student;
import cn.scorpiodong.student.interfaces.MyComparator;
import cn.scorpiodong.student.interfaces.MyFilter;

import java.util.Scanner;

/**
 * 学生管理系统 - 学生管理类
 *
 * @author ScorpioDong
 */
public class StudentManage {
    /**
     * 学生类数组，存储Student类对象
     */
    private MyArrayList<Student> allStus;

    /**
     * 使用默认容量初始化学生数组
     */
    public StudentManage() {
        allStus = new MyArrayList<>();
    }

    /**
     * 通过初始化容量初始化学生数组
     *
     * @param initCapacity int 初始化容量
     */
    public StudentManage(int initCapacity) {
        allStus = new MyArrayList<>(initCapacity);
    }

    /**
     * 向学生数组添加数据
     *
     * @param student Student类型对象
     * @return boolean类型
     */
    public boolean add(Student student) {
        return allStus.add(student);
    }

    /**
     * 向学生数组的指定位置插入数据
     *
     * @param student Student类对象
     * @param index   int类型
     * @return boolean类型 插入成功返回true，否则返回false
     */
    public boolean add(int index,Student student) {
        return allStus.add(index, student);
    }

    /**
     * 从学生数组中删除指定id的学生对象
     *
     * @param id int类型，学生id
     * @return Student 删除成功返回被删除的对象
     */
    public Student remove(int id) {

        int index = findIndexById(id);
        return allStus.remove(index);
    }

    /**
     * 修改学生数据
     *
     * @param id int类型，学生id
     * @return boolean 修改成功返回true，失败返回false
     */
    public boolean modify(int id) {
        int index = findIndexById(id);

        if (-1 == index) {
            return false;
        }

        Student stu = allStus.get(index);

        Scanner sc = new Scanner(System.in);

        int choose = 0;

        boolean flag = false;

        do {
            System.out.println("学生信息如下：");
            System.out.println("ID:" + stu.getId());
            System.out.println("Name:" + stu.getName());
            System.out.println("Age:" + stu.getAge());
            System.out.println("Gender:" + stu.getGender());
            System.out.println("MathScore:" + stu.getMathScore());
            System.out.println("ChnScore:" + stu.getChnScore());
            System.out.println("EngScore:" + stu.getMathScore());
            System.out.println("TotalScore:" + stu.getTotalScore());
            System.out.println("Rank:" + stu.getRank());
            System.out.println("-------------------------");

            System.out.println("1. 修改学生姓名");
            System.out.println("2. 修改学生年龄");
            System.out.println("3. 修改学生性别");
            System.out.println("4. 修改学生数学成绩");
            System.out.println("5. 修改学生语文成绩");
            System.out.println("6. 修改学生英语成绩");
            System.out.println("7. 退出");

            choose = sc.nextInt();
            sc.nextLine();

            switch (choose) {
                case 1:
                    System.out.println("请输入学生姓名：");
                    String name = sc.nextLine();
                    stu.setName(name);
                    break;
                case 2:
                    System.out.println("请输入学生年龄：");
                    int age = sc.nextInt();
                    stu.setAge(age);
                    break;
                case 3:
                    System.out.println("请输入学生性别：");
                    char gender = sc.nextLine().charAt(0);
                    stu.setGender(gender);
                    break;
                case 4:
                    System.out.println("请输入学生数学成绩：");
                    int mathScore = sc.nextInt();
                    stu.setMathScore(mathScore);
                    break;
                case 5:
                    System.out.println("请输入学生语文成绩：");
                    int chnScore = sc.nextInt();
                    stu.setChnScore(chnScore);
                    break;
                case 6:
                    System.out.println("请输入学生英语成绩：");
                    int engScore = sc.nextInt();
                    stu.setEngScore(engScore);
                    break;
                case 7:
                    allStus.set(index, stu);
                    flag = true;
                    break;
                default:
                    break;
            }

        } while (!flag);

        return true;
    }

    /**
     * 获取对应id的学生对象
     *
     * @param id int类型，学生id
     * @return Student类对象
     */
    public Student get(int id) {
        int index = findIndexById(id);
        return allStus.get(index);
    }

    /**
     * 显示学生数组所有学生的信息
     */
    public void show() {
        for (int i = 0; i < allStus.size(); i++) {
            System.out.println(allStus.get(i).toString());
        }
    }

    /**
     * 使用比较器对学生数组进行排序
     *
     * @param comparator 实现比较器接口的类
     */
    public void selectSortUsingComparator(MyComparator comparator) {
        // 拷贝学生数组
        Student[] temp = new Student[allStus.size()];

        for (int i = 0; i < allStus.size(); i++) {
            temp[i] = allStus.get(i);
        }

        // 选择排序
        for (int i = 0; i < allStus.size(); i++) {
            int index = i;
            for (int j = i + 1; j < allStus.size(); j++) {
                if (comparator.compare(temp[index], temp[j])) {
                    index = j;
                }
            }
            if (index != i) {
                Student stu = temp[i];
                temp[i] = temp[index];
                temp[index] = stu;
            }
        }

        for (Student stu : temp) {
            System.out.println(stu.toString());
        }
    }


    public void filter(MyFilter myFilter) {
        // 符合条件的学生数组
        Student[] stus = new Student[allStus.size()];

        // 有效元素计数器
        int counter = 0;

        // 筛选
        for (int i = 0; i < allStus.size(); i++) {
            if (myFilter.condition(allStus.get(i))) {
                stus[counter++] = allStus.get(i);
            }
        }

        // 显示
        for (int i = 0; i < counter; i++) {
            System.out.println(stus[i].toString());
        }
    }

    /**
     * 通过ID查找学生对象下标
     *
     * @param id int类型，学生ID
     * @return int类型 下标
     */
    private int findIndexById(int id) {

        int index = -1;

        for (int i = 0; i < allStus.size(); i++) {
            if (allStus.get(i).getId() == id) {
                index = i;
                break;
            }
        }

        return index;
    }

}
