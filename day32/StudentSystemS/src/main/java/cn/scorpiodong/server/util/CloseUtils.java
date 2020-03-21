package cn.scorpiodong.server.util;

import java.io.Closeable;
import java.io.IOException;

/**
 * StudentSystemC - CloseUtils
 * Close工具
 *
 * @author ScorpioDong
 * @version 1.0
 * @date 2020/3/17 10:03 下午
 */
public class CloseUtils {
    /**
     * 可以调用close方法的类都可以使用
     *
     * @param res 不定长参数Closeable接口实现类，处理资源关闭问题
     */
    public static void closeAll(Closeable... res) {
        for (Closeable re : res) {
            try {
                if (re != null) {
                    re.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
