package ru.rrozhkov.easykin.gui.auto;

import static ru.rrozhkov.easykin.gui.PanelFactory.createCarPanel;
import static ru.rrozhkov.easykin.gui.PanelFactory.createServicePanel;

import java.awt.GridLayout;

import javax.swing.JPanel;

public class AutoPanel extends JPanel{
	private static final long serialVersionUID = 1L;

	public AutoPanel() {
		setLayout(new GridLayout(2,1));
		add(createCarPanel());
		add(createServicePanel());
	}	
}