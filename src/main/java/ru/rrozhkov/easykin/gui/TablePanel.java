package ru.rrozhkov.easykin.gui;

import java.awt.BorderLayout;
import java.util.Collection;

import javax.swing.JPanel;
import javax.swing.JTable;

import ru.rrozhkov.easykin.gui.style.IStyle;

public class TablePanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	public TablePanel(Collection data, IStyle style) {
		super();
		JTable table = new Table(data, style);
		add(table.getTableHeader(), BorderLayout.NORTH);
		add(table);
	}
}