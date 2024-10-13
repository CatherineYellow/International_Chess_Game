package org.chess2022.ui;

public class MusicStart extends Thread {

    public void run() {
        for (int i = 0; i < 20; i++) {
            try {
                Mymusic.playmusic("Chess/src/main/java/musics/是阿泽 - 别看我只是一只羊.mp3");
            } catch (Exception e) {
                System.out.println("播放失败");
            }
        }
        }


}