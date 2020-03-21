package cn.scorpiodong.client.service;

import cn.scorpiodong.client.model.Student;
import cn.scorpiodong.client.util.JsonUtils;

import java.util.Map;

/**
 * StudentSystemC - ClientService
 * MVC Service 层
 *
 * @author ScorpioDong
 * @version 1.0
 * @date 2020/3/17 10:10 下午
 */
public class ClientService {
    public static String add() {
        return null;
    }

    public static void showStudentMap(String json) {
        Map<Integer, Student> map = JsonUtils.jsonToStudentMap(json);
        map.values().forEach(v -> System.out.println(v.toString()));
    }

    public static void showStudent(String json) {
        Student student = JsonUtils.jsonToStudent(json);
        System.out.println(student.toString());
    }
 }
