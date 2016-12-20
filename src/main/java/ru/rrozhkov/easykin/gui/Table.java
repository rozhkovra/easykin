package ru.rrozhkov.easykin.gui;

import java.util.Collection;

import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import ru.rrozhkov.easykin.gui.style.IStyle;

public class Table extends JTable{
	private static final long serialVersionUID = 1L;
	
	protected IStyle style;
	protected Collection data;
	
	public Table(Collection data, IStyle style) {
		super((String[][])style.dataConverter().convert(data, style.tableStyle().getColumnNames().length)
				,style.tableStyle().getColumnNames());
		this.style = style;
		this.data = data;
		getSelectionModel().addListSelectionListener(new ListSelectionListener(){
	        public void valueChanged(ListSelectionEvent event) {
	            System.out.println(getValueAt(getSelectedRow(), 0).toString());
	        }
	    });
	}

	@Override
	public void doLayout() {
		super.doLayout();
		style.tableStyle().setColumnStyles(this);
		style.tableStyle().setCellRenderer(this, data);
	}
		
	@Override
	public String getColumnName(int col) {
	    return style.tableStyle().getColumnNames()[col];
	}
}