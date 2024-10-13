package org.chess2022.entity;


import org.chess2022.controller.*;

import javax.swing.*;
import java.awt.*;

import org.chess2022.dao.Saves;
import org.chess2022.ui.BackgroundListener;
import org.chess2022.ui.Backgroundpanel;
import org.chess2022.ui.Count;
import org.chess2022.ui.attributeListener;
import org.chess2022.values.FrameMod;
import org.chess2022.view.ViewManager;

/**
 * 这个类表示游戏过程中的整个游戏界面，是一切的载体
 */
public class ChessGameFrame extends JFrame {
    //    public final Dimension FRAME_SIZE ;
    private final int WIDTH;
    public final int HEIGTH;
    public static int CHESSBOARD_SIZE;
    public static GameController gameController;
    public static Backgroundpanel panel;
    public static int height;
    public static JLabel statusLabel = new JLabel();
    public static Count counter;

    public ChessGameFrame(int width, int height) {
        setTitle("Chess"); //设置标题
        this.WIDTH = width;
        this.HEIGTH = height;
        ChessGameFrame.height = HEIGTH;
        CHESSBOARD_SIZE = HEIGTH * 4 / 5;

        setSize(WIDTH, HEIGTH);
        setLocationRelativeTo(null); // Center the window.
       // setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //设置程序关闭按键，如果点击右上方的叉就游戏全部关闭了
        setLayout(null);
        panel = new Backgroundpanel("Chess/src/main/java/images/gameBackground1.png");
        panel.setLayout(null);
        panel.setBounds(0, 0, this.getWidth(), this.getHeight());
        this.add(panel);
        panel.setVisible(true);


        addChessboard();
        addLabel();
        addRestartButton();
        addLoadButton();
        addRegretButton();
        addSaveButton();
        addBackGroundButton();
        addTimeLabel();
        addAttributesButton();
        panel.repaint();

    }


    /**
     * 在游戏面板中添加棋盘
     */
    public void addChessboard() {
        Chessboard chessboard = new Chessboard(CHESSBOARD_SIZE, CHESSBOARD_SIZE);
        gameController = new GameController(chessboard);
        chessboard.setLocation(HEIGTH / 10, HEIGTH / 10);
        chessboard.initiateOriginChessboard();
        panel.add(chessboard);
        chessboard.repaint();
        panel.repaint();
    }

    /**
     * 在游戏面板中添加标签
     */
    public void addLabel() {
        statusLabel.setText("White Chess Round");
        statusLabel.setLocation(HEIGTH, HEIGTH / 10 - 20);
        statusLabel.setSize(200, 60);
        statusLabel.setFont(new Font("Rockwell", Font.BOLD, 20));
        panel.add(statusLabel);
        panel.repaint();
    }


    public void addTimeLabel() {
        // TODO: 2022/5/19 计时器
        if (counter == null) {
            counter = new Count();
            counter.start();
        } else {
            Count.time = 20;
            Count.jLabel.setText("Remain: " + 20 + "s");
        }
        Count.jLabel.setLocation(100, 0);
//        Count.jLabel.setLocation(HEIGTH, HEIGTH / 10 - 50);
        Count.jLabel.setSize(800, 100);
        Count.jLabel.setFont(new Font("Rockwell", Font.BOLD, 30));
        Count.jLabel.setVisible(true);
        panel.add(Count.jLabel);
        panel.repaint();
    }


        public void addRestartButton() {
        JButton button = new JButton("Restart");
        button.setLocation(HEIGTH, HEIGTH / 10 + 60);
        button.setSize(200, 60);
        button.setFont(new Font("Rockwell", Font.BOLD, 20));
        panel.add(button);
        button.addActionListener(new RestartController(this));
        panel.repaint();
    }

    public void addLoadButton() {
        JButton button = new JButton("Load");
        button.setLocation(HEIGTH, HEIGTH / 10 + 140);
        button.setSize(200, 60);
        button.setFont(new Font("Rockwell", Font.BOLD, 20));
        panel.add(button);
        button.addActionListener(new LoadController(this));
        panel.repaint();
    }

    public void addRegretButton() {
        JButton button = new JButton("Regret");
        button.setLocation(HEIGTH, HEIGTH / 10 + 220);
        button.setSize(200, 60);
        button.setFont(new Font("Rockwell", Font.BOLD, 20));
        panel.add(button);
        button.addActionListener(new RegretController(this));
        panel.repaint();
    }

    public void addSaveButton() {
        JButton button = new JButton("Save");
        button.setLocation(HEIGTH, HEIGTH / 10 + 300);
        button.setSize(200, 60);
        button.setFont(new Font("Rockwell", Font.BOLD, 20));
        panel.add(button);
        button.addActionListener(e -> {
            Saves.save();
        });
        panel.repaint();
    }

    public void addBackGroundButton() {
        JButton button = new JButton("Background");
        button.setLocation(HEIGTH, HEIGTH / 10 + 380);
        button.setSize(200, 60);
        button.setFont(new Font("Rockwell", Font.BOLD, 20));
        panel.add(button);
        button.addActionListener(new BackgroundListener(this, panel));
        panel.repaint();
    }

    public void addAttributesButton() {
        JButton button = new JButton("Attributes");
        button.setLocation(HEIGTH, HEIGTH / 10 + 460);
        button.setSize(200, 60);
        button.setFont(new Font("Rockwell", Font.BOLD, 20));
        panel.add(button);
        button.addActionListener(new attributeListener(this));
        panel.repaint();
    }

    public void addReplaysButton() {
        JButton button = new JButton("Replay");
        button.setLocation(height, height / 10 + 300);
        button.setSize(200, 60);
        button.setFont(new Font("Rockwell", Font.BOLD, 20));
        panel.add(button);
        button.addActionListener(new ReplayController(this));
        panel.repaint();
    }
}
