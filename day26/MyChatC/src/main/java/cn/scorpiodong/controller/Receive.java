package cn.scorpiodong.controller;

import cn.scorpiodong.model.Command;

/**
 * MyChatC - Receive interface
 *
 * @author ScorpioDong
 * @version 1.0
 * @date 2020/3/8 12:02 下午
 */
public interface Receive {
    /**
     * 处理接收到的消息
     *
     * @param cmd 接收到的消息
     */
    void receiveProcess(Command cmd) throws InterruptedException;
}
