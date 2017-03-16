package ru.rrozhkov.easykin.gui.auth;

import ru.rrozhkov.easykin.auth.AuthManager;
import ru.rrozhkov.easykin.gui.IGUIEditor;

import javax.swing.*;
import java.awt.*;

/**
 * Created by RRozhkov on 3/7/2017.
 */
public class AuthWindow extends JFrame implements IGUIEditor {
    private boolean finished = false;
    public AuthWindow(AuthManager authManager) throws HeadlessException {
        setTitle("Авторизация");
        getContentPane().removeAll();
        getContentPane().add(new AuthForm(this, authManager));
        setSize(400,150);
    }

    public void edit(int index) {

    }

    public void add() {

    }

    public void closeEditor() {
        setVisible(false);
        finished=true;
    }

    public void refresh() {

    }

    public boolean isFinished(){
        return finished;
    }
}
