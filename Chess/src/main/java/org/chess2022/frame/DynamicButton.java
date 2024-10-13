package org.chess2022.frame;

import org.chess2022.util.ImageUtil;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.util.ResourceBundle;

public class DynamicButton extends JButton {

    int x;
    int y;
    int width;
    int height;
    String path;
    String text;
    static ResourceBundle bundle=ResourceBundle.getBundle("config");

    public DynamicButton(int x,int y,int width,int height,String str){
        this.x=x;
        this.y=y;
        this.width=width;
        this.height=height;
        this.text=str;
    }

    public DynamicButton(int width,int height,String str){

        this.width=width;
        this.height=height;
        this.text=str;
    }
    public static DynamicButton createButton(int x,int y,int width,int height,String str) {
        DynamicButton button = new DynamicButton(x, y, width, height,str);
        button.setText(str);
        button.setLayout(null);
        button.setIcon(null);
        button.setFocusPainted(false);
        button.setBorder(null);
        button.setBounds(x,y,width,height);
        button.setContentAreaFilled(false);
        button.setOpaque(true);
        button.addDynamicEffect(bundle.getString("buttonPic.path"));
        button.setHorizontalTextPosition(HORIZONTAL);
        button.setVerticalTextPosition(HORIZONTAL);
        button.setVisible(true);
        return button;
    }


    private void addDynamicEffect(String path){
        this.path=path;
        ImageIcon icon=new ImageIcon(path);
        ImageUtil.scaledImage(width, height, icon);
        this.addMouseListener(new MouseEvent(icon,this));

    }
}
