package org.chess2022.view;

import org.chess2022.entity.ChessGameFrame;
import org.chess2022.frame.ErrorFrame;

import org.chess2022.frame.MenuFrame;
import org.chess2022.ui.*;
import org.chess2022.values.FrameMod;

import javax.swing.*;
import java.awt.*;
import java.util.ResourceBundle;

public class ViewManager {
    public static ChessGameFrame framenow;
    private static final ResourceBundle bundle=ResourceBundle.getBundle("config");

    private ViewManager(){
    }

    public static void show(FrameMod mod){
        switch (mod){
            case Menu:
                int x=Integer.parseInt(bundle.getString("menu.x"));
                int y=Integer.parseInt(bundle.getString("menu.y"));
                int width=Integer.parseInt(bundle.getString("menu.width"));
                int height=Integer.parseInt(bundle.getString("menu.height"));
                MenuFrame.getFrame(x,y,width,height);
//                MenuFrame.addText(50,30,"Welcome To Game!");
                MenuFrame.addButton(65,50,100,30,"Login");
//                MenuFrame.addButton(65,90,100,30,"Rank");
                break;
            case Game:
                SwingUtilities.invokeLater(() -> {
                    ChessGameFrame mainFrame = new ChessGameFrame(1000, 760);
                    framenow=mainFrame;
                    mainFrame.setVisible(true);
                });
                break;
            case Login:
                MenuFrame.getFrame().setVisible(false);
                Login.main(null);
                break;
            case Error:
                int i=Integer.parseInt(bundle.getString("Error.x"));
                int j=Integer.parseInt(bundle.getString("Error.y"));
                int ewidth=Integer.parseInt(bundle.getString("Error.width"));
                int eheight=Integer.parseInt(bundle.getString("Error.height"));
                ErrorFrame.getFrame(i,j,ewidth,eheight);
                ErrorFrame.addButton(90,150,100,30,"OK");
                ErrorFrame.addLabel();
                break;
//            case Rank:
//                Rank.main(null);
//                break;

        }
    }

    public static void close(FrameMod mod){
        switch (mod){
            case Menu:
                MenuFrame.close();
                break;
            case Game:

                break;

        }
    }
}
