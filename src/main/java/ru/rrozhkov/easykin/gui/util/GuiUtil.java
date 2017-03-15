package ru.rrozhkov.easykin.gui.util;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by rrozhkov on 3/3/2017.
 */
public class GuiUtil {
    public static Component getEmptyLabel() {
        return new JLabel("");
    }
    public static Component getReadOnlyField(int length, String text){
        JTextField field = new JTextField(length);
        field.setEditable(false);
        field.setText(text);
        return field;
    }
    public static Component getEditableField(int length, String text){
        JTextField field = new JTextField(length);
        field.setText(text);
        return field;
    }

    public static Component label(String text){
        return new JLabel(text);
    }

    public static Component button(String text){
        return new JButton(text);
    }
    public static Component button(String text, ActionListener listener){
        JButton button = new JButton(text);
        button.addActionListener(listener);
        return button;
    }
    public static Component button(ImageIcon image, ActionListener listener){
        JButton button = new JButton(image);
        button.addActionListener(listener);
        return button;
    }
    public static Component password(){
        return new JPasswordField();
    }
}
