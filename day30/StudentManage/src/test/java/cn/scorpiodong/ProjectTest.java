package cn.scorpiodong;

import cn.scorpiodong.controller.Manage;
import cn.scorpiodong.model.Student;
import cn.scorpiodong.util.DataUtils;
import org.junit.jupiter.api.Test;

/**
 * StudentManage - ProjectTest
 *
 * @author ScorpioDong
 * @version 1.0
 * @date 2020/3/14 10:38 AM
 */
class ProjectTest {
    @Test
    public void manageTest() {
        Manage manage = Manage.getInstance();
        manage.add(new Student("骚磊", 12, '男', 61, 17, 59));
        manage.add(new Student("骚磊", 13, '男', 65, 15, 55));
        manage.add(new Student("骚磊", 15, '男', 68, 12, 51));
        manage.add(new Student("骚磊", 14, '男', 62, 90, 57));
        manage.add(new Student("骚磊", 16, '男', 69, 78, 53));
        manage.add(new Student("骚磊", 19, '男', 51, 82, 54));
        manage.add(new Student("骚磊", 17, '男', 53, 26, 50));
        manage.add(new Student("骚磊", 18, '男', 90, 58, 60));

        manage.remove(3);
        manage.add(new Student("骚磊", 22, '男', 100, 80, 0));

        manage.show();
    }

    @Test
    public void saveTest() {
        Manage manage = Manage.getInstance();
        manage.add(new Student("骚磊", 12, '男', 61, 17, 59));
        manage.add(new Student("骚磊", 13, '男', 65, 15, 55));
        manage.add(new Student("骚磊", 15, '男', 68, 12, 51));
        manage.add(new Student("骚磊", 14, '男', 62, 90, 57));
        manage.add(new Student("骚磊", 16, '男', 69, 78, 53));
        manage.add(new Student("骚磊", 19, '男', 51, 82, 54));
        manage.add(new Student("骚磊", 17, '男', 53, 26, 50));
        manage.add(new Student("骚磊", 18, '男', 90, 58, 60));

        DataUtils.dataSave(manage);
    }

    @Test
    public void loadTest() {
        Manage manage = Manage.getInstance();
        DataUtils.dataLoad(manage);
        manage.show();
        manage.add(new Student("骚磊", 12, '男', 61, 17, 59));
        manage.show();
    }
}