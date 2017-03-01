package ru.rrozhkov.easykin.gui.util;

import javax.swing.*;
import java.awt.*;

/**
 * Created by rrozhkov on 3/1/2017.
 */
public class ImageUtil {
    public static ImageIcon scaleImage(int width, int height, ImageIcon imageIcon){
        Image newimg = imageIcon.getImage().getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
        return new ImageIcon(newimg);
    }
}
