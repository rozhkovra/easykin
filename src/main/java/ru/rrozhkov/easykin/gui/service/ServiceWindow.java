package ru.rrozhkov.easykin.gui.service;

import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ServiceWindow extends JFrame{
	private static final long serialVersionUID = 1L;

	public ServiceWindow(JPanel panel) throws HeadlessException {
		super();
		setContentPane(panel);
    	setExtendedState(ServiceWindow.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        setVisible(true);
	}
}