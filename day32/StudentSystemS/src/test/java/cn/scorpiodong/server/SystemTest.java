package cn.scorpiodong.server;

import cn.scorpiodong.server.dao.StudentDao;
import cn.scorpiodong.server.model.Student;
import cn.scorpiodong.server.util.JsonUtils;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * StudentSystemC - SystemTest
 * 测试类
 *
 * @author ScorpioDong
 * @version 1.0
 * @date 2020/3/17 7:36 下午
 */
class SystemTest {
    @Test
    public void mainTest() {

    }

    @Test
    public void saveTest() throws IOException {
        StudentDao dao = StudentDao.getInstance();

        dao.add(new Student(0,"骚磊",false, 12,100,100,100,300,0));
        dao.add(new Student(0,"骚磊",false, 12,100,100,100,300,0));
        dao.add(new Student(0,"骚磊",false, 12,100,100,100,300,0));
        dao.add(new Student(0,"骚磊",false, 12,100,100,100,300,0));
        dao.add(new Student(0,"骚磊",false, 12,100,100,100,300,0));

        JsonUtils.save(dao);
    }

    @Test
    public void loadTest() throws IOException {
        StudentDao dao = StudentDao.getInstance();
        JsonUtils.load(dao);
        dao.show();
        dao.add(new Student(0,"骚磊",false, 12,100,100,100,300,0));
        dao.show();
    }

}