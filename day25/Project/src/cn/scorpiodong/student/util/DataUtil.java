package cn.scorpiodong.student.util;

import cn.scorpiodong.student.entity.Student;
import cn.scorpiodong.student.manage.StudentManage;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.*;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

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
    private static String dataXMLPath = "./data.xml";

    /**
     * 需要序列化的类,实现了Serializable接口
     */
    private static class Pack implements Serializable {
        /**
         * 学生列表存储
         */
        public ArrayList<Student> list;
        /**
         * Student类计数器存储
         */
        public int count;

        public Pack(ArrayList<Student> list, int count) {
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

    /**
     * 数据存储到XML文件
     *
     * @param manage 学生管理类对象
     */
    public static void saveToXML(StudentManage manage) throws IllegalAccessException, IOException {
        Document document = DocumentHelper.createDocument();
        Element root = document.addElement("students");
        List<Student> list = manage.getAllStus();
        Field[] fields = Student.class.getDeclaredFields();

        for (Object o : list) {
            Element student = root.addElement("student");
            for (Field field : fields) {
                field.setAccessible(true);
                if ("id".equals(field.getName())) {
                    student.addAttribute("id", field.get(o) + "");
                } else {
                    student.addElement(field.getName()).setText(field.get(o) + "");
                }
            }
        }
        root.addAttribute("count", (Student.getCount() - 1) + "");

        FileWriter fileWriter = new FileWriter(dataXMLPath);
        document.write(fileWriter);
        fileWriter.close();

    }

    /**
     * 从XML文件加载数据
     *
     * @param manage 学生管理类对象
     */
    public static void loadFromXML(StudentManage manage) throws DocumentException, IllegalAccessException {
        Document document = new SAXReader().read(new File(dataXMLPath));
        Element root = document.getRootElement();
        Field[] fields = Student.class.getDeclaredFields();
        List list = root.selectNodes("//student");
        for (Object o : list) {
            Element element = (Element) o;
            Student student = new Student();
            for (Field field : fields) {
                field.setAccessible(true);
                Class<?> type = field.getType();
                if ("id".equals(field.getName())) {
                    field.set(student, parseObject(element.attribute("id").getValue(),type));
                } else {
                    field.set(student, parseObject(element.element(field.getName()).getText(),type));
                }
            }
            manage.add(student);
        }
        Student.setCount(Integer.parseInt(root.attribute("count").getValue()) + 1);
    }

    public static <T> T parseObject(String value, Class<T> tClass) {
        if (tClass.equals(int.class)) {
            return (T) Integer.valueOf(value);
        } else if (tClass.equals(String.class)) {
            return (T) value;
        } else if (tClass.equals(char.class)) {
            return (T) Character.valueOf(value.charAt(0));
        } else if (tClass.equals(long.class)) {
            return (T) Long.valueOf(value);
        } else {
            return null;
        }
    }
}
