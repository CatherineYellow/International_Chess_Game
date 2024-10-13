package org.chess2022.ui;

public class MusicError extends Thread {


    @Override
    public void run() {


        try {
            Mymusic.playmusic("Chess/src/main/java/musics/error.mp3");
        } catch (Exception e) {
            System.out.println("播放失败");
        }
    }

}