package ru.rrozhkov.easykin.gui.style.impl.custom;

import javax.swing.JLabel;
import javax.swing.JTable;

import ru.rrozhkov.easykin.gui.style.impl.TableStyle;
import ru.rrozhkov.easykin.service.calc.impl.ServiceCalc;

public class ServiceCalcTableStyle extends TableStyle<ServiceCalc>  {
	public int[] getColumnAlignment() {
		return new int[]{JLabel.CENTER,JLabel.CENTER,JLabel.RIGHT
				,JLabel.RIGHT,JLabel.RIGHT,JLabel.RIGHT,JLabel.RIGHT,JLabel.RIGHT,JLabel.RIGHT,JLabel.RIGHT};
	}
	
	public String[] getColumnNames() {
		return new String[]{"№","Дата", "Вода", "Гор.вода", "Свет", "Газ", "Отопление", "Антенна", "Домофон", "Квартплата"};
	}
	
	public void setColumnStyles(JTable table){
	    super.setColumnStyles(table);
	    table.getColumnModel().getColumn(0).setMinWidth(50);
	    table.getColumnModel().getColumn(0).setMaxWidth(50);
	    table.getColumnModel().getColumn(1).setMinWidth(100);
	    table.getColumnModel().getColumn(1).setMaxWidth(100);
	    table.getColumnModel().getColumn(2).setMinWidth(100);
	    table.getColumnModel().getColumn(2).setMaxWidth(100);
	    table.getColumnModel().getColumn(3).setMinWidth(100);
	    table.getColumnModel().getColumn(3).setMaxWidth(100);
	    table.getColumnModel().getColumn(4).setMinWidth(100);
	    table.getColumnModel().getColumn(4).setMaxWidth(100);
	    table.getColumnModel().getColumn(5).setMinWidth(100);
	    table.getColumnModel().getColumn(5).setMaxWidth(100);
	    table.getColumnModel().getColumn(6).setMinWidth(100);
	    table.getColumnModel().getColumn(6).setMaxWidth(100);
	    table.getColumnModel().getColumn(7).setMinWidth(100);
	    table.getColumnModel().getColumn(7).setMaxWidth(100);
	    table.getColumnModel().getColumn(8).setMinWidth(100);
	    table.getColumnModel().getColumn(8).setMaxWidth(100);

	}
}
