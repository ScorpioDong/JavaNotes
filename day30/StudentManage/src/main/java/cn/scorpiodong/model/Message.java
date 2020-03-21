package cn.scorpiodong.model;

import com.alibaba.fastjson.JSON;

/**
 * StudentManage - Message
 * 网络通讯需要传递的消息
 * @author ScorpioDong
 * @version 1.0
 * @date 2020/3/14 10:27 PM
 */
public class Message {
    private String key;
    private Object value;

    public Message(String key, Object value) {
        this.key = key;
        this.value = value;
    }

    public String toJsonString() {
        return JSON.toJSONString(this);
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
