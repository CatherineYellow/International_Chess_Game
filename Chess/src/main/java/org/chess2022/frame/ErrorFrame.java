package org.chess2022.frame;

import org.chess2022.dao.Saves;
import org.chess2022.ui.Backgroundpanel;

import javax.swing.*;
import java.awt.*;

public class ErrorFrame extends JFrame {
    private static int x;
    private static int y;
    private static int width;
    private static int height;
    public static JPanel panel;
    private static ErrorFrame frame=new ErrorFrame();
    public static JLabel errorLabel = new JLabel();
    private ErrorFrame(){
        x=0;
        y=0;
        width=0;
        height=0;
        panel=new Backgroundpanel("Chess/src/main/java/images/E.jpg");
        panel.setLayout(null);
        panel.setOpaque(false);
        this.add(panel);
        panel.setVisible(true);
    }

    private static void setScale(int x,int y,int width,int height){
        ErrorFrame.height=height;
        ErrorFrame.width=width;
        ErrorFrame.x=x;
        ErrorFrame.y=y;
        panel.setBounds(0,0,width,height);
    }


    public static ErrorFrame getFrame() {
        return frame;
    }
    public static void addLabel() {
        errorLabel.setLocation(30, 30);
        errorLabel.setSize(300, 90);
        errorLabel.setFont(new Font("Rockwell", Font.BOLD, 30));
        errorLabel.setVisible(true);
        panel.add(errorLabel);
        panel.repaint();
    }


    public static ErrorFrame getFrame(int x,int y,int width,int height) {
        setScale(x,y,width,height);
        frame.setLayout(null);
        frame.setBounds(ErrorFrame.x,ErrorFrame.y,ErrorFrame.width,ErrorFrame.height);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        return frame;
    }

    public static void addButton(int x, int y, int width, int height, String str){
        DynamicButton button=DynamicButton.createButton(x,y,width,height,str);
        button.setFont(new Font("Rockwell", Font.BOLD, 20));
        panel.add(button);
        button.addActionListener(e -> {
            frame.dispose();
        });
        panel.repaint();

    }

    public static void close(){
        frame.dispose();
    }

}
