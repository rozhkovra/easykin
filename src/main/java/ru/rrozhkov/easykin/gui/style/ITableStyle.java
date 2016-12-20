package ru.rrozhkov.easykin.gui.style;

import java.util.Collection;

import javax.swing.JTable;

public interface ITableStyle<T>{
	void setColumnStyles(JTable table);
	String[] getColumnNames();
	void setCellRenderer(JTable table, Collection<T> data);
}
