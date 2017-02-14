package ru.rrozhkov.easykin.gui;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.event.ListSelectionListener;

import ru.rrozhkov.easykin.gui.listener.TableOnClickListener;

public class TablePanel extends JPanel {
	private static final long serialVersionUID = 1L;
	public TablePanel(EasyKinWindow parent, Table table) {
		super();
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		add(table.getTableHeader());
		JScrollPane js = new JScrollPane(table
				, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED
				, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		add(js);
	}
	public TablePanel(EasyKinWindow parent, Table table, boolean listener) {
		this(parent, table);
		if(listener)
			table.getSelectionModel().addListSelectionListener(new TableOnClickListener(parent,table));
	}
}