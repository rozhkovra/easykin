package ru.rrozhkov.easykin.gui.style;

import javax.swing.JTable;

public interface ITableStyle{
	void setColumnStyles(JTable table);
	String[] getColumnNames();
	void setCellRenderer();
}
