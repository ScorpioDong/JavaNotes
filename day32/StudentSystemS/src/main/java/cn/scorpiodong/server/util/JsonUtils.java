package cn.scorpiodong.server.util;

import cn.scorpiodong.server.dao.StudentDao;
import cn.scorpiodong.server.model.Student;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * StudentSystemC - JsonUtils
 * Json操作工具
 *
 * @author ScorpioDong
 * @version 1.0
 * @date 2020/3/17 7:55 下午
 */
public class JsonUtils {
    /**
     * Student对象转Json字符串
     *
     * @param student Student对象
     * @return Student对象对应的Json字符串
     */
    public static String studentToJson(Student student) {
        return JSON.toJSONString(student);
    }

    /**
     * Json字符串转Student对象
     *
     * @param json Student对象对应的Json字符串
     * @return Student对象
     */
    public static Student jsonToStudent(String json) {
        return JSON.parseObject(json, Student.class);
    }

    /**
     * 学生集合转Json字符串
     *
     * @param map 学生集合
     * @return 返回字符串
     */
    public static String studentMapToJson(Map<Integer, Student> map) {
        return JSON.toJSONString(map);
    }

    /**
     * Json转学生集合
     * @param json json字符串
     * @return 学生集合
     */
    public static Map<Integer, Student> jsonToStudentMap(String json) {
        return JSONObject.parseObject(json, new TypeReference<Map<Integer, Student>>(){});
    }

    /**
     * 保存数据到文件
     *
     * @param dao StudentDao
     * @throws IOException BufferedOutputStream读写
     */
    public static void save(StudentDao dao) throws IOException {
        BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream("./data/data.json"));
        String json = studentMapToJson(dao.getAllStudents());
        outputStream.write(json.getBytes());
        outputStream.flush();
        outputStream.close();
    }

    /**
     * 读取数据到dao
     * @param dao StudentDao
     * @throws IOException BufferedInputStream读写
     */
    public static void load(StudentDao dao) throws IOException {
        BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream("./data/data.json"));

        byte[] buf = new byte[1024 * 8];
        StringBuilder builder = new StringBuilder();

        int length = 0;
        while((length = inputStream.read(buf)) > 0) {
            builder.append(new String(buf,0,length));
        }

        String json = builder.toString();
        HashMap<Integer, Student> map = (HashMap<Integer, Student>) jsonToStudentMap(json);
        dao.setAllStudents(map);
        int max = 0;
        for (Integer integer : map.keySet()) {
            if (max < integer) {
                max = integer;
            }
        }
        dao.setCount(max + 1);
    }
}
