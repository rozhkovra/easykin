package ru.rrozhkov.easykin.gui;

import java.util.Collection;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JTable;

import ru.rrozhkov.easykin.gui.style.IStyle;

public class TablePanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private JTable table;
	public TablePanel(Collection data, IStyle style) {
		super();
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		table = new Table(data, style);
		add(table.getTableHeader());
		add(table);
	}
	public JTable getTable() {
		return table;
	}
}