package ru.rrozhkov.easykin.gui.style.impl.custom;

import javax.swing.JLabel;
import javax.swing.JTable;

import ru.rrozhkov.easykin.family.IKinPerson;
import ru.rrozhkov.easykin.gui.style.impl.TableStyle;

public class FamilyTableStyle extends TableStyle<IKinPerson> {
	public int[] getColumnAlignment() {
		return new int[]{JLabel.CENTER,JLabel.LEFT,JLabel.LEFT,JLabel.LEFT,JLabel.CENTER};
	}
	
	public String[] getColumnNames() {
		return new String[]{"№","Фамилия","Имя","Отчество","Дата рождения"};
	}
	
	public void setColumnStyles(JTable table){
	    super.setColumnStyles(table);
	    table.getColumnModel().getColumn(0).setPreferredWidth(50);
	    table.getColumnModel().getColumn(1).setMaxWidth(300);
	    table.getColumnModel().getColumn(1).setMinWidth(150);
	    table.getColumnModel().getColumn(2).setMaxWidth(300);
	    table.getColumnModel().getColumn(2).setMinWidth(150);
	    table.getColumnModel().getColumn(3).setMaxWidth(300);
	    table.getColumnModel().getColumn(3).setMinWidth(150);
	    table.getColumnModel().getColumn(4).setMaxWidth(150);
	}
}