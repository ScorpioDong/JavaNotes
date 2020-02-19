package cn.scorpiodong.student.exception;

/**
 * 学生管理系统 - 异常类 - 下标无效异常
 * @author scorpio
 */
public class IndexInvalidException extends Exception {
    public IndexInvalidException() {
    }

    public IndexInvalidException(String message) {
        super(message);
    }
}
