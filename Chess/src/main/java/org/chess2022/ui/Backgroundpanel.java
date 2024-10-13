package org.chess2022.ui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Backgroundpanel extends JPanel {
    private File backgroundFile;

    public Backgroundpanel(String backgroundFile) {
        this.backgroundFile = new File(backgroundFile);
    }

    public void setBackgroundFile(String backgroundFile) {
        this.backgroundFile = new File(backgroundFile);
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        BufferedImage image = null;
        try {
            image = ImageIO.read(backgroundFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
    }
}
