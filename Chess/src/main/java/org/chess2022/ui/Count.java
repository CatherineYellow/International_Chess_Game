package org.chess2022.ui;

import org.chess2022.controller.ClickController;
import org.chess2022.entity.ChessColor;
import org.chess2022.entity.ChessGameFrame;
import org.chess2022.entity.Chessboard;

import javax.swing.*;
import java.awt.*;

public class Count extends Thread {
    public static JLabel jLabel=new JLabel();
    public static boolean zoule=false;
    public static int time;


    @Override
    public void run() {
        while (true) {
            time = 20;
            jLabel.setText("Remain: " + 20 + "s");
            while (time > 0) {
                if(zoule){
                    zoule=false;
                    time=20;
                    break;
                }
                time--;
                try {
                    Thread.sleep(1000);
                    int ss = time;
                    jLabel.setText("Remain: " + ss + "s");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if(time==0) {
                Chessboard.swapColor();
                if (Chessboard.currentColor == ChessColor.BLACK) {
                    ChessGameFrame.statusLabel.setText("Black Chess Round");
                } else {
                    ChessGameFrame.statusLabel.setText("White Chess Round");
                }
            }
        }
    }
}
