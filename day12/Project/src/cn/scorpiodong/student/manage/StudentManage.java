package cn.scorpiodong.student.manage;

import cn.scorpiodong.student.entity.Student;
import cn.scorpiodong.student.exception.IdInvalidException;
import cn.scorpiodong.student.exception.IndexInvalidException;

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
    private Student[] allStus;

    /**
     * 学生数组最大容量
     */
    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

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
        allStus = new Student[DEFAULT_CAPACITY];
    }

    /**
     * 通过初始化容量初始化学生数组
     *
     * @param initCapacity int 初始化容量
     */
    public StudentManage(int initCapacity) {
        if (initCapacity <= 0 || initCapacity > MAX_ARRAY_SIZE) {
            System.out.println("请给出合理的初始化容量");
            allStus = new Student[DEFAULT_CAPACITY];
        } else {
            allStus = new Student[initCapacity];
        }
    }

    /**
     * 向学生数组添加数据
     *
     * @param student Student类型对象
     * @return boolean类型
     */
    public boolean add(Student student){

        try {
            add(student, size);
        } catch (IndexInvalidException e) {
            e.printStackTrace();
        }

        return true;
    }

    /**
     * 向学生数组的指定位置插入数据
     *
     * @param student Student类对象
     * @param index   int类型
     * @return boolean类型 插入成功返回true，否则返回false
     */
    public boolean add(Student student, int index) throws IndexInvalidException {
        if (index < 0 || index > size) {
            throw new IndexInvalidException("位置应该大于0且小于等于学生的总数");
        }

        if (size == allStus.length) {
            growCapacity(size + 1);
        }

        for (int i = size; i > index; i--) {
            allStus[i] = allStus[i - 1];
        }

        allStus[index] = student;
        size++;

        return true;
    }

    /**
     * 从学生数组中删除指定id的学生对象
     *
     * @param id int类型，学生id
     * @return Student 删除成功返回被删除的对象
     */
    public Student remove(int id) throws IdInvalidException {

        int index = findIndexById(id);

        Student stu = null;

        if (-1 != index) {
            stu = allStus[index];

            for (int i = index; i < size - 1; i++) {
                allStus[i] = allStus[i + 1];
            }

            allStus[--size] = null;

        }

        return stu;
    }

    /**
     * 修改学生数据
     *
     * @param id int类型，学生id
     * @return boolean 修改成功返回true，失败返回false
     */
    public boolean modify(int id) throws IdInvalidException {
        int index = findIndexById(id);

        if (-1 == index) {
            return false;
        }

        Student stu = allStus[index];

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
                    allStus[index] = stu;
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
    public Student get(int id) throws IdInvalidException {
        int index = findIndexById(id);

        Student stu = null;

        if (-1 != index) {
            stu = allStus[index];
        }

        return stu;
    }

    /**
     * 显示学生数组所有学生的信息
     */
    public void show() {
        for (int i = 0; i < size; i++) {
            System.out.println(allStus[i].toString());
        }
    }

    /**
     * 学生数组扩容
     * 默认扩容到其原大小的1.5倍，可以使用参数minCapacity进行限定
     *
     * @param minCapacity int类型，扩容后最小大小
     */
    private void growCapacity(int minCapacity) {
        int oldSize = allStus.length;
        int newSize = oldSize + (oldSize / 2);

        if (newSize < minCapacity) {
            newSize = minCapacity;
        }

        Student[] temp = new Student[newSize];

        for (int i = 0; i < size; i++) {
            temp[i] = allStus[i];
        }

        allStus = temp;
    }

    /**
     * 通过ID查找学生对象下标
     *
     * @param id int类型，学生ID
     * @return int类型 下标
     * @throws IdInvalidException id无效异常
     */
    private int findIndexById(int id) throws IdInvalidException {
        if (id < 0) {
            throw new IdInvalidException("ID号不能小于0");
        }

        int index = -1;

        for (int i = 0; i < size; i++) {
            if (allStus[i].getId() == id) {
                index = i;
                break;
            }
        }

        return index;
    }

}
