package cn.scorpiodong.student.util;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Project - DataPath
 * 注解指定数据的路径
 *
 * @author ScorpioDong
 * @version 1.0
 * @date 2020/3/10 9:32 PM
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface DataPath {
    String value();
}
