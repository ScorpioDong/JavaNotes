package cn.scorpiodong.server.util;

import org.apache.log4j.Logger;

/**
 * StudentSystemC - LogUtils
 * 日志工具
 *
 * @author ScorpioDong
 * @version 1.0
 * @date 2020/3/17 7:32 下午
 */
public class LogUtils {
    private static Logger logDebug = Logger.getLogger("DEBUG");

    /**
     * 输出DEBUG级别的日志
     *
     * @param msg 日志内容
     */
    public static void debug(Object msg) {
        logDebug.debug(msg);
    }
}
