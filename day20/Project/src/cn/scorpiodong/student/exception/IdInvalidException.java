package cn.scorpiodong.student.exception;

/**
 * 学生管理系统 - 异常类 - ID无效异常
 *
 * @author ScorpioDong
 */
public class IdInvalidException extends Exception {
    public IdInvalidException() {
    }

    public IdInvalidException(String message) {
        super(message);
    }
}
