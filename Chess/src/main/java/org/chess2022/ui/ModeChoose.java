package org.chess2022.ui;

import javax.swing.*;
import java.awt.*;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class ModeChoose{
    public static void main(String[] args) {
        // 窗口
        JFrame modeFrame = new JFrame("Mode");
        modeFrame.setSize(250,300);
        modeFrame.setLocationRelativeTo(null);
        modeFrame.setResizable(false);
        modeFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);

        //面板
        Backgroundpanel Panel = new Backgroundpanel("Chess/src/main/java/images/modep.png");
        modeFrame.add(Panel);

        JLabel kong1 = new JLabel("",JLabel.CENTER);
        kong1.setPreferredSize(new Dimension(200,15));
        JLabel kong2 = new JLabel("",JLabel.CENTER);
        kong2.setPreferredSize(new Dimension(200,15));
        JLabel kong3 = new JLabel("",JLabel.CENTER);
        kong3.setPreferredSize(new Dimension(200,15));
//        kong.setFont(labelFont);

//        Font Font1 = new Font("Ink Free", Font.BOLD, 20);
          Font Font1 = new Font("MV Boli", Font.BOLD, 20);
        JButton TWO=new JButton("TWO");
        TWO.setSize(30,20);
        TWO.setFont(Font1);
        JButton AI=new JButton("HMI");
        AI.setSize(30,20);
        AI.setFont(Font1);
        JButton Rank=new JButton("Rank");
        Rank.setSize(30,20);
        Rank.setFont(Font1);

        Panel.add(kong1);
        Panel.add(TWO);
        Panel.add(kong2);
        Panel.add(AI);
        Panel.add(kong3);
        Panel.add(Rank);

        //监听器
        TWOlistener twolistener=new TWOlistener(modeFrame);
        TWO.addActionListener(twolistener);
        AIlistener ailistener=new AIlistener(modeFrame);
        AI.addActionListener(ailistener);
        Ranklistener ranklistener=new Ranklistener(modeFrame);
        Rank.addActionListener(ranklistener);


        modeFrame.setVisible(true);
    }
}
