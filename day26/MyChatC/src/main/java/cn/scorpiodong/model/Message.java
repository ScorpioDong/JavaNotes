package cn.scorpiodong.model;

import java.io.Serializable;

/**
 * MyChatC - Message
 *
 * @author ScorpioDong
 * @version 1.0
 * @date 2020/3/7 4:53 下午
 */
public class Message implements Serializable {

    public static final long serialVersionUID = 1L;

    private String name;
    private String address;
    private long time;
    private String data;

    public Message() {}

    public Message(String name, String address, long time, String data) {
        this.name = name;
        this.address = address;
        this.time = time;
        this.data = data;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
