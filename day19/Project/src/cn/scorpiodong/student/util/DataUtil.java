package cn.scorpiodong.student.util;

import cn.scorpiodong.student.entity.Student;
import cn.scorpiodong.student.manage.StudentManage;

import java.io.*;

/**
 * 学生管理系统 - 数据存储工具类
 *
 * @author scorpio
 */
public class DataUtil {
    /**
     * 数据文件路径
     */
    private static String dataPath = "./data.txt";

    /**
     * 需要序列化的类,实现了Serializable接口
     */
    private static class Pack implements Serializable {
        /**
         * 学生列表存储
         */
        public MyArrayList<Student> list;
        /**
         * Student类计数器存储
         */
        public int count;

        public Pack(MyArrayList<Student> list, int count) {
            this.list = list;
            this.count = count;
        }
    }

    /**
     * 数据存储到文件
     *
     * @param manage 学生管理类对象
     */
    public static void save(StudentManage manage) {
        ObjectOutputStream objectOutputStream = null;
        try {
            objectOutputStream = new ObjectOutputStream(new FileOutputStream(dataPath));
            objectOutputStream.writeObject(new Pack(manage.getAllStus(), Student.getCount()));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != objectOutputStream) {
                try {
                    objectOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 从文件加载数据
     *
     * @param manage 学生管理类对象
     */
    public static void load(StudentManage manage) {
        ObjectInputStream objectInputStream = null;
        try {
            objectInputStream = new ObjectInputStream(new FileInputStream(dataPath));
            Pack pack = (Pack) objectInputStream.readObject();
            manage.setAllStus(pack.list);
            Student.setCount(pack.count);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (objectInputStream != null) {
                try {
                    objectInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
