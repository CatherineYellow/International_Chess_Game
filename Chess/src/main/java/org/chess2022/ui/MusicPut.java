package org.chess2022.ui;

public class MusicPut extends Thread {



    @Override
    public void run() {
        try {
            Mymusic.playmusic("Chess/src/main/java/musics/Put.mp3");
        } catch (Exception e) {
            System.out.println("播放失败");
        }
    }

}