package org.chess2022.frame;

import org.chess2022.ui.Backgroundpanel;

import javax.swing.*;

public class MenuFrame extends JFrame {

    private static int x;
    private static int y;
    private static int width;
    private static int height;
    public static JPanel panel;
    private static MenuFrame frame=new MenuFrame();

    private MenuFrame(){
        super("Menu");
        x=0;
        y=0;
        width=0;
        height=0;
        panel=new Backgroundpanel("Chess/src/main/java/images/MenuP.png");
        panel.setLayout(null);
        panel.setOpaque(false);
        this.add(panel);
        panel.setVisible(true);
    }

    private static void setScale(int x,int y,int width,int height){
        MenuFrame.height=height;
        MenuFrame.width=width;
        MenuFrame.x=x;
        MenuFrame.y=y;
        panel.setBounds(0,0,width,height);
    }


    public static MenuFrame getFrame() {
        return frame;
    }


    public static MenuFrame getFrame(int x,int y,int width,int height) {
        setScale(x,y,width,height);
        frame.setLayout(null);
        frame.setBounds(MenuFrame.x,MenuFrame.y,MenuFrame.width,MenuFrame.height);
//        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);

        frame.setVisible(true);
        return frame;
    }

//    public static void addText(int width, int height, String str){
//        Dimension labelDimension = new Dimension(width, height);
//        JLabel welcome = new JLabel(str);
//        welcome.setPreferredSize(labelDimension);
//        panel.add(welcome);
//        panel.repaint();
//    }

    public static void addButton(int x, int y, int width, int height, String str){
        DynamicButton button=DynamicButton.createButton(x,y,width,height,str);
        panel.add(button);
        button.addActionListener(new ButtonEvent(button.text));
        panel.repaint();
    }


    public static void close(){
        frame.dispose();
    }

}
