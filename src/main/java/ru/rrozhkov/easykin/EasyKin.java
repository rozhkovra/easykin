package ru.rrozhkov.easykin;

import ru.rrozhkov.easykin.context.EasyKinContext;
import ru.rrozhkov.easykin.gui.EasyKinWindow;

public class EasyKin 
{
    public static void main( String[] args ) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {   
                new EasyKinWindow(new EasyKinContext().init());   
            }   
        });
    }
}