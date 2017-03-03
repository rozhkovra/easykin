package ru.rrozhkov.easykin.gui.image;

import ru.rrozhkov.easykin.gui.EasyKinWindow;
import ru.rrozhkov.easykin.gui.util.ImageUtil;

import javax.swing.*;
import java.awt.*;

/**
 * Created by rrozhkov on 3/3/2017.
 */
public class ImageManager {
    public static Image logo(){
        return ImageUtil.imageByPath(EasyKinWindow.class, "/icon/logo.png");
    }
    public static ImageIcon plus(){
        return ImageUtil.imageIconByPath(EasyKinWindow.class, "/icon/plus.png");
    }
    public static ImageIcon refresh(){
        return ImageUtil.imageIconByPath(EasyKinWindow.class, "/icon/refresh1.png");
    }
}
