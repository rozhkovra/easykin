package ru.rrozhkov.easykin.gui.style.impl;

import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;

import ru.rrozhkov.easykin.gui.style.ITableStyle;

public abstract class TableStyle implements ITableStyle{
    protected static DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
    protected static DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
    protected static DefaultTableCellRenderer leftRenderer = new DefaultTableCellRenderer();

	static {
		rightRenderer.setHorizontalAlignment(JLabel.RIGHT);
	    centerRenderer.setHorizontalAlignment(JLabel.CENTER);
	    leftRenderer.setHorizontalAlignment(JLabel.LEFT);
	}
}