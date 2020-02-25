package cn.scorpiodong.filehomework;

import java.io.File;

/**
 * File - HomeWork
 *
 * @author ScorpioDong
 */
public class HomeWork {
    public static void main(String[] args) {
        File f = new File("/Users/scorpio/Desktop/test");

        File[] listName = f.listFiles();
        for (File file : listName) {
            if (file.isFile()) {
                String name = file.getName();
                String[] names = name.split("\\.");
                String endName = names[names.length - 1];
                String subDirName = f.getAbsolutePath() + "/" + endName.toUpperCase();
                moveToDir(file, subDirName);
            } else {
                String subDirName = f.getAbsolutePath() + "/subDir";
                moveToDir(file, subDirName);
            }
        }
    }

    /**
     * 将文件转移到指定目录
     *
     * @param file 文件
     * @param dest 目标目录，不存在将创建
     * @return 成功返回true
     */
    public static boolean moveToDir(File file, String dest) {
        boolean flag = true;
        File subDir = new File(dest);
        if (!subDir.exists()) {
            subDir.mkdirs();
        }
        File destDir = new File(subDir, file.getName());
        flag &= file.renameTo(destDir);
        return flag;
    }
}
