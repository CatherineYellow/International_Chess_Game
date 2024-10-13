package org.chess2022.frame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;

public class MouseEvent extends MouseAdapter {

    private ImageIcon image;
    private DynamicButton button;

    public MouseEvent(ImageIcon image,DynamicButton button){
        this.image=image;
        this.button=button;
    }

    @Override
    public void mouseEntered(java.awt.event.MouseEvent e) {
        button.setIcon(image);
    }

    @Override
    public void mouseExited(java.awt.event.MouseEvent e) {
        button.setIcon(null);
    }

}
