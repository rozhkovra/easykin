package ru.rrozhkov.easykin.gui.image;

import ru.rrozhkov.easykin.gui.EasyKinWindow;
import ru.rrozhkov.easykin.gui.util.ImageUtil;

import javax.swing.*;
import java.awt.*;

/**
 * Created by rrozhkov on 3/3/2017.
 */
public class ImageManager {
    public static Image logo(Class clazz){
        return ImageUtil.imageByPath(clazz, "/icon/logo.png");
    }
    public static ImageIcon plus(Class clazz){
        return ImageUtil.imageIconByPath(clazz, "/icon/plus.png");
    }
    public static ImageIcon refresh(Class clazz){
        return ImageUtil.imageIconByPath(clazz, "/icon/refresh1.png");
    }

    public static ImageIcon filter(Class clazz) {
        return ImageUtil.imageIconByPath(clazz, "/icon/filter.png");
    }
}
