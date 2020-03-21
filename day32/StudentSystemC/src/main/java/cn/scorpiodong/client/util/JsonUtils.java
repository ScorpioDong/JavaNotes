package cn.scorpiodong.client.util;

import cn.scorpiodong.client.model.Student;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;

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

}
