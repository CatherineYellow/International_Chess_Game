package org.chess2022.util;

import javax.swing.*;
import java.awt.*;

public class ImageUtil {

    public static ImageIcon scaledImage(int width, int height,ImageIcon image){
        Image scaledImage=image.getImage().getScaledInstance(width,height,Image.SCALE_DEFAULT);
        image.setImage(scaledImage);
        return image;
    }

}
