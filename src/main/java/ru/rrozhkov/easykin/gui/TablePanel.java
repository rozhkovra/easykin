package ru.rrozhkov.easykin.gui;

import java.util.Collection;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import ru.rrozhkov.easykin.gui.style.IStyle;

public class TablePanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private Table table;
	public TablePanel(Collection data, IStyle style) {
		super();
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		table = new Table(data, style);
		add(table.getTableHeader());
		JScrollPane js = new JScrollPane(table);
		js.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		add(js);
	}
	public Table getTable() {
		return table;
	}
}