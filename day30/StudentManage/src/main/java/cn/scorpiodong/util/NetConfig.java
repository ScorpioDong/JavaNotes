package cn.scorpiodong.util;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * StudentManage - NetConfig
 * 网络连接配置
 * @author ScorpioDong
 * @version 1.0
 * @date 2020/3/14 8:02 PM
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface NetConfig {
    String ip() default "127.0.0.1";
    int port() default 20531;
}
