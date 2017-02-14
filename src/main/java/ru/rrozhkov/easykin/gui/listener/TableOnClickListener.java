package ru.rrozhkov.easykin.gui.listener;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import ru.rrozhkov.easykin.gui.EasyKinWindow;
import ru.rrozhkov.easykin.gui.IGUIEditor;
import ru.rrozhkov.easykin.gui.Table;

public class TableOnClickListener implements ListSelectionListener {
	private IGUIEditor main;
	private Table table;
	
	public TableOnClickListener(IGUIEditor main, Table table) {
		this.main = main;
		this.table = table;
	}

	public void valueChanged(ListSelectionEvent arg0) {
		main.edit(table.getSelectedRow());
	}
}