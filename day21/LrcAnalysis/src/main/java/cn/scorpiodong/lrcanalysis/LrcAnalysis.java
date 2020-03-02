package cn.scorpiodong.lrcanalysis;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

import java.io.*;

/**
 * 音乐播放类
 */
class Music {
    private Player music;
    private BufferedReader lyric;

    public Music() throws FileNotFoundException, JavaLayerException {
        music = new Player(new BufferedInputStream(new FileInputStream("./src/main/resources/picture.mp3")));
        lyric = new BufferedReader(new FileReader("./src/main/resources/picture.lrc"));
    }

    /**
     * 歌词解析输出
     */
    private void lyricAnalyze() throws IOException, InterruptedException {
        int oldTime = 0;
        int newTime = 0;
        String line;
        while ((line = lyric.readLine()) != null) {
            boolean flag;
            try {
                flag = line.charAt(3) == ':' && line.charAt(6) == '.';
            } catch (StringIndexOutOfBoundsException e) {
                flag = false;
            }
            if (flag) {
                String time = line.substring(line.indexOf('[') + 1, line.indexOf(']'));
                newTime = Integer.parseInt(time.substring(0, 2)) * 60 * 1000
                        + Integer.parseInt(time.substring(3, 5)) * 1000
                        + Integer.parseInt(time.substring(6, 8));

                Thread.sleep(newTime - oldTime);

                System.out.println(line.substring(line.indexOf(']') + 1));
            }
            oldTime = newTime;
        }
    }

    /**
     * 音乐播放
     */
    public void play() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    music.play();
                } catch (JavaLayerException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    lyricAnalyze();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}

/**
 * Lrc 歌词解析，歌曲播放
 *
 * @author ScorpioDong
 */
public class LrcAnalysis {
    public static void main(String[] args) throws IOException, JavaLayerException {
        new Music().play();
    }
}
