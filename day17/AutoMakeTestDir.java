package cn.scorpiodong.filehomework;

import java.io.File;
import java.io.IOException;
import java.util.Random;

/**
 * File - AutoMakeTestDir
 *
 * @author ScorpioDong
 */
public class AutoMakeTestDir {
    public static void main(String[] args) throws IOException {
        String[] endName = {".doc", ".xls", ".ppt", ".avi", ".mp3", ".mp4", ".java", ".class", ".txt", ".zip"};
        File f = new File("/Users/scorpio/Desktop/test");
        Random r = new Random();

        // 生成文件
        for (int i = 0; i < 50; i++) {
            int num = Math.abs(r.nextInt());
            String name = num + endName[num % 10];

            File file = new File(f, name);

            file.createNewFile();
        }

        // 生成文件夹
        for (int i = 0; i < 20; i++) {
            String name = Math.abs(r.nextInt()) + "";

            File file = new File(f, name);

            file.mkdir();
        }
    }


}
