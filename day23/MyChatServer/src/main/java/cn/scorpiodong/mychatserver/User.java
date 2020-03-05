package cn.scorpiodong.mychatserver;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * MyChatClient - User
 *
 * @author ScorpioDong
 * @version 1.0
 * @date 2020/3/4 8:54 下午
 */
public class User {
    @JSONField(name = "NAME")
    private String name;

    @JSONField(name = "IP")
    private String ip;

    @JSONField(name = "DATE")
    private long date;

    @JSONField(name = "CMD")
    private String cmd;

    @JSONField(name = "DATA")
    private String data;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public String getCmd() {
        return cmd;
    }

    public void setCmd(String cmd) {
        this.cmd = cmd;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
