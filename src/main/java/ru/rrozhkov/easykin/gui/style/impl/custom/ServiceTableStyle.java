package ru.rrozhkov.easykin.gui.style.impl.custom;

import java.util.Collection;

import javax.swing.JTable;

import ru.rrozhkov.easykin.gui.style.impl.TableStyle;

public class ServiceTableStyle extends TableStyle {
	public String[] getColumnNames() {
		return new String[]{"№","Описание","Цена","Дата"};
	}
	
	public void setColumnStyles(JTable table){
	    table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	    table.getColumnModel().getColumn(0).setPreferredWidth(50);
	    table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
	    table.getColumnModel().getColumn(1).setMaxWidth(400);
	    table.getColumnModel().getColumn(1).setMinWidth(200);
	    table.getColumnModel().getColumn(2).setMinWidth(150);
	    table.getColumnModel().getColumn(2).setCellRenderer(rightRenderer);
	    table.getColumnModel().getColumn(3).setMaxWidth(150);
	    table.getColumnModel().getColumn(3).setMinWidth(100);
	    table.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
	}

	public void setCellRenderer(JTable table, Collection data) {
	}
}