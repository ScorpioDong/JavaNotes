package cn.scorpiodong.util;

import cn.scorpiodong.controller.Manage;
import cn.scorpiodong.model.Student;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

import java.io.*;

/**
 * StudentManage - DataUtils
 *
 * @author ScorpioDong
 * @version 1.0
 * @date 2020/3/14 3:59 PM
 */
@DataPath("./data.json")
public class DataUtils {
    /**
     * 保存数据到文件
     * @param manage Manage 学生管理器对象
     */
    public static void dataSave(Manage manage) {
        try {
            try (BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream(getDataPathFromAnnotation()))) {
                JSONArray objects = new JSONArray();
                objects.addAll(manage.getElements());
                String jsonStr = objects.toJSONString();
                output.write(jsonStr.getBytes());
                output.flush();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 从文件加载数据
     * @param manage Manage 学生管理器对象
     */
    public static void dataLoad(Manage manage) {
        try {
            try (BufferedInputStream input = new BufferedInputStream(new FileInputStream(getDataPathFromAnnotation()))) {
                int length = input.available();
                byte[] arr = new byte[length];
                input.read(arr, 0, length);
                JSONArray objects = JSON.parseArray(new String(arr, 0, length));
                objects.forEach((o -> manage.add(JSON.parseObject(o.toString(), Student.class))));
                Student.setCount(objects.size());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 从注解返回数据路径
     * @return String 数据路径
     */
    private static String getDataPathFromAnnotation() {
        return DataUtils.class.getAnnotation(DataPath.class).value();
    }
}
