package ru.rrozhkov.easykin.gui.style.impl.custom;

import javax.swing.JTable;

import ru.rrozhkov.easykin.gui.style.impl.TableStyle;

public class TaskTableStyle extends TableStyle  {
	public String[] getColumnNames() {
		return new String[]{"№","Описание","Дата", "Приоритет", "Категория", "Статус"};
	}
	
	public void setColumnStyles(JTable table){
	    table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	    table.getColumnModel().getColumn(0).setPreferredWidth(50);
	    table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
	    table.getColumnModel().getColumn(1).setMinWidth(300);
	    table.getColumnModel().getColumn(1).setMaxWidth(400);
	    table.getColumnModel().getColumn(2).setMinWidth(100);
	    table.getColumnModel().getColumn(2).setMaxWidth(200);
	    table.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
	    table.getColumnModel().getColumn(3).setMinWidth(150);
	    table.getColumnModel().getColumn(3).setMaxWidth(200);
	    table.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
	    table.getColumnModel().getColumn(4).setMinWidth(100);
	    table.getColumnModel().getColumn(4).setMaxWidth(200);
	    table.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
	    table.getColumnModel().getColumn(5).setMinWidth(100);
	    table.getColumnModel().getColumn(5).setMaxWidth(200);
	    table.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);
	}

	public void setCellRenderer() {
		// TODO Auto-generated method stub
		
	}
}
