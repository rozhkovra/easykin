package ru.rrozhkov.easykin.gui.listener;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import ru.rrozhkov.easykin.gui.EasyKinWindow;

public class TableOnClickListener implements ListSelectionListener {
	private EasyKinWindow main;
	
	public TableOnClickListener(EasyKinWindow main) {
		super();
		this.main = main;
	}

	public void valueChanged(ListSelectionEvent arg0) {
		main.edit();
	}
}