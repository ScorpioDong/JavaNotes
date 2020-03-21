package cn.scorpiodong.model;

import java.io.Serializable;

/**
 * MyChatC - Command
 *
 * @author ScorpioDong
 * @version 1.0
 * @date 2020/3/7 4:50 下午
 */
public class Command implements Serializable {

    public static final long serialVersionUID = 2L;

    private String key;
    private Object value;

    public Command(String key) {
        this.key = key;
    }

    public Command(String key, Object value) {
        this.key = key;
        this.value = value;
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
