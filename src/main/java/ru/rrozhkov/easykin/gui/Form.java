package ru.rrozhkov.easykin.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by rrozhkov on 3/14/2017.
 */
public abstract class Form extends JPanel {
    private JButton okButton;
    private JButton cancelButton;
    protected IGUIEditor parent;

    public Form(IGUIEditor parent) {
        this.parent = parent;
    }

    protected abstract void fill();

    protected KeyListener keyListener(){
        return new KeyListener() {
            public void keyTyped(KeyEvent e) {

            }

            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    ok();
                } else if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    cancel();
                }
            }

            public void keyReleased(KeyEvent e) {

            }
        };
    }
    protected void cancel(){
        parent.closeEditor();
    };

    protected void ok(){};

    protected boolean validateData(){return true;};

    protected JButton getOkButton(){
        if(okButton==null){
            okButton = new JButton("Ок");
            okButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    ok();
                }
            });
        }
        return okButton;
    }

    protected Component getCancelButton() {
        if(cancelButton==null){
            cancelButton = new JButton("Закрыть");
            cancelButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    cancel();
                }
            });
        }
        return cancelButton;
    }
}