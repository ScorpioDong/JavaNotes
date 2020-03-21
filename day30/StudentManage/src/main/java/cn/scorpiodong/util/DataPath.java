package cn.scorpiodong.util;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * StudentManage - DataPath
 * 反射获取路径信息
 * @author ScorpioDong
 * @version 1.0
 * @date 2020/3/14 4:00 PM
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface DataPath {
    /**
     * 数据文件存储路径
     * @return 数据文件存储路径
     */
    String value();
}
