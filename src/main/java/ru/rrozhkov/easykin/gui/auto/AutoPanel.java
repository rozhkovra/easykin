package ru.rrozhkov.easykin.gui.auto;

import static ru.rrozhkov.easykin.gui.PanelFactory.createCarPanel;
import static ru.rrozhkov.easykin.gui.PanelFactory.createAutoServicePanel;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class AutoPanel extends JPanel{
	private static final long serialVersionUID = 1L;

	public AutoPanel() {
		setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		add(createCarPanel());
		add(createAutoServicePanel());
	}	
}